/**
 * 
 */
package com.ms.openapps.web.controller.salesorder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.xml.datatype.XMLGregorianCalendar;

import org.w3c.dom.Document;

import com.ms.openapps.dto.salesorder.FormSalesOrderVO;
import com.ms.openapps.dto.salesorder.ItemMasterVO;
import com.ms.openapps.dto.salesorder.SalesOrderDet;
import com.ms.openapps.dto.salesorder.SalesOrderHdr;
import com.ms.openapps.mapper.FormSalesOrderMapper;
import com.ms.openapps.oxm.IOxmMapper;
import com.ms.openapps.oxm.OxmMapperContext;
import com.ms.openapps.oxm.OxmMappingException;
import com.ms.openapps.oxm.converter.UtilXMLGregorianCalendar;
import com.ms.openapps.service.constants.ServiceNames;
import com.ms.openapps.service.facade.ServiceFacade;
import com.ms.openapps.web.controller.GenericFormController;
import com.openappengine.salesorder.types.CreateSalesOrderRequest;
import com.openappengine.salesorder.types.SalesDet;
import com.openappengine.salesorder.types.SalesHdr;

/**
 * @author hrishi
 * 
 */
public class SalesOrderController extends GenericFormController {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(getClass().getName());

	private FormSalesOrderVO formSalesOrderVO = new FormSalesOrderVO();

	private int selectedItemId;

	private Map<Integer, ItemMasterVO> map;

	public SalesOrderController() {
		logger.info("SalesOrderController initialized");

		FormSalesOrderMapper mapper = new FormSalesOrderMapper();
		formSalesOrderVO = mapper.mapScreen();

		List<ItemMasterVO> itemMasterVOs = formSalesOrderVO.getItemMasterVOs();
		createMap(itemMasterVOs);
	}

	private void createMap(List<ItemMasterVO> list) {
		if (list != null) {
			map = new HashMap<Integer, ItemMasterVO>();
			for (ItemMasterVO itemMasterVO : list) {
				map.put(itemMasterVO.getItemId(), itemMasterVO);
			}
		}
	}

	public List<SelectItem> getItItemMasterList() {
		List<ItemMasterVO> itemMasterVOs = formSalesOrderVO.getItemMasterVOs();
		List<SelectItem> itItemMasterList = new ArrayList<SelectItem>();
		if (itemMasterVOs != null) {
			for (ItemMasterVO itemMasterVO : itemMasterVOs) {
				SelectItem selectItem = new SelectItem();
				selectItem.setDescription(itemMasterVO.getName());
				selectItem.setLabel(itemMasterVO.getName());
				selectItem.setValue(itemMasterVO.getItemId());
				itItemMasterList.add(selectItem);
			}
		}
		return itItemMasterList;
	}

	public void openPopupAddLineItem(ActionEvent actionEvent) {
		logger.info("Opening Popup Window to Add Line Item");
	}

	public void addLineItem(ActionEvent actionEvent) {
		logger.info("Adding Line Item");
		if (actionEvent != null) {
			SalesOrderDet newSalesOrderDet = formSalesOrderVO.getNewSalesOrderDet();
			Long itemId = newSalesOrderDet.getItemId();
			if (itemId == null) {
				// TODO - Add Validation
				return;
			}

			ItemMasterVO itemMasterVO = map.get(itemId.intValue());
			newSalesOrderDet.setItemName(itemMasterVO.getName());
			formSalesOrderVO.getSalesOrderDets().add(newSalesOrderDet);
			
			setSalesHdr();
			formSalesOrderVO.setNewSalesOrderDet(new SalesOrderDet());
		}
	}
	
	private void setSalesHdr() {
		SalesOrderHdr salesOrderHdr = formSalesOrderVO.getSalesOrderHdr();
		List<SalesOrderDet> salesOrderDets = formSalesOrderVO.getSalesOrderDets();
		
		Double price = new Double(new Double(0.0));
		Double quantity = new Double(new Double(0.0));
		Double weight = new Double(new Double(0.0));
		
		for (SalesOrderDet salesOrderDet : salesOrderDets) {
			price += salesOrderDet.getPrice();
			quantity += salesOrderDet.getQuantity();
			weight += salesOrderDet.getWeight();
			
			salesOrderHdr.setTotalAmount(price);
			salesOrderHdr.setTotalQuantity(quantity);
			//salesOrderHdr.setTotalTax(salesOrderHdr.getTotalTax() + quantity);
			salesOrderHdr.setTotalWeight(weight);
		}
		
		salesOrderHdr.setTotalAmount(price);
		salesOrderHdr.setTotalQuantity(quantity);
		salesOrderHdr.setTotalTax(new Double(0.0));
		salesOrderHdr.setTotalWeight(weight);
	}

	public void itemChanged(ValueChangeEvent changeEvent) {
		if (null != changeEvent.getNewValue()) {
			logger.info("Fetching Info for Item " + changeEvent.getNewValue());
			Long id = (Long) changeEvent.getNewValue();
			if (id != null && map.containsKey(id)) {
				ItemMasterVO itemMasterVO = map.get(id);

			}
		}
	}

	/* Actions */
	public String createSalesOrder() {
		SalesHdr salesHdr = new SalesHdr();
		salesHdr.setCurCode(formSalesOrderVO.getSalesOrderHdr().getCurrency());
		salesHdr.setModePay(formSalesOrderVO.getSalesOrderHdr().getPayMode());
		XMLGregorianCalendar ordDate = UtilXMLGregorianCalendar
				.asXMLGregorianCalendar(formSalesOrderVO.getSalesOrderHdr()
						.getOrderDate());
		salesHdr.setOrdDate(ordDate);
		salesHdr.setOrdType(formSalesOrderVO.getSalesOrderHdr().getOrderType());
		//TODO - Party ID
		salesHdr.setPartyId(new BigInteger("" + 1));
		salesHdr.setStatus(formSalesOrderVO.getSalesOrderHdr().getStatus());
		salesHdr.setTotAmt(new BigDecimal(0));
		salesHdr.setTotQty(new BigDecimal(0));
		salesHdr.setTotTax(new BigDecimal(0));
		salesHdr.setTotWeight(new BigDecimal(0));
		//TODO - User
		salesHdr.setUser("Demo");

		int i = 1;
		for (SalesOrderDet det : formSalesOrderVO.getSalesOrderDets()) {
			SalesDet salesDet = new SalesDet();
			salesDet.setItemId(new BigInteger("" + det.getItemId().intValue()));
			salesDet.setCost(new BigDecimal(det.getPrice()));
			salesDet.setPrice(new BigDecimal(det.getPrice()));
			salesDet.setLineNo(new BigInteger("" + (i++)));
			salesDet.setQtyOrd(new BigDecimal(det.getQuantity()));
			//TODO - UOM
			salesDet.setUOM("EACH");
			//TODO - User
			salesDet.setUser("Demo");
			salesDet.setWeight(new BigDecimal(det.getWeight()));
			salesDet.setOrdType(salesHdr.getOrdType());
			salesHdr.getSalesDet().add(salesDet);
		}

		CreateSalesOrderRequest salesOrderRequest = new CreateSalesOrderRequest();
		salesOrderRequest.setSalesHdr(salesHdr);
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		try {
			Document marshalObject = oxmMapper.marshalObject(salesOrderRequest);
			Document result = ServiceFacade.callXmlService(
					ServiceNames.SERVICE_CREATE_SALES_ORDER, marshalObject);
			// CreateSalesOrderResponse unmarshalledResObj =
			// (CreateSalesOrderResponse) oxmMapper.unmarshal(result);
			// System.out.println(unmarshalledResObj);
		} catch (OxmMappingException e) {
			e.printStackTrace();
			addErrorMessage("Action Failed : Create Sales Order.");
			return null;
		}
		addSuccessMessage("Action Completed : Create Sales Order");
		return null;
	}

	/* Accessor Methods */
	public FormSalesOrderVO getFormSalesOrderVO() {
		return formSalesOrderVO;
	}

	public void setFormSalesOrderVO(FormSalesOrderVO formSalesOrderVO) {
		this.formSalesOrderVO = formSalesOrderVO;
	}

	public int getSelectedItemId() {
		return selectedItemId;
	}

	public void setSelectedItemId(int selectedItemId) {
		this.selectedItemId = selectedItemId;
	}

}
