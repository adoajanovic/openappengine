/**
 * 
 */
package com.openappengine.web.entity.tags.handler;

import com.openappengine.web.entity.tags.IsBooleanHandler;
import com.openappengine.web.entity.tags.IsTextHandler;
import com.openappengine.web.entity.tags.SetTagHandler;
import com.openappengine.web.entity.tags.SetValueBindingHandler;
import com.sun.faces.facelets.tag.AbstractTagLibrary;

/**
 * @author hrishikesh.joshi
 * @Dec 14, 2011
 */
public class EntityTagLibrary extends AbstractTagLibrary {
	
	 /** Namespace used to import this library in Facelets pages  */
    public static final String NAMESPACE = "http://www.openappengine.com/tags/entity";

    /**  Current instance of library. */
    public static final EntityTagLibrary INSTANCE = new EntityTagLibrary();
    
	/**
	 * @param namespace
	 */
	public EntityTagLibrary(String namespace) {
		super(NAMESPACE);
		
		addTagHandlers();
	}


	/**
	 * 
	 */
	protected void addTagHandlers() {
		this.addTagHandler("set", SetTagHandler.class);
		this.addTagHandler("isBoolean", IsBooleanHandler.class);
		this.addTagHandler("isText", IsTextHandler.class);
		this.addTagHandler("setValueBinding", SetValueBindingHandler.class);
	}


	/**
	 * 
	 */
	public EntityTagLibrary() {
		super(NAMESPACE);
		addTagHandlers();
	}

}
