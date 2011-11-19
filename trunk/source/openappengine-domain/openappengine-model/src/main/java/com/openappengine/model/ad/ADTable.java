/**
 * 
 */
package com.openappengine.model.ad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;
import com.truemesh.squiggle.output.Output;
import com.truemesh.squiggle.output.Outputable;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_TABLE")
public class ADTable implements ValueObject<ADTable>,Outputable {
	
	public static final String AD_MODULE_PREFIX = "AD";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="T_TABLE_ID", unique=true, nullable=false)
	private int adTableId;
	
	@Column(name="T_NAME", nullable=false, length=50)
	private String name;
	
	@Column(name="T_DESCRIPTION", nullable=true, length=50)
	private String description;
	
	@Column(name="T_HELP_TEXT", nullable=true, length=50)
	private String helpText;
	
	@Column(name="T_TABLE_NAME", nullable=false, length=50)
	private String tableName;
	
	@Column(name="T_ENTITY_CLASS_NAME", nullable=false, length=50)
	private String entityClassName;
	
	@Column(name="T_WINDOW", nullable=true, length=50)
	private String window;
	
	@Column(name="IT_DELETEABLE", nullable=false)
	private boolean deleteable;
	
	@Column(name="T_HIGH_VOLUME", nullable=false)
	private boolean highVolume;
	
	@Column(name="T_IMPORTABLE", nullable=false)
	private boolean importable;
	
	@OneToMany(cascade = {CascadeType.ALL},orphanRemoval=true)
	@JoinColumn(name="C_TABLE_ID")
	private List<ADColumn> adColumns = new ArrayList<ADColumn>();
	
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


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getEntityClassName() {
		return entityClassName;
	}


	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}


	public String getWindow() {
		return window;
	}


	public void setWindow(String window) {
		this.window = window;
	}


	public boolean isDeleteable() {
		return deleteable;
	}


	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}


	public boolean isHighVolume() {
		return highVolume;
	}


	public void setHighVolume(boolean highVolume) {
		this.highVolume = highVolume;
	}


	public boolean isImportable() {
		return importable;
	}


	public void setImportable(boolean importable) {
		this.importable = importable;
	}


	public boolean sameValueAs(ADTable other) {
		return false;
	}


	public int getAdTableId() {
		return adTableId;
	}


	public void setAdTableId(int adTableId) {
		this.adTableId = adTableId;
	}

	public List<ADColumn> getAdColumns() {
		return adColumns;
	}

	public void setAdColumns(List<ADColumn> adColumns) {
		this.adColumns = adColumns;
	}

	public void addAdColumn(ADColumn adColumn) {
		if(adColumn == null) {
			return;
		}
		
		this.adColumns.add(adColumn);
	}

	public void write(Output out) {
		out.print(getTableName());
	}
}
