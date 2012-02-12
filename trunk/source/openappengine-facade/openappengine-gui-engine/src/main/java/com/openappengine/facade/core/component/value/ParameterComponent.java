/**
 * 
 */
package com.openappengine.facade.core.component.value;

/**
 * @author hrishi
 * since Jan 21, 2012
 */
public class ParameterComponent extends AbstractValueHolderComponent {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String valueRef;

	@Override
	public String getComponentName() {
		return "parameter";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the valueRef
	 */
	public String getValueRef() {
		return valueRef;
	}

	/**
	 * @param valueRef the valueRef to set
	 */
	public void setValueRef(String valueRef) {
		this.valueRef = valueRef;
	}
	
}
