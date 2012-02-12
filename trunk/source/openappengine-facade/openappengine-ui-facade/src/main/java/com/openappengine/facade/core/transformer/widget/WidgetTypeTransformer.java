/**
 * 
 */
package com.openappengine.facade.core.transformer.widget;

import org.w3c.dom.Document;

import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.transformer.Transformer;
import com.openappengine.facade.core.xml.transformer.StringConverter;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public abstract class WidgetTypeTransformer implements Transformer<ActionResponseXml, Document> {
	
	@Override
	public void registerCustomConverters(Class<?> forClass,StringConverter converter) {
		// TODO Auto-generated method stub
	}

}
