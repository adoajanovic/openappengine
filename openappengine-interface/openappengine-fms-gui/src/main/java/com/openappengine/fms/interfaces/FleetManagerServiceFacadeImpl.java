package com.openappengine.fms.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.util.Assert;

import com.openappengine.fms.interfaces.dto.ContactMechDTO;
import com.openappengine.fms.interfaces.dto.ContactMechDTOAssembler;
import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.interfaces.dto.CustomerDTOAssembler;
import com.openappengine.fms.interfaces.dto.CustomerSearchResultDTO;
import com.openappengine.fms.interfaces.dto.OrderListItemDTO;
import com.openappengine.fms.interfaces.dto.OrderSearchDTO;
import com.openappengine.fms.interfaces.dto.ProductAmountDTO;
import com.openappengine.fms.interfaces.dto.ProductDTO;
import com.openappengine.fms.interfaces.dto.ProductDTOAssembler;
import com.openappengine.fms.interfaces.dto.ProductItemListDTO;
import com.openappengine.fms.interfaces.dto.ProductTypeDTO;
import com.openappengine.fms.interfaces.dto.SalesOrderDTO;
import com.openappengine.fms.interfaces.dto.SalesOrderDTO.LineItemDTO;
import com.openappengine.model.fm.OhOrderHeader;
import com.openappengine.model.fm.OiOrderItem;
import com.openappengine.model.party.Address;
import com.openappengine.model.party.Party;
import com.openappengine.model.party.PartyContactMech;
import com.openappengine.model.party.Person;
import com.openappengine.model.product.ProdProductPrice;
import com.openappengine.model.product.ProdProductType;
import com.openappengine.model.product.Product;
import com.openappengine.repository.HibernateUtils;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;
import com.openappengine.utility.DateTimeUtil;
import com.openappengine.utility.UtilValidate;
	
/**
 * 
 * @author hrishi
 */
public class FleetManagerServiceFacadeImpl implements FleetManagerServiceFacade {
	
	private ServiceDispatcher serviceDispatcher;
	
	public FleetManagerServiceFacadeImpl() {
		serviceDispatcher = ServiceEngineContext.getDefaultServiceDispatcher();
	}

	@Override
	public CustomerDTO loadCustomerDTO(Integer partyId) {
		HibernateUtils.openSession();
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Person person;
		try {
			context.put("personId", partyId);
			resultMap = serviceDispatcher.runSync("party.findPersonById", context);
		} catch (ServiceException e) {
			person = null;
		}
		
		person = (Person) resultMap.get("person");
		
		List<PartyContactMech> partyContactMechs = person.getPartyContactMechs();
		partyContactMechs.toString();
		
		CustomerDTOAssembler assembler = new CustomerDTOAssembler();
		CustomerDTO dto = assembler.toDTO(person);
		
		HibernateUtils.closeSession();
		return dto;
	}

	@Override
	public void saveCustomer(CustomerDTO dto) {
		HibernateUtils.openSession();
		String serviceName = "";
		serviceName = "party.createPerson";
		Person person = new CustomerDTOAssembler().fromDTO(dto);
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new HashMap<String, Object>();
		context.put("person", person);
		
		List<PartyContactMech> contactMechs = new ArrayList<PartyContactMech>(); 
		List<ContactMechDTO> contactMechDTOs = dto.getContactMechDTOs();
		if(contactMechDTOs != null) {
			for (ContactMechDTO contactMechDTO : contactMechDTOs) {
				contactMechs.add(new ContactMechDTOAssembler().fromDTO(contactMechDTO));
			}
		}
		context.put("partyContactMechs", contactMechs);
		try {
			sd.runSync(serviceName, context);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		HibernateUtils.closeSession();
	}
	
	@Override
	public void updateCustomer(CustomerDTO dto) {
		Session session = HibernateUtils.openSession();
		String serviceName = "";
		serviceName = "party.updatePerson";
		Person person = new CustomerDTOAssembler().fromDTO(dto);
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new HashMap<String, Object>();
		List<ContactMechDTO> contactMechDTOs = dto.getContactMechDTOs();
		
		List<PartyContactMech> contactMechs = new ArrayList<PartyContactMech>(); 
		if(contactMechDTOs != null) {
			for (ContactMechDTO contactMechDTO : contactMechDTOs) {
				contactMechs.add(new ContactMechDTOAssembler().fromDTO(contactMechDTO));
			}
		}
		context.put("person", person);
		context.put("partyContactMechs", contactMechs);
		try {
			sd.runSync(serviceName, context);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		HibernateUtils.closeSession();
	}

	@Override
	public List<CustomerDTO> loadActiveCustomerDTOs() {
		HibernateUtils.openSession();
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new java.util.HashMap<String, Object>();
		
		java.util.Map<String, Object> resultMap = new java.util.HashMap<String, Object>();
		try {
			resultMap = sd.runSync("party.fetchProductTypes", context);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>) resultMap.get("personPartyList");
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		if(personList != null) {
			CustomerDTOAssembler assembler = new CustomerDTOAssembler();
			for (Person person : personList) {
				CustomerDTO dto = assembler.toDTO(person);
				customerDTOs.add(dto);
			}
		}
		HibernateUtils.closeSession();
		return customerDTOs;
	}
	
	@Override
	public void addNewProduct(ProductDTO dto) {
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Product product = new ProductDTOAssembler().fromDTO(dto);
		context.put("product", product);
				
		Session session = null;
		try {
			session = HibernateUtils.openSession();
			
			resultMap = serviceDispatcher.runSync("product.addNewProduct", context);
			product = (Product) resultMap.get("product");
			
			//Add List Price
			context = new HashMap<String, Object>();
			context.put("product", product);
			context.put("listPrice", dto.getListPrice());
			context.put("fromDate", dto.getIntroductionDate());
			context.put("toDate", dto.getSalesDiscontinuationDate());
			serviceDispatcher.runSyncIgnoreResult("product.addListPrice", context);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			if(session != null) {
				Transaction transaction = session.getTransaction();
				if(transaction != null) {
					if(!transaction.wasRolledBack()) {
						transaction.rollback();
					}
				}
			}
			throw new FleetManagerServiceException("Exception encountered while calling Service Engine.");
		} finally {
			HibernateUtils.closeSession();
		}
		
	}

	@Override
	public org.apache.pivot.collections.List<ProductItemListDTO> getAllActiveProducts() {
		HibernateUtils.openSession();
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		org.apache.pivot.collections.List<ProductItemListDTO> prods = new org.apache.pivot.collections.ArrayList<ProductItemListDTO>();
		
		try {
			resultMap = serviceDispatcher.runSync("product.loadAllActiveProducts", context);
		} catch (ServiceException e) {
		}
		
		List<Product> products = (List<Product>) resultMap.get("products");
		
		if(products != null) {
			for (Product product : products) {
				ProductItemListDTO dto = new ProductItemListDTO();
				dto.setProductId(product.getPdProductId());
				dto.setProductName(product.getPdProductName());
				dto.setProductId(product.getPdProductId());
				
				List<ProdProductPrice> prodProductPrices = product.getProdProductPrices();
				BigDecimal listPrice = new BigDecimal(0.0);
				if(prodProductPrices != null) {
					for (ProdProductPrice prodProductPrice : prodProductPrices) {
						if(prodProductPrice.getProdProductPriceType() != null) {
							if(prodProductPrice.getProdProductPriceType().getPtDescription().equals("LIST PRICE")) {
								listPrice = prodProductPrice.getPpPrice();
								dto.setNetPrice(listPrice);
							}
						}
					}
				}
				
				ProdProductType prodProductType = product.getProdProductType();
				ProductTypeDTO typeDTO = new ProductTypeDTO();
				typeDTO.setProductTypeDesc(prodProductType.getPtProductTypeDesc());
				typeDTO.setProductTypeId(prodProductType.getPtProductTypeId());
				
				//
				Map<String, Object> context1 = new HashMap<String, Object>();
				Map<String, Object> resultMap1 = new HashMap<String, Object>();
				context1.put("productType", prodProductType);
				context1.put("listPrice", listPrice);
				try {
					resultMap1 = serviceDispatcher.runSync("product.calculateTax", context1);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
				ProductAmountDTO productAmountDTO = new ProductAmountDTO();
				productAmountDTO.setCalculatedTax((BigDecimal) resultMap1.get("calculatedTax"));
				productAmountDTO.setPriceGross((BigDecimal) resultMap1.get("priceGross"));
				productAmountDTO.setListPrice(listPrice);
				
				dto.setTaxPrice(productAmountDTO.getCalculatedTax());
				dto.setTotalProductPrice(productAmountDTO.getPriceGross());
				
				prods.add(dto);
			}
		}
		HibernateUtils.closeSession();
		return prods;
	}
	
	
	@Override
	public org.apache.pivot.collections.List<CustomerSearchResultDTO> findPartyByName(String firstName, String middleName,String lastName) {
		HibernateUtils.openSession();
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		org.apache.pivot.collections.List<CustomerSearchResultDTO> customerSearchResults = new org.apache.pivot.collections.ArrayList<CustomerSearchResultDTO>();
		
		context.put("firstName", firstName);
		context.put("middleName", middleName);
		context.put("lastName", lastName);
		
		try {
			resultMap = serviceDispatcher.runSync("party.findPersonsByName", context);
		} catch (ServiceException e) {
			
		}
		
		List<Person> persons = (List<Person>) resultMap.get("persons");
		if(persons != null) {
			for (Person person : persons) {
				CustomerSearchResultDTO dto = new CustomerSearchResultDTO();
				dto.setSalutation(person.getSalutation());
				dto.setStatus(person.getStatus());
				dto.setPartyId(person.getPartyId());
				dto.setFirstName(person.getFirstName());
				dto.setMiddleName(person.getMiddleName());
				dto.setLastName(person.getLastName());
				
				List<Address> addresses = person.getAddresses();
				if(addresses != null && !addresses.isEmpty()) {
					Address address = addresses.get(0);
					dto.setAddress1(address.getAddress1());
					dto.setAddress2(address.getAddress2());
					dto.setCity(address.getCity());
				}
				
				List<PartyContactMech> partyContactMechs = person.getPartyContactMechs();
				if(partyContactMechs != null && !partyContactMechs.isEmpty()) {
					for (PartyContactMech partyContactMech : partyContactMechs) {
						String infoString = partyContactMech.getInfoString();
						if(StringUtils.equalsIgnoreCase(partyContactMech.getContactMechType(),"EMAIL")) {
							if(StringUtils.isEmpty(dto.getEmail1())) {
								dto.setEmail1(infoString);
							} else {
								dto.setEmail2(infoString);
							}
						} else if(StringUtils.equalsIgnoreCase(partyContactMech.getContactMechType(),"PHONE_Residence")) {
							dto.setResidenceNo(infoString);
						}  else if(StringUtils.equalsIgnoreCase(partyContactMech.getContactMechType(),"PHONE_Mobile")) {
							dto.setMobileNo(infoString);
						}
					}
				}
				
				customerSearchResults.add(dto);
			}
		}
		
		HibernateUtils.closeSession();
		return customerSearchResults;
	}
	
	@Override
	public List<ProductTypeDTO> loadAllProductTypes() {
		HibernateUtils.openSession();
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			resultMap = serviceDispatcher.runSync("product.findAllProductTypes", context);
		} catch (ServiceException e) {
		}
		
		List<ProdProductType> productTypes = (List<ProdProductType>) resultMap.get("productTypes");
		List<ProductTypeDTO> productTypeDTOs = new ArrayList<ProductTypeDTO>();
		if(productTypes != null) {
			for (ProdProductType prodProductType : productTypes) {
				ProductTypeDTO dto = new ProductTypeDTO();
				dto.setProductTypeDesc(prodProductType.getPtProductTypeDesc());
				dto.setProductTypeId(prodProductType.getPtProductTypeId());
				productTypeDTOs.add(dto);
			}
		}
		
		HibernateUtils.closeSession();
		return productTypeDTOs;
	}
	
	@Override
	public ProductAmountDTO calculateTaxAmount(ProductTypeDTO dto, BigDecimal listPrice) {
		HibernateUtils.openSession();
		
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		ProdProductType type = new ProdProductType();
		type.setPtProductTypeId(dto.getProductTypeId());
		type.setPtProductTypeDesc(dto.getProductTypeDesc());
		
		context.put("productType", type);
		context.put("listPrice", listPrice);
		try {
			resultMap = serviceDispatcher.runSync("product.calculateTax", context);
		} catch (ServiceException e) {
		}
		
		HibernateUtils.closeSession();
		
		ProductAmountDTO productAmountDTO = new ProductAmountDTO();
		productAmountDTO.setCalculatedTax((BigDecimal) resultMap.get("calculatedTax"));
		productAmountDTO.setPriceGross((BigDecimal) resultMap.get("priceGross"));
		productAmountDTO.setListPrice(listPrice);
		return productAmountDTO;
	}
	
	@Override
	public String getSalesOrderExternalId() throws ServiceException {
		HibernateUtils.openSession();
		Map<String, Object> context = new HashMap<String, Object>();
		Map<String, Object> res = serviceDispatcher.runSync("order.getNextOrderNumber", context);
		String orderNumber = (String) res.get("orderNumber");
		HibernateUtils.closeSession();
		return orderNumber;
	}
	
	@Override
	public void createOrder(SalesOrderDTO salesOrderDTO) {
		if(salesOrderDTO == null) {
			throw new FleetManagerServiceException("No instance of SalesOrder found.");
		}
		
		OhOrderHeader orderHeader = new OhOrderHeader();
		
		if(salesOrderDTO.getParty() == null) {
			throw new FleetManagerServiceException("No party attached with the Sales Order.");
		}
		
		int partyId = salesOrderDTO.getParty().getPartyId();
		orderHeader.setBillingAccountId(""+partyId);
		orderHeader.setCurrencyUom("INR");
		orderHeader.setEntryDate(DateTimeUtil.nowDate());
		orderHeader.setOrderDate(DateTimeUtil.nowDate());
		orderHeader.setExternalId(salesOrderDTO.getExternalId()); 
		
		BigDecimal grandTotal = salesOrderDTO.getGrandTotal();
		orderHeader.setGrandTotal(grandTotal);
		
		orderHeader.setOrderType("SALES_ORDER");
		orderHeader.setOrderName(salesOrderDTO.getOrderName());
		orderHeader.setStatus("ORDER_CREATED");	//TODO
		
		if(salesOrderDTO.getLineItems() == null || salesOrderDTO.getLineItems().isEmpty()) {
			throw new FleetManagerServiceException("No Line items found. Cannot create Order");
		}
		
		org.apache.pivot.collections.List<LineItemDTO> lineItems = salesOrderDTO.getLineItems();
		for (LineItemDTO lineItemDTO : lineItems) {
			OiOrderItem item = new OiOrderItem();
			item.setOrderHeader(orderHeader);
			item.setItemDescription(lineItemDTO.getProductName());
			item.setOrderItemSequenceId(""+lineItemDTO.getLineNo());
			item.setOrderItemType("SV");
			
			Product product = HibernateUtils.findOneById(lineItemDTO.getProductId(), Product.class);
			if(product == null) {
				throw new FleetManagerServiceException("No product found for line no " + lineItemDTO.getLineNo());
			}
			item.setProduct(product);
			item.setQuantity(lineItemDTO.getQuantity());
			item.setUnitListPrice(lineItemDTO.getUnitPrice());
			item.setUnitPrice(lineItemDTO.getUnitPrice());
			item.setTaxPrice(lineItemDTO.getTax());
			item.setLineTotalPrice(lineItemDTO.getTotal());
			item.setStatus("ORDER_ITEM_STORED");
			
			orderHeader.getOrderItems().add(item);
		}
		
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("orderHeader", orderHeader);
		Map<String, Object> orderResultContext = null;
		try {
			orderResultContext = serviceDispatcher.runSync("order.createOrder", context);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(orderResultContext != null && orderResultContext.containsKey("orderId")) {
			Integer orderId = (Integer) orderResultContext.get("orderId");
			
			Map<String,Object> createInvoiceContext = new HashMap<String, Object>();
			createInvoiceContext.put("orderId", orderId);
			try {
				serviceDispatcher.runSync("invoice.createInvoice", createInvoiceContext);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HibernateUtils.closeSession();
	}
	
	@Override
	public org.apache.pivot.collections.List<OrderListItemDTO> loadOrderListItems(OrderSearchDTO orderSearchDTO) {
		HibernateUtils.openSession();
		Map<String, Object> context = new HashMap<String, Object>();
		org.apache.pivot.collections.List<OrderListItemDTO> dtos = new org.apache.pivot.collections.ArrayList<OrderListItemDTO>();
		try {
			context.put("status", orderSearchDTO.getOrderStatus());
			context.put("fromDate", orderSearchDTO.getFromDate());
			context.put("toDate",orderSearchDTO.getToDate());
			context.put("externalId", orderSearchDTO.getExternalId());
			
			Map<String, Object> result = serviceDispatcher.runSync("order.findOrders", context);
			List<OhOrderHeader> orderHeaders = (List<OhOrderHeader>) result.get("orders");
			if(!UtilValidate.isEmpty(orderHeaders)) {
				for (OhOrderHeader ohOrderHeader : orderHeaders) {
					OrderListItemDTO dto = new OrderListItemDTO();
					
					dto.setExternalId(ohOrderHeader.getExternalId());
					dto.setGrandTotal(ohOrderHeader.getGrandTotal());
					dto.setOrderDate(ohOrderHeader.getOrderDate());
					dto.setOrderName(ohOrderHeader.getOrderName());
					dto.setStatus(ohOrderHeader.getStatus());
					
					List<OiOrderItem> orderItems = ohOrderHeader.getOrderItems();
					if(!UtilValidate.isEmpty(orderItems)) {
						BigDecimal totalTax = new BigDecimal(0.0);
						for (OiOrderItem oiOrderItem : orderItems) {
							totalTax = totalTax.add(oiOrderItem.getTaxPrice());
						}
						
						dto.setTotalTax(totalTax);
					}
					dtos.add(dto);
				}
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtils.closeSession();
		return dtos;
	}
	
	@Override
	public SalesOrderDTO getSalesOrderDTO(String externalId) {
		SalesOrderDTO dto = new SalesOrderDTO();
		Session session = HibernateUtils.openSession();
		
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("externalId", externalId);
		try {
			Map<String, Object> resultMap = serviceDispatcher.runSync("order.findOrderByExternalId", context);
			OhOrderHeader orderHeader = (OhOrderHeader) resultMap.get("orderHeader");
			if(orderHeader != null) {
				dto.setExternalId(orderHeader.getExternalId());
				dto.setGrandTotal(orderHeader.getGrandTotal());
				dto.setOrderName(orderHeader.getOrderName());
				
				CustomerDTO partyDTO = new CustomerDTO();
				String billingAccountId = orderHeader.getBillingAccountId();
				
				Person party = (Person) session.get(Person.class, Integer.valueOf(billingAccountId));
				partyDTO = new CustomerDTOAssembler().toDTO(party);
				dto.setParty(partyDTO);
				
				org.apache.pivot.collections.List<LineItemDTO> lineItems = new org.apache.pivot.collections.ArrayList<SalesOrderDTO.LineItemDTO>();
				List<OiOrderItem> orderItems = orderHeader.getOrderItems();
				if(!UtilValidate.isEmpty(orderItems)) {
					for (OiOrderItem oiOrderItem : orderItems) {
						LineItemDTO lineItemDTO = dto.new LineItemDTO();
						lineItemDTO.setLineNo(Integer.valueOf(oiOrderItem.getOrderItemSequenceId()));
						lineItemDTO.setNetPrice(lineItemDTO.getNetPrice());
						lineItemDTO.setProductId(lineItemDTO.getProductId());
						
						Product prod = (Product) session.get(Product.class, lineItemDTO.getProductId());
						if(prod != null) {
							lineItemDTO.setProductName(prod.getPdProductName());
						}
						lineItemDTO.setQuantity(oiOrderItem.getQuantity());
						lineItemDTO.setTax(oiOrderItem.getTaxPrice());
						lineItemDTO.setUnitPrice(oiOrderItem.getUnitPrice());
						lineItemDTO.setTotal(oiOrderItem.getLineTotalPrice());
						
						lineItems.add(lineItemDTO);
					}
				}
				dto.setLineItems(lineItems);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		HibernateUtils.closeSession();
		return dto;
	}
	
	@Override
	public void cancelSalesOrder(String externalId) {
		Assert.notNull(externalId,"OrderId cannot be null.");
		HibernateUtils.openSession();
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("status", "ORDER_CANCELLED");
		context.put("externalId", externalId);
		
		try {
			serviceDispatcher.runSyncIgnoreResult("order.changeOrderStatus", context);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtils.closeSession();
	}
	
}
