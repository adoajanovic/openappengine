/**
 * 
 */
package com.ms.openapps.service;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

import org.w3c.dom.Document;

import com.ms.openapps.service.context.DispatchContext;
import com.ms.openapps.service.reader.XmlServiceConfigException;

/**
 * @author hrishi
 *
 */
public class ServiceReaderUtils {
	
	
	public static void main(String[] a) throws MalformedURLException, ClassNotFoundException {
		URL[] urls = null;
		urls = new URL[1];
		File f = new File("F:\\phase1\\openapps-parent\\apps\\app-classloader");
		URL url = f.toURI().toURL();
		urls[0] = url;
		URLClassLoader urlClassLoader = new URLClassLoader(urls);
		urlClassLoader.loadClass("com.ms.openapps.order.CreateSalesOrder");
	}
	
	
	public static ClassLoader getClassLoader() {
        ClassLoader parent = Thread.currentThread().getContextClassLoader();
        if (parent == null) {
            parent = ClassLoader.getSystemClassLoader();
        }
        return parent;
    }
	/**
	 * @param runnerService
	 * @return RunnerService - Service Runner Class which executies the service.
	 */
	public static Class<?> getRunnerClass(String runnerService) {
		
		if(runnerService == null || runnerService.isEmpty()) {
			throw new XmlServiceConfigException("No RunnerService defined");
		}
		Class<?> runnerServiceClass = null;
		try {
			ClassLoader classLoader = getClassLoader();
			runnerServiceClass = Class.forName(runnerService);// classLoader.loadClass(runnerService);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new XmlServiceConfigException("No RunnerService found " + runnerService);
		}
		return runnerServiceClass;
	}
	
	
	/**
	 * @param method
	 * @param serviceRunnerClass
	 * @return method - Method present in the ServiceRunnerClass that has the actual logic of the Service.  
	 */
	@Deprecated
	public static Method getXmlServiceRunnerMethod(String method,Class<?> serviceRunnerClass) {
		if(method == null || method.isEmpty()) {
			throw new XmlServiceConfigException("No Method specified for ServiceRunner " + serviceRunnerClass.getName());
		}
		Method runnerMethod = null;
		try {
			runnerMethod = serviceRunnerClass.getDeclaredMethod(method, DispatchContext.class,Document.class);
			Class<?> returnType = runnerMethod.getReturnType();
			if(!returnType.isAssignableFrom(Document.class)) {
				throw new XmlServiceConfigException(" The XML Service should return a Document (XML) object.");
			}
		} catch (SecurityException e) {
			throw new XmlServiceConfigException("Invalid access for method " + method + " for ServiceRunner " + serviceRunnerClass.getName());
		} catch (NoSuchMethodException e) {
			throw new XmlServiceConfigException("The Service Configured as XML Service should have method that returns a org.w3c.Document object and take as arguments DispatchContext and Input params as org.w3c.Document (XML Document).");
		}
		return runnerMethod;
	}
	
	/**
	 * @param method
	 * @param serviceRunnerClass
	 * @return method - Method present in the ServiceRunnerClass that has the actual logic of the Service.  
	 */
	public static Method getRunnerMethod(String method,Class<?> serviceRunnerClass) {
		if(method == null || method.isEmpty()) {
			throw new XmlServiceConfigException("No Method specified for ServiceRunner " + serviceRunnerClass.getName());
		}
		Method runnerMethod = null;
		try {
			runnerMethod = serviceRunnerClass.getDeclaredMethod(method, DispatchContext.class,Map.class);
		} catch (SecurityException e) {
			throw new XmlServiceConfigException("Invalid access for method " + method + " for ServiceRunner " + serviceRunnerClass.getName());
		} catch (NoSuchMethodException e) {
			throw new XmlServiceConfigException("The service method must return a Map<String,Object> and take as arguments DispatchContext and Input params as Map.");
		}
		return runnerMethod;
	}

}
