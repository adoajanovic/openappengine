package com.openappengine.web.entity.tags;
import javax.faces.view.facelets.TagConfig;

import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.entity.definition.ui.UIField;

/**
 * Is the current field a string.
 */
public final class IsTextHandler extends IsTypeHandler {

    /**
     * Create tag.
     *
     * @param config TagConfig
     */
    public IsTextHandler(final TagConfig config) {
        super(config);
    }

    /**
     *
     *
     * @param fieldDef type
     *
     * @return true if this is a boolean.
     */
    protected boolean isType(final FieldDefinition fieldDef) {
       if(fieldDef == null || fieldDef.getUiField() == null) {
    	   return true;
       }
       
       if(fieldDef.getUiField().getFieldType().equals("textField")) {
    	   return true;   
       }
       
       return false;
    }
}