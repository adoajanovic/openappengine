/**
 * 
 */
package com.ms.openapps.mapper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

import com.ms.openapps.dto.salesorder.FormSalesOrderVO;
import com.ms.openapps.dto.salesorder.ItemMasterVO;
import com.ms.openapps.entity.GenericEntity;
import com.ms.openapps.entity.GenericEntityDelegator;
import com.ms.openapps.entity.delegator.DelegatorNames;
import com.ms.openapps.model.ItItemMaster;

/**
 * @author hrishi
 *
 */
public class FormSalesOrderMapper extends AbstractGenericScreenMapper {

	/* (non-Javadoc)
	 * @see com.ms.openapps.mapper.IScreenMapper#mapScreen()
	 */
	public FormSalesOrderVO mapScreen() {
		FormSalesOrderVO formSalesOrderVO = new FormSalesOrderVO();
		final EntityManager entityManager = getEntityManager();
		entityManager.setFlushMode(FlushModeType.AUTO);
		/*getPlatformTransactionManager().getTransaction(new DefaultTransactionDefinition());*/
		entityManager.getTransaction().begin();
		
		
		GenericEntityDelegator entityDelegator = getGenericEntityDelegator(DelegatorNames.IT_ITEM_MASTER_DELEGATOR);
		List<GenericEntity> list = entityDelegator.findByQueryString(" from ItItemMaster itItemMaster");
		
		if(list != null) {
			for (GenericEntity objItemMaster : list) {
				ItItemMaster itemMaster = (ItItemMaster) objItemMaster;
				ItemMasterVO itemMasterVO = mapItemMasterVO(itemMaster);
				formSalesOrderVO.addItemMasterVO(itemMasterVO);
			}
		}
		
		entityManager.getTransaction().commit();
		
		formSalesOrderVO.getSalesOrderHdr().setCurrency("INR");
		formSalesOrderVO.getSalesOrderHdr().setStatus("A");
		
		return formSalesOrderVO;
	}
	
	private ItemMasterVO mapItemMasterVO(ItItemMaster itemMaster) {
		ItemMasterVO itemMasterVO = new ItemMasterVO();
		itemMasterVO.setCurcode(itemMaster.getCurcode());
		itemMasterVO.setItemId(itemMaster.getItemId());
		itemMasterVO.setName(itemMaster.getName());
		itemMasterVO.setPerishable(itemMaster.isPerishable());
		itemMasterVO.setPrice(itemMaster.getPrice());
		itemMasterVO.setShipCharges(itemMaster.getShipCharges());
		itemMasterVO.setStatus(itemMaster.getStatus());
		itemMasterVO.setType(itemMaster.getType());
		itemMasterVO.setUom(itemMaster.getUom());
		itemMasterVO.setWeight(itemMaster.getWeight());
		return itemMasterVO;
	}

}
