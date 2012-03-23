/**
 * 
 */
package com.openappengine.factory.resolver;

import java.util.Map;

import com.openappengine.factory.ModelFactory;

/**
 * @author hrishikesh.joshi
 * 
 */
public class GenericAggregateFactoryResolverImpl implements GenericAggregateFactoryResolver {

	private static Map<String,ModelFactory> factories;
	
	public GenericAggregateFactoryResolverImpl(Map<String, ModelFactory> factoryMap) {
		GenericAggregateFactoryResolverImpl.factories = factoryMap;
	}
	
	/**
	 * Get a Concrete Implementation of the Aggregate Factory. 
	 * If the factory is not mapped, throw a {@link FactoryNotFoundException}
	 * @param aggregateName
	 * @return {@link ModelFactory}
	 */
	public ModelFactory getModelFactory(String aggregateName) {
		if(factories == null || !factories.containsKey(aggregateName)) {
			throw new FactoryNotFoundException("Factory " + aggregateName + " not found.");
		}
		return factories.get(aggregateName);
	}

}
