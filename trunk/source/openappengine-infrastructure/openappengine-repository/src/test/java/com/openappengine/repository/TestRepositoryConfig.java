/**
 * 
 */
package com.openappengine.repository;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.openappengine.repository.context.EntityContext;
import com.openappengine.repository.model.ItItemMaster;

/**
 * @author hrishi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/repository-context.xml" })
public class TestRepositoryConfig {
	
	@Test
	public void testRepositoryConfig() {
		EntityContext entityContext = EntityContext.getInstance();
		Assert.notNull(entityContext, "Entity Context is not initialized.");
		SessionFactory sessionFactory = entityContext.getSessionFactory();
		Assert.notNull(sessionFactory, "Hibernate SessionFactory not initialized.");
	}
	
	@Test
	public void testCreateItemMaster() {
		EntityContext entityContext = EntityContext.getInstance();
		Assert.notNull(entityContext, "Entity Context is not initialized.");
		
		ItItemMaster itemMaster = new ItItemMaster();
		itemMaster.setCat01("cat01");
		itemMaster.setCost(new BigDecimal("1"));
		itemMaster.setCurcode("INR");
		itemMaster.setDesc("desc");
		itemMaster.setName("test");
		itemMaster.setPerishable(false);
		itemMaster.setPrice(new BigDecimal("1"));
		itemMaster.setShipCharges(new BigDecimal("1"));
		itemMaster.setStatus("ACTV");
		itemMaster.setType("SV");
		itemMaster.setUom("ECH");
		itemMaster.setWeight(new BigDecimal("1"));
		
		GenericEntityRepositoryDao genericEntityRepositoryDAO = entityContext.getGenericEntityRepositoryDAO();
		boolean save = genericEntityRepositoryDAO.save(itemMaster);
	}

}
