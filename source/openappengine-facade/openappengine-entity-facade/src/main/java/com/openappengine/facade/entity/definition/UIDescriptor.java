/**
 * 
 */
package com.openappengine.facade.entity.definition;

import org.w3c.dom.Element;

/**
 * @author hrishikesh.joshi
 *
 */
public class UIDescriptor {
	
	private Element uiDescriptorElement;
	
	public UIDescriptor(Element uiDescriptorElement) {
		this.uiDescriptorElement = uiDescriptorElement;
	}
	
	class UITextField extends UIDescriptor{

		/**
		 * @param uiDescriptorElement
		 */
		public UITextField(Element uiDescriptorElement) {
			super(uiDescriptorElement);
			// TODO Auto-generated constructor stub
		}
	}
	
	//TODO - Add more subclasses each corresponding to a Custom UIField.

}
