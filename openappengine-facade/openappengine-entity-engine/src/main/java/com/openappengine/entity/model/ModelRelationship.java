/**
 * 
 */
package com.openappengine.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hrishikesh.joshi
 * @since  Mar 5, 2012
 *
 */
public class ModelRelationship implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ModelEntity modelEntity;
	
	//one, many, one-nofk
	private String type;

	private String title;
	
	private String relatedEntityName;

	private List<RelationshipKeyMap> relatedfieldsMap = new ArrayList<RelationshipKeyMap>();

	public ModelEntity getModelEntity() {
		return modelEntity;
	}

	public void setModelEntity(ModelEntity modelEntity) {
		this.modelEntity = modelEntity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelatedEntityName() {
		return relatedEntityName;
	}

	public void setRelatedEntityName(String relatedEntityName) {
		this.relatedEntityName = relatedEntityName;
	}

	public List<RelationshipKeyMap> getRelatedFieldMap() {
		return relatedfieldsMap;
	}

	public void setRelatedFieldMap(List<RelationshipKeyMap> keyMap) {
		this.relatedfieldsMap = keyMap;
	}
}
