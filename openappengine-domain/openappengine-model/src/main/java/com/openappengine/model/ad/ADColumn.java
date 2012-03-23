/**
 * 
 */
package com.openappengine.model.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishikesh.joshi
 *
 */

@Entity
@Table(name="AD_COLUMN")
public class ADColumn implements ValueObject<ADColumn> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="C_COLUMN_ID", unique=true, nullable=false)
	private int adColumnId;
	
	@Column(name="C_NAME", nullable=false, length=50)
	private String name;
	
	@Column(name="C_DESCRIPTION", nullable=true, length=50)
	private String description;
	
	@Column(name="C_HELP_TEXT", nullable=true, length=50)
	private String helpText;
	
	@Column(name="C_COLUMN_NAME", nullable=false, length=50)
	private String columnName;
	
	@Column(name="C_IS_KEY", nullable=false)
	private boolean key;
	
	@Column(name="C_IS_MANDATORY", nullable=false)
	private boolean mandatory;
	
	@Column(name="C_IS_UPDATEABLE", nullable=false)
	private boolean updateable;
	
	@Column(name="C_IS_SELECTION_COLUMN", nullable=false)
	private boolean selectionColumn;
	
	@ManyToOne
	@JoinColumn(name="C_TABLE_ID")
	private ADTable adTable;
	
	public boolean sameValueAs(ADColumn other) {
		return false;
	}

	public int getAdColumnId() {
		return adColumnId;
	}

	public void setAdColumnId(int adColumnId) {
		this.adColumnId = adColumnId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public boolean isUpdateable() {
		return updateable;
	}

	public void setUpdateable(boolean updateable) {
		this.updateable = updateable;
	}

	public boolean isSelectionColumn() {
		return selectionColumn;
	}

	public void setSelectionColumn(boolean selectionColumn) {
		this.selectionColumn = selectionColumn;
	}

	public ADTable getAdTable() {
		return adTable;
	}

	public void setAdTable(ADTable adTable) {
		this.adTable = adTable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((columnName == null) ? 0 : columnName.hashCode());
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
		ADColumn other = (ADColumn) obj;
		if (columnName == null) {
			if (other.columnName != null)
				return false;
		} else if (!columnName.equals(other.columnName))
			return false;
		return true;
	}
	
}
