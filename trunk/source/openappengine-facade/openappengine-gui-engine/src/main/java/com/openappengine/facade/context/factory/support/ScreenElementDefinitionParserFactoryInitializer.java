/**
 * 
 */
package com.openappengine.facade.context.factory.support;

import java.lang.reflect.Modifier;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.util.Assert;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.context.factory.support.parser.GuiElementDefinitionParser;

public class ScreenElementDefinitionParserFactoryInitializer implements Callback<ScreenElementDefinitionParserFactory> {
	
	private String packageToScan = "com.openappengine.facade.context.factory.support.parser";

	@Override
	public ScreenElementDefinitionParserFactory onCallback() {
		ScreenElementDefinitionParserFactory factory = new ScreenElementDefinitionParserFactory();
		Reflections reflections = new Reflections(packageToScan);
		Set<Class<? extends GuiElementDefinitionParser>> parserClasses = reflections.getSubTypesOf(GuiElementDefinitionParser.class);
		if (parserClasses != null && !parserClasses.isEmpty()) {
			for (Class<? extends GuiElementDefinitionParser> clazz : parserClasses) {
				doRegisterActionHandler(factory, clazz);
			}
		}
		return factory;
	}
	
	/**
	 * @param factory
	 * @param clazz
	 * @throws ActionHandlerFactoryInitializationException
	 */
	private void doRegisterActionHandler(ScreenElementDefinitionParserFactory factory, Class<? extends GuiElementDefinitionParser> clazz)
			throws RuntimeException {
		try {
			if(Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
				return;
			}
			GuiElementDefinitionParser parser = clazz.newInstance();
			Assert.notNull(parser.getParsedNodeName(), "Class extending [com.openappengine.facade.context.factory.support.parser.GuiElementDefinitionParser] - The method : [getParsedNodeName()] cannot return a null or a blank.");
			factory.addScreenElementDefinitionParser(parser.getParsedNodeName(), parser);
		} catch (InstantiationException e) {
			throw new RuntimeException("Exception encountered while initializing ActionHandler for class " + clazz);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Exception encountered while accessing ActionHandler for class " + clazz);
		}
	}
}