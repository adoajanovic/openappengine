/**
 * 
 */
package com.openappengine.factory.resolver;

import com.openappengine.factory.IGenericAggregateFactory;


/**
 * @author hrishikesh.joshi
 *
 */
public interface IGenericAggregateFactoryResolver {
	
	/**
	 * Returns the Concrete Implementation of the Factory.
	 * @param aggregateName
	 * @return {@link IGenericAggregateFactory}
	 */
	public IGenericAggregateFactory getGenericEntityFactory(String aggregateName);

}
