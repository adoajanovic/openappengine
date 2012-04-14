package com.openappengine.service.tax;

import java.util.List;

import com.openappengine.service.AbstractDomainService;

public class TaxServices extends AbstractDomainService {
	
	private List<String> taxTypes;
	
	public void loadAllTaxTypes() {
		TaxRepository taxRepository = getRepository(TaxRepository.class);
		taxTypes = taxRepository.loadAllTaxTypes(serviceContext.getHibernateSession());
	}

	public List<String> getTaxTypes() {
		return taxTypes;
	}

	public void setTaxTypes(List<String> taxTypes) {
		this.taxTypes = taxTypes;
	}

}
