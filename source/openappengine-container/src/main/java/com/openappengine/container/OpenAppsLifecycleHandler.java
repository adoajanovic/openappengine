/**
 * 
 */
package com.openappengine.container;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javolution.util.FastMap;

import com.ms.openapps.util.UtilLogger;

/**
 * @author hrishi
 *
 */
public class OpenAppsLifecycleHandler {

	private UtilLogger logger = new UtilLogger(getClass());

	private LifecycleConfig config;
	
	private Component[] components = new Component[0];
	
	public OpenAppsLifecycleHandler() {
	}
	
	/**
	 * Startup Method for OpenApps Framework
	 */
	public void startup() {
		logger.logInfo("Startup - OpenApps");
		config = new LifecycleConfig();
		components = config.initLifecycleComponents();
		startup(components);
	}
	
	private void startup(Component[] components) {
		startupShutdown(components, Boolean.TRUE);
	}
	
	private void shutdown(Component[] components) {
		startupShutdown(components, Boolean.FALSE);
	}
	
	private void startupShutdown(Component[] components,boolean startup) {
		if(components == null || components.length == 0) {
			return;
		}
		
		Map<String, ClassLoader> classLoaderMap = new FastMap<String, ClassLoader>();
		
		for(Component c : components) {
			String eventHandler = c.getEventHandler();
			String startupMethod = c.getStartupMethod();
			try {
				Class<?> eventHandlerClass = getClass().getClassLoader().loadClass(eventHandler);
				Object instance = eventHandlerClass.newInstance();
				classLoaderMap.put(c.getComponentId(), eventHandlerClass.getClassLoader());
				Method method = eventHandlerClass.getMethod(startupMethod);
				method.invoke(instance);
				
				if(startup) {
					ComponentContext.setComponentClassLoaderCache(classLoaderMap);
				}
				
				logger.logInfo("Component " + c.getComponentId() + " initialized ");
			} catch (ClassNotFoundException e) {
				throw new LifecycleConfigException("Error encountered while loading class " + c.getEventHandler(),e);
			} catch (SecurityException e) {
				throw new LifecycleConfigException("Securty Exception encountered while calling the method " + c.getStartupMethod(),e);
			} catch (NoSuchMethodException e) {
				throw new LifecycleConfigException("Method " + c.getStartupMethod() + " does not exist in class " + c.getEventHandler(),e);
			} catch (IllegalArgumentException e) {
				throw new LifecycleConfigException("Exception encountered while calling method" + c.getStartupMethod() + "  in class " + c.getEventHandler(),e);
			} catch (IllegalAccessException e) {
				throw new LifecycleConfigException("Exception encountered while calling method" + c.getStartupMethod() + "  in class " + c.getEventHandler(),e);
			} catch (InvocationTargetException e) {
				throw new LifecycleConfigException("Exception encountered while calling method" + c.getStartupMethod() + "  in class " + c.getEventHandler(),e);
			} catch (InstantiationException e) {
				throw new LifecycleConfigException("Exception encountered while instantiating class " + c.getEventHandler(),e);
			}
		}
	}
	
	
	/**
	 * Shutdown Method for OpenApps Framework
	 */
	public void shutdown() {
		shutdown(components);
		logger.logInfo("Shutdown - OpenApps");
	}
	
}
