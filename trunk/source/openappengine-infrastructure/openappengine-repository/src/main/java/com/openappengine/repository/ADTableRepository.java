/**
 * 
 */
package com.openappengine.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADTable;

/**
 * @author hrishi
 *
 */
public class ADTableRepository extends GenericRepository<ADTable> {
	
	public List<String> listAllApplicationTableNames() {
		String fetchAllTablesQuery = "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME NOT LIKE :prefix";
		String value = ADTable.AD_MODULE_PREFIX + "%";
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(fetchAllTablesQuery);
		sqlQuery.setString("prefix", value);
		List tables = sqlQuery.list();
		session.close();
		return tables;
	}
	
	public ADTable getAdTable(String adTableName) {
		List<ADColumn> columns = listAllColumns(adTableName);
		DetachedCriteria criteria = DetachedCriteria.forClass(ADTable.class).add(Restrictions.eq("tableName", adTableName));
		List list = hibernateTemplate.findByCriteria(criteria);
		ADTable adTable;
		if(list != null && !list.isEmpty()) {
			adTable = (ADTable) list.get(0);
			return adTable;
		} 
		adTable = new ADTable();
		adTable.setTableName(adTableName);
		adTable.setAdColumns(columns);
		return adTable;
	}
	

	public List<ADColumn> listAllColumns(String applicationTableName) {
		String query = "SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME LIKE :tableName";
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setString("tableName", applicationTableName);
		List columnNames = sqlQuery.list();
		
		Criteria criteria = session.createCriteria(ADTable.class)
				.add(Restrictions.eq("tableName", applicationTableName));
				
		ADTable adTable = (ADTable) criteria.uniqueResult();
		
		List<ADColumn> storedADColumns = new ArrayList<ADColumn>();
		if(adTable != null) {
			storedADColumns = adTable.getAdColumns();
		}
		
		List<ADColumn> adColumns = new ArrayList<ADColumn>();
		adColumns.addAll(storedADColumns);
		
		if(columnNames != null && !columnNames.isEmpty()) {
			for (Object column : columnNames) {
				String columnName = (String) column;
				ADColumn adColumn = new ADColumn();
				adColumn.setColumnName(columnName);
				
				if(!storedADColumns.contains(adColumn)) {
					adColumns.add(adColumn);
				}
			}
		}
		session.close();
		return adColumns;
	}

}
