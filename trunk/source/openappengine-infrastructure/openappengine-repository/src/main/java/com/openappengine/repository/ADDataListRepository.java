/**
 * 
 */
package com.openappengine.repository;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.openappengine.model.ad.ADDataList;
import com.openappengine.model.ad.ADDataListType;

/**
 * @author hrishi
 *
 */
public class ADDataListRepository extends GenericRepository<ADDataList> {

    /**
     * List AD Data List by List Type.
     * @param type
     * @return {@link ADDataList}
     */
    public List<ADDataList> listADDataList(String type) {
	if(StringUtils.isEmpty(type)) {
	    return null;
	}
	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ADDataListType.class);
	detachedCriteria.add(Restrictions.eq("name", type)).setProjection(Projections.property("adDataList"));
	List list = this.hibernateTemplate.findByCriteria(detachedCriteria);
	return list;
    }
    
}
