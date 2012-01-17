/**
 * 
 */
package com.openappengine.gui.context.request;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @author hrishikesh.joshi
 * @since  Jan 17, 2012
 *
 */
public abstract class RequestContextHolder {
	
	/**
	 * Request Attributes Thread Local.
	 */
	private static final String REQUEST_ATTRIBUTES_HOLDER = "REQUEST_ATTRIBUTES_HOLDER";
	
	/**
	 * ThreadLocal to expose the current request.
	 */
	private static final ThreadLocal<RequestAttributes> requestAttributesHolder = new NamedThreadLocal<RequestAttributes>(REQUEST_ATTRIBUTES_HOLDER);

	/**
	 * @return the requestattributesholder.
	 */
	public static ThreadLocal<RequestAttributes> getRequestattributesholder() {
		return requestAttributesHolder;
	}
	
	/**
	 *  Reset Request Attributes.
	 */
	public static void resetRequestAttributes() {
		requestAttributesHolder.remove();
	}
	
	/**
	 * @param requestAttributes
	 */
	public static void setRequestAttribues(RequestAttributes requestAttributes) {
		resetRequestAttributes();
		requestAttributesHolder.set(requestAttributes);
	}

	/**
	 * @return
	 */
	public static RequestAttributes getRequestAttributes() {
		return requestAttributesHolder.get();
	}

}
