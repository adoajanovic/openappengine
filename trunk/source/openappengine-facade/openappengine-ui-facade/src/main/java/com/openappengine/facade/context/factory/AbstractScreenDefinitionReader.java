/**
 * 
 */
package com.openappengine.facade.context.factory;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractScreenDefinitionReader implements ScreenDefinitionReader {

	@Override
	public void loadScreenDefinition(Resource resource) {
		Assert.notNull(resource,"Resource cannot be null.");
		try {
			loadScreenDefinition(resource.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException("Exception encountered while reading the screen definition.",e);
		}
	}

	protected abstract void loadScreenDefinition(InputStream inputStream);
}
