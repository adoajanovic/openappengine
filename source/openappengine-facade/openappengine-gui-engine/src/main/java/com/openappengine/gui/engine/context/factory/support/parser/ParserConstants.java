/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import java.io.Serializable;

/**
 * This class holds all the parser constants; that are used to parse individual payments.
 * 
 * @author hrishi
 * since Jan 1, 2012
 */
public class ParserConstants implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIELD_MAP_PARSER = "field-map";
	
	public static final String ENTITY_FIND_ONE_PARSER = "entity-find-one";
	
	public static final String PRE_ACTIONS_PARSER = "pre-actions";

	public static final String FORM_SINGLE_ELEMENT_PARSER = "form-single";
	
	public static final String FORM_LIST_ELEMENT_PARSER = "form-list";

	public static final String WIDGETS = "widgets";

	public static final String SUB_SCREENS_ELEMENT_PARSER = "sub-screens";

	public static final String PAGE_CONTENT_PARSER = "page-content";

	public static final String ENTITY_SAVE = "entity-save";

}
