/**
 * 
 */
package com.openappengine.crud;

/**
 * @author hrishi
 *
 */
public class Row extends DataBeanWrapper {
    
    private Object object;
    
    private boolean selectable = true;

    public Row(Object object) {
	super(object);
	this.setObject(object);
    }

    public Object getObject() {
	return object;
    }

    public void setObject(Object object) {
	this.object = object;
	super.init(object);
    }

    public boolean isSelectable() {
	return selectable;
    }

    public void setSelectable(boolean selectable) {
	this.selectable = selectable;
    }
    
}
