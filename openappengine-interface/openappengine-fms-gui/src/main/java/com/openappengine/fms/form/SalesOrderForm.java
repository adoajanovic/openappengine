/**
 * 
 */
package com.openappengine.fms.form;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.Map;

import com.openappengine.fms.interfaces.dto.SalesOrderDTO;

/**
 * @author hrishi
 *
 */
public class SalesOrderForm extends FleetManagerForm {

	private SalesOrderDTO salesOrderDTO;
	
	@Override
	protected void initFormBean(Map<String, Object> namespace) {
		salesOrderDTO = new SalesOrderDTO();
		
		salesOrderDTO.getParty().setSalutation("Mr.");
		salesOrderDTO.getParty().setFirstName("Hrishikesh");
		salesOrderDTO.getParty().setMiddleName("Shrikant");
		salesOrderDTO.getParty().setLastName("Joshi");

		Date date = new Date();
		date = DateUtils.setDays(date, 23);
		date = DateUtils.setMonths(date, 0);
		date = DateUtils.setYears(date, 1987);
		
		salesOrderDTO.getParty().setBirthDate(date);
		
		this.load(new BeanAdapter(salesOrderDTO));
	}
}
