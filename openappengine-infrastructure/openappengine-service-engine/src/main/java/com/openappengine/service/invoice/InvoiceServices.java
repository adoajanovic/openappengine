/**
 * 
 */
package com.openappengine.service.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.openappengine.model.fm.FmInvoice;
import com.openappengine.model.fm.FmInvoiceItem;
import com.openappengine.model.fm.FmInvoiceItemPK;
import com.openappengine.model.fm.OhOrderHeader;
import com.openappengine.model.fm.OiOrderItem;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.service.AbstractDomainService;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceEngineHelper;
import com.openappengine.service.api.ServiceException;
import com.openappengine.utility.DateTimeUtil;
import com.openappengine.utility.UtilValidate;

/**
 * @author hrishi
 *
 */
public class InvoiceServices extends AbstractDomainService {
	
	private int orderId;
	
	private int invoiceId;
	
	private String invoiceReferenceNo;
	
	public void getNextInvoiceReferenceNumber() {
		InvoiceRepository invoiceRepository = getRepository(InvoiceRepository.class);
		int nextOrderNumber = invoiceRepository.nextInvoiceNumber();
		String number = String.format("%05d", nextOrderNumber);
		invoiceReferenceNo = "IN" + number;
	}
	
	public void createInvoiceForOrder() {
		Session session = serviceContext.getHibernateSession();
		OhOrderHeader order = (OhOrderHeader) session.get(OhOrderHeader.class, orderId);
		if(order == null) {
			ServiceEngineHelper.addErrorMessage(this, "No Sales Order found.");
		}
		
		String billingAccountId = order.getBillingAccountId();
		Party party = (Party) session.get(Party.class, Integer.valueOf(billingAccountId));
		if(party == null) {
			ServiceEngineHelper.addErrorMessage(this, "No Party found.");
		}
		
		List<PartyContactMech> partyContactMechs = party.getPartyContactMechs();
		int partyContactMechId = 0;
		if(!UtilValidate.isEmpty(partyContactMechs)) {
			PartyContactMech partyContactMech = partyContactMechs.get(0);
			partyContactMechId = partyContactMech.getPartyContactMechId();
		}
		
		FmInvoice invoice = new FmInvoice();
		invoice.setInBillingAccountId(billingAccountId);
		invoice.setInCurrencyUomId("INR");
		//TODO- invoice.setInDueDate(null);
		
		ServiceDispatcher serviceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
		try {
			Map<String, Object> invoiceReferenceNumberContext = serviceDispatcher.runSync("invoice.getNextInvoiceReferenceNumber", new HashMap<String, Object>());
			String invoiceReferenceNo = (String) invoiceReferenceNumberContext.get("invoiceReferenceNo");
			invoice.setInReferenceNumber(invoiceReferenceNo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		//Todays date as Invoice Date.
		invoice.setInInvoiceDate(DateTimeUtil.nowDate());
		invoice.setInInvoiceTypeId("SALES_INVOICE");
		invoice.setInPartyId(party.getPartyId());
		invoice.setInStatusId("INVOICE_READY");
		
		if(partyContactMechId > 0) {
			invoice.setInContactMechId(partyContactMechId);
		}
		session.save(invoice);
		session.flush();
		
		List<OiOrderItem> orderItems = order.getOrderItems();
		if(!UtilValidate.isEmpty(orderItems)) {
			int seq = 1;
			for (OiOrderItem orderItem : orderItems) {
				String invoiceItemSeqId = "" + (seq++);
				FmInvoiceItem invoiceItem = new FmInvoiceItem();
				
				FmInvoiceItemPK invoiceItemPK = new FmInvoiceItemPK();
				invoiceItemPK.setItInvoiceId(invoice.getInInvoiceId());
				invoiceItemPK.setItInvoiceItemSeqId(invoiceItemSeqId);
				invoiceItem.setId(invoiceItemPK);
				
				invoiceItem.setFmInvoice(invoice);
				invoiceItem.setItAmount(orderItem.getLineTotalPrice());
				invoiceItem.setItDescription(orderItem.getItemDescription());
				invoiceItem.setItInvoiceItemTypeId(orderItem.getOrderItemType());
				invoiceItem.setItProductId(orderItem.getProduct().getPdProductId());
				invoiceItem.setItQuantity(orderItem.getQuantity());
				
				invoice.getFmInvoiceItems().add(invoiceItem);
			}
			
			session.update(invoice);
			session.flush();
			invoiceId = invoice.getInInvoiceId();
		}
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceReferenceNo() {
		return invoiceReferenceNo;
	}

	public void setInvoiceReferenceNo(String invoiceReferenceNo) {
		this.invoiceReferenceNo = invoiceReferenceNo;
	}

}
