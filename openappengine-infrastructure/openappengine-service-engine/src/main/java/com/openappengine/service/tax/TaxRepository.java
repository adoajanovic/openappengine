/**
 * 
 */
package com.openappengine.service.tax;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.openappengine.model.fm.FmTaxType;
import com.openappengine.repository.GenericRepository;

/**
 * @author hrishi
 *
 */
public class TaxRepository extends GenericRepository {

	public List<String> loadAllTaxTypes(Session session) {
		Criteria criteria = session.createCriteria(FmTaxType.class);
		criteria.setProjection(Projections.property("taxDescription"));
		List list = criteria.list();
		return list;
	}
}
