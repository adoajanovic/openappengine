/**
 * 
 */
package com.openappengine.factory.resolver;

import java.util.Map;

import com.openappengine.factory.IGenericAggregateFactory;

/**
 * @author hrishikesh.joshi
 * 
 */
public class GenericAggregateFactoryResolver implements IGenericAggregateFactoryResolver {

	private Map<String,IGenericAggregateFactory> factories;
	
	public GenericAggregateFactoryResolver(Map<String, IGenericAggregateFactory> factoryMap) {
		this.factories = factoryMap;
	}
	
	/**
	 * Get a Concrete Implementation of the Aggregate Factory. If the factory is not mapped, throw a {@link FactoryNotFoundException}
	 * @param aggregateName
	 * @return {@link IGenericAggregateFactory}
	 */
	public IGenericAggregateFactory getGenericEntityFactory(String aggregateName) {
		if(factories == null || !factories.containsKey(aggregateName)) {
			throw new FactoryNotFoundException("Factory " + aggregateName + " not found.");
		}
		return factories.get(aggregateName);
	}

}
