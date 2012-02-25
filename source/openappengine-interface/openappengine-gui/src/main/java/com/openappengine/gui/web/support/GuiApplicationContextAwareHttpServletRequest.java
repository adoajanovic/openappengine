package com.openappengine.gui.web.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

public class GuiApplicationContextAwareHttpServletRequest extends HttpServletRequestWrapper {

	/**
	 *  The <code>GuiEngineContext</code> to wrap around this request.
	 */
	private final GuiEngineContext context;
	
	/**
	 * @param request
	 */
	public GuiApplicationContextAwareHttpServletRequest(GuiEngineContext context,HttpServletRequest request) {
		super(request);
		this.context = context;
	}

	/**
	 * @return Wrapper <code>GuiEngineContext</code> for this request.
	 */
	public GuiEngineContext getGuiApplicationContext() {
		return context;
	}

}
