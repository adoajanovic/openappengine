/**
 * 
 */
package com.openappengine.factory.resolver;

import com.openappengine.factory.ModelFactory;


/**
 * @author hrishikesh.joshi
 *
 */
public interface GenericAggregateFactoryResolver {
	
	/**
	 * Returns the Concrete Implementation of the Factory.
	 * @param aggregateName
	 * @return {@link ModelFactory}
	 */
	public ModelFactory getModelFactory(String aggregateName);

}
