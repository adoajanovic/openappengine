/**
 * 
 */

package com.openappengine.aggregate;
import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openappengine.aggregate.context.AggregateContext;
import com.openappengine.aggregate.factory.impl.AggregateFactoryNames;
import com.openappengine.aggregate.factory.impl.ItemMasterAggregateFactory;
import com.openappengine.domain.model.ItItemMaster;
import com.openappengine.factory.resolver.GenericAggregateFactoryResolver;
import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.context.EntityContext;

/**
 * @author hrishi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/repository-context.xml","/aggregate-context.xml"})
public class TestAggregateConfig {
	
	@Test
	public void testAggregateConfig() {
		GenericAggregateFactoryResolver factoryResolver = AggregateContext.getFactoryResolver();
		Assert.assertNotNull("GenericAggregateFactoryResolver not initialized", factoryResolver);
	}
	
	@Test
	public void testItemMasterAggregateFactory() {
		GenericAggregateFactoryResolver factoryResolver = AggregateContext.getFactoryResolver();
		Assert.assertNotNull("GenericAggregateFactoryResolver not initialized", factoryResolver);
		ItemMasterAggregateFactory itemMasterAggregateFactory = (ItemMasterAggregateFactory) factoryResolver.getGenericEntityFactory(AggregateFactoryNames.ITEM_MASTER_FACTORY);
		ItItemMaster itemMaster = itemMasterAggregateFactory.createItemMaster(new BigDecimal("1"), "INR", "Test", "Test", false, "ACTV", "SV", "EACH");
		Assert.assertNotNull("ItemMasterAggregateFactory returned Null Item", itemMaster);
		EntityContext instance = EntityContext.getInstance();
		GenericRepository genericRepository = instance.getGenericRepository();
		genericRepository.save(itemMaster);
	}

}
