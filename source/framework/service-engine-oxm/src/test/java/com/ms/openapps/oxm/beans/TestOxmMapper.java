/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ms.openapps.oxm.converter.RequestPayloadDataConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * @author h.shrikant.joshi
 *
 */
public class TestOxmMapper {
	
	@Test
	public void testOxm() {
		XStream xstream = new XStream();
		xstream.alias("RequestEnvelope", RequestEnvelope.class);
		xstream.aliasField("RequestMetaData", RequestEnvelope.class,"requestMetaData");
		xstream.aliasField("RequestPayload", RequestEnvelope.class,"requestPayload");
		xstream.aliasField("PayloadData", RequestPayload.class,"payloadData");
		xstream.registerLocalConverter(RequestPayload.class, "payloadData", new RequestPayloadDataConverter());
		
		String[] dateformats = new String[]{"MM/dd/yyyy","yyyy.MM.dd.HH.mm.ss","dd MMM yyyy HH:mm:ss Z","dd-MMM-yy","MM/dd/yy","dd.MMM.yyyy"};
		DateConverter dateConverter = new DateConverter("MM/dd/yyyy",dateformats);
		xstream.registerConverter(dateConverter);
		
		RequestEnvelope requestEnvelope = new RequestEnvelope();
		requestEnvelope.setRequestMetaData(new RequestMetaData());
		RequestPayload requestPayload = new RequestPayload();
		CreateEmployeeRequestPayload createEmployeePayloadData = new CreateEmployeeRequestPayload();
		
		List<Skill> skills = new ArrayList<Skill>();
		Skill primarySkill = new Skill();
		
		primarySkill.setName("Spring");
		primarySkill.setProficiency(1);
		
		Skill skill = new Skill();
		skill.setName("Java");
		skill.setProficiency(1);
		skills.add(skill);
		
		createEmployeePayloadData.setName("Hrishi");
		createEmployeePayloadData.setDoj(new Date());
		createEmployeePayloadData.setSalary(new BigDecimal(10000.00));
		createEmployeePayloadData.setSkills(skills);
		createEmployeePayloadData.setPrimarySkill(primarySkill);
		
		LeaveRequestPayload leaveRequestPayload = new LeaveRequestPayload();
		leaveRequestPayload.setEmployeeId(1L);
		leaveRequestPayload.setStartDate(new Date());
		leaveRequestPayload.setEndDate(new Date());
		
		requestPayload.setPayloadData(leaveRequestPayload);
		requestEnvelope.setRequestPayload(requestPayload);
		String xml = xstream.toXML(requestEnvelope);
		System.out.println(xml);
		
		//Object fromXML = xstream.fromXML(xml);
	}

}
