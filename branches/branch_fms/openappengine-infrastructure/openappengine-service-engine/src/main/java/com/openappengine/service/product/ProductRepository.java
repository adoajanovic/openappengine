/**
 * 
 */
package com.openappengine.service.product;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.openappengine.model.product.ProdProductType;
import com.openappengine.model.product.Product;
import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.RepositoryUtils;

/**
 * @author hrishikesh.joshi
 * @since  Apr 3, 2012
 *
 */
public class ProductRepository extends GenericRepository {

	@SuppressWarnings("unchecked")
	public List<ProdProductType> fetchAllProductTypes() {
		Session session = RepositoryUtils.getExistingSession();
		Criteria criteria = session.createCriteria(ProdProductType.class);
		return criteria.list();
	}
	
	public void saveProduct(Product product) {
		Session session = RepositoryUtils.getExistingSession();
		Criteria criteria = session.createCriteria(ProdProductType.class);
		
		session.save(product);
	}
	
	public ProdProductType getProdProductType(String type) {
		Session session = RepositoryUtils.getExistingSession();
		Criteria criteria = session.createCriteria(ProdProductType.class);
		criteria.add(Restrictions.eq("ptProductTypeDesc", type));
		List list = criteria.list();
		if(list != null && !list.isEmpty()) {
			return (ProdProductType) list.get(0);
		}
		
		return null;
	}
}
