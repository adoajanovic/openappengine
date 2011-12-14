package com.openappengine.web.entity.tags;
import javax.faces.view.facelets.TagConfig;

import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.entity.definition.ui.UIField;


/**
 * Is the current field a boolean.
 */
public final class IsBooleanHandler extends IsTypeHandler {

    /**
     * Create tag.
     *
     * @param config TagConfig
     */
    public IsBooleanHandler(final TagConfig config) {
        super(config);
    }

	/* (non-Javadoc)
	 * @see com.openappengine.web.entity.tags.IsTypeHandler#isType(com.openappengine.facade.entity.definition.ui.UIField)
	 */
	@Override
	protected boolean isType(FieldDefinition fieldDef) {
		// TODO Auto-generated method stub
		return false;
	}
}