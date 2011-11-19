/**
 * 
 */
package com.openappengine.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.openappengine.model.ad.ADTable;

/**
 * @author hrishi
 *
 */
public class ApplicationDictionaryRepository extends GenericRepository<ADTable> {
	
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
	

	public List<String> listAllColumns(String applicationTableName) {
		String query = "SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME LIKE :tableName";
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setString("tableName", applicationTableName);
		List columns = sqlQuery.list();
		session.close();
		return columns;
	}

}
