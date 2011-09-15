/**
 * 
 */

package com.openappengine.aggregate;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openappengine.aggregate.context.AggregateContext;
import com.openappengine.factory.resolver.GenericAggregateFactoryResolver;

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

}
