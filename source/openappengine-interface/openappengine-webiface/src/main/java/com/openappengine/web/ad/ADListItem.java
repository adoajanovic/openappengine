/**
 * 
 */
package com.openappengine.web.ad;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class ADListItem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String label;
    
    private String value;
    
    private String description;

    public ADListItem(String label, String value, String description) {
	super();
	this.label = label;
	this.value = value;
	this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
