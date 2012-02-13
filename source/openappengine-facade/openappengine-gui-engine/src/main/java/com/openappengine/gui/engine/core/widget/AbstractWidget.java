package com.openappengine.gui.engine.core.widget;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;

public abstract class AbstractWidget extends AbstractGuiComponent implements Widget {

	private static final long serialVersionUID = 1L;
	
	private String entityValueRef;
	
	private Document document;
	
	private List<FormField> fields = new ArrayList<FormField>();

	@Override
	public String getComponentType() {
		return "forms";
	}
	
	@Override
	public Document formBackingObject() {
		return document;
	}
	
	/*public List<Field> getFormFields() {
		List<Field> fieldsDefs = null;
		if(entityValue == null) {
			return null;
		}
		
		Entity entityDefinition = entityValue.getEntityDefinition();
		if(fields == null || fields.isEmpty()) {
			fieldsDefs = entityDefinition.getFields();
		} else {
			fieldsDefs = new ArrayList<Field>();
			for (FormField formFieldDefinition : fields) {
				String entryName = formFieldDefinition.getEntryName();
				if(!entityDefinition.containsFieldDefinitionByFieldName(entryName)) {
					throw new IllegalArgumentException("Field :" + entryName + " not found in the EntityDefinition " + entityDefinition.getEntityName());
				}
				Field fieldDefinitionEntry = entityDefinition.getFieldDefinition(entryName);
				fieldDefinitionEntry.setHidden(formFieldDefinition.isHidden());
				fieldsDefs.add(fieldDefinitionEntry);
			}
		}
		return fieldsDefs;
	}*/
	
	public void setValue(Document doc) {
		this.document = doc;
	}
	
	public String getEntityValueRef() {
		return entityValueRef;
	}

	public void setEntityValueRef(String entityValueRef) {
		this.entityValueRef = entityValueRef;
	}

	public List<FormField> getFields() {
		return fields;
	}

	public void setFields(List<FormField> fields) {
		this.fields = fields;
	}
	
	public void addField(FormField formField) {
		if(formField == null) {
			return;
		}
		fields.add(formField);
	}

}
