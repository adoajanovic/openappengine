/**
 * 
 */
package com.openappengine.entity.model;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @since  Mar 5, 2012
 *
 */
public class ModelField implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ModelEntity modelEntity;
	
	private String name;
	
	private String columnName;
	
	private String type;
	
	private boolean isNotNull;
	
	private boolean pk = false;
	
	/**
	 * @param modelEntity
	 */
	public ModelField(ModelEntity modelEntity) {
		super();
		this.setModelEntity(modelEntity);
	}

	public ModelEntity getModelEntity() {
		return modelEntity;
	}

	protected void setModelEntity(ModelEntity modelEntity) {
		this.modelEntity = modelEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPk() {
		return pk;
	}

	public void setPk(boolean pk) {
		this.pk = pk;
	}

	public boolean isNotNull() {
		return isNotNull;
	}

	public void setNotNull(boolean isNotNull) {
		this.isNotNull = isNotNull;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((columnName == null) ? 0 : columnName.hashCode());
		result = prime * result
				+ ((modelEntity == null) ? 0 : modelEntity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelField other = (ModelField) obj;
		if (columnName == null) {
			if (other.columnName != null)
				return false;
		} else if (!columnName.equals(other.columnName))
			return false;
		if (modelEntity == null) {
			if (other.modelEntity != null)
				return false;
		} else if (!modelEntity.equals(other.modelEntity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
