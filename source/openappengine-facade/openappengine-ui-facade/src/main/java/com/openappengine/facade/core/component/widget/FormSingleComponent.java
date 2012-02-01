package com.openappengine.facade.core.component.widget;


/**
 * 
 * FormSingleComponent
 * 
 * @author hrishikesh.joshi
 * @since  Feb 1, 2012
 *
 */
public class FormSingleComponent extends AbstractHibernateBackingBeanWidgetComponent {

	private static final long serialVersionUID = 1L;
	
	private String transition;

	@Override
	public String getComponentName() {
		return "form";
	}

	@Override
	public String getWidgetType() {
		return "form-single";
	}
	
	/**
	 * @return the transition
	 */
	public String getTransition() {
		return transition;
	}

	/**
	 * @param transition the transition to set
	 */
	public void setTransition(String transition) {
		this.transition = transition;
	}

}
