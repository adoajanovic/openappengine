package com.openappengine.gui.web.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.openappengine.facade.core.context.GuiApplicationContext;

public class GuiApplicationContextAwareHttpServletRequest extends HttpServletRequestWrapper {

	/**
	 *  The <code>GuiApplicationContext</code> to wrap around this request.
	 */
	private final GuiApplicationContext context;
	
	/**
	 * @param request
	 */
	public GuiApplicationContextAwareHttpServletRequest(GuiApplicationContext context,HttpServletRequest request) {
		super(request);
		this.context = context;
	}

	/**
	 * @return Wrapper <code>GuiApplicationContext</code> for this request.
	 */
	public GuiApplicationContext getGuiApplicationContext() {
		return context;
	}

}
