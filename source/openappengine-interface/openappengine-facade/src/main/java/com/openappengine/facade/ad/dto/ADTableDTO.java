/**
 * 
 */
package com.openappengine.facade.ad.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;


/**
 * @author hrishi
 *
 */
public class ADTableDTO {
	
	private String name;
	
	private String description;
	
	private String helpText;
	
	private String tableName;
	
	private String entityClassName;
	
	private String window;
	
	private boolean deleteable = true;
	
	private boolean highVolume = false;
	
	private boolean importable = false;
	
	private List<ADColumnDTO> adColumnDTOs = new ArrayList<ADColumnDTO>();

	public ADTableDTO(String tableName) {
		super();
		this.tableName = tableName;
		this.name = tableName;
		Validate.notEmpty(tableName);
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

	public List<ADColumnDTO> getAdColumnDTOs() {
		return adColumnDTOs;
	}

	public void setAdColumnDTOs(List<ADColumnDTO> adColumnDTOs) {
		this.adColumnDTOs = adColumnDTOs;
	}
	
	public void addAdColumn(ADColumnDTO adColumnDTO) {
		if(adColumnDTO == null) {
			return;
		}
		
		this.adColumnDTOs.add(adColumnDTO);
	}

}
