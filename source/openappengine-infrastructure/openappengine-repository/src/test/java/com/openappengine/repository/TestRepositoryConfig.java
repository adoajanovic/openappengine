/**
 * 
 */
package com.openappengine.repository;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.openappengine.repository.context.EntityContext;

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

}
