/**
 * 
 */
package com.openappengine.web.mvc.ad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hrishi
 * 
 */
public class ADTableBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private String helpText;

	private String tableName;

	private String entityClassName;

	private String window;

	private boolean deleteable = true;

	private boolean highVolume = false;

	private boolean importable = false;
	
	private List<ADColumnBean> adColumnBeans = new ArrayList<ADColumnBean>();
	
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

	public List<ADColumnBean> getAdColumnBeans() {
		return adColumnBeans;
	}

	public void setAdColumnBeans(List<ADColumnBean> adColumnBeans) {
		this.adColumnBeans = adColumnBeans;
	}

	public void addAdColumnBean(ADColumnBean adColumnBean) {
		if(adColumnBean == null) {
			return;
		}
		
		this.adColumnBeans.add(adColumnBean);
	}
}
