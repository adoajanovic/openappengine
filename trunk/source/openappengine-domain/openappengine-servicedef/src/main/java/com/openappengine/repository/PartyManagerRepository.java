/**
 * 
 */
package com.openappengine.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.openappengine.model.party.Party;

/**
 * @author hrishi
 *
 */
public class PartyManagerRepository extends GenericRepository<Party> {
	
	public Long nextSequenceId() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Party.class);
		criteria.setProjection(Projections.property("externalId")).addOrder(Order.desc("partyId"));
		List list = hibernateTemplate.findByCriteria(criteria);
		if(list != null && !list.isEmpty()) {
			String externalId = (String) list.get(0);
			long nextSeqId = Long.parseLong(externalId) + 1;
			return nextSeqId;
		}
		return null;
	}

}
