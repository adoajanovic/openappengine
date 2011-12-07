/**
 * 
 */
package com.openappengine.web.mvc.ad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.openappengine.facade.ad.ApplicationDictionaryFacade;
import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.facade.context.FacadeContext;
import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 * 
 */
public class ApplicationDictionaryControllerImpl extends BaseWebController
		implements ApplicationDictionaryController,Serializable {

	private static final long serialVersionUID = 1L;

	private ApplicationDictionaryFacade applicationDictionaryFacade;

	private ADTableBean adTableBean;

	private List<SelectItem> adTableDTOs = new ArrayList<SelectItem>();

	private List<ADColumnBean> adColumns = new ArrayList<ADColumnBean>();

	public ApplicationDictionaryControllerImpl() {
		this.applicationDictionaryFacade = FacadeContext.getApplicationDictionaryFacade();
		logger.info("ApplicationDictionaryController Initialized.");
	}

	public String adTableSelected() {
		final String tableName = adTableBean.getTableName();
		ADTableDTO adTableDTO = applicationDictionaryFacade.getAdTableDTO(tableName);
		
		adTableBean = new ADTableBean();
		adTableBean.setEntityClassName(adTableDTO.getEntityClassName());
		
		populateADColumns(tableName);
		return null;
	}
	
	public void toggleSelection(ActionEvent actionEvent) {
		if(adColumns != null && !adColumns.isEmpty()) {
			for (ADColumnBean adColumnBean : adColumns) {
				if(!adColumnBean.isChecked()) {
					adColumnBean.setChecked(true);
				} else {
					adColumnBean.setChecked(false);
				}
			}
		}
	}

	private void populateADColumns(final String tableName) {
		List<ADColumnDTO> adColumnDTOs = applicationDictionaryFacade.listAllApplicationTableColumnNames(tableName);
		getAdColumns().clear();
		if(adColumnDTOs != null && !adColumnDTOs.isEmpty()) {
			for (ADColumnDTO adColumnDTO : adColumnDTOs) {
				ADColumnBean adColumnBean = new ADColumnBean();
				adColumnBean.setColumnName(adColumnDTO.getColumnName());
				adColumnBean.setChecked(false);
				getAdColumns().add(adColumnBean);
			}
		}
	}

	public ADTableBean getAdTableBean() {
		return adTableBean;
	}

	public void setAdTableBean(ADTableBean adTableBean) {
		this.adTableBean = adTableBean;
	}

	public List<SelectItem> getAdTableDTOs() {
		List<ADTableDTO> applicationTableNames = applicationDictionaryFacade
				.listAllApplicationTableNames();
		if (applicationTableNames != null && !applicationTableNames.isEmpty()) {
			for (ADTableDTO adTableDTO : applicationTableNames) {
				adTableDTOs.add(new SelectItem(adTableDTO.getTableName(), adTableDTO.getTableName()));
			}
		}
		return adTableDTOs;
	}

	public String save() {
		List<ADColumnDTO> adColumnDTOs = new ArrayList<ADColumnDTO>();
		if(adColumns != null && !adColumns.isEmpty()) {
			for (ADColumnBean adColumnBean : adColumns) {
				if(adColumnBean.isChecked()) {
					ADColumnDTO adColumnDTO = new ADColumnDTO(adColumnBean.getColumnName());
					adColumnDTO.setColumnName(adColumnBean.getColumnName());
					if(adColumnBean.getName().isEmpty()) {
						adColumnDTO.setName(adColumnBean.getColumnName());
					} else {
						adColumnDTO.setName(adColumnBean.getName());
					}
					adColumnDTO.setDescription(adColumnBean.getDescription());
					adColumnDTO.setHelpText(adColumnBean.getHelpText());
					adColumnDTOs.add(adColumnDTO);
				}
			}
			
			if(!adColumnDTOs.isEmpty()) {
				ADTableDTO adTableDTO = new ADTableDTO(adTableBean.getTableName());
				adTableDTO.setEntityClassName(adTableBean.getEntityClassName());
				adTableDTO.setAdColumnDTOs(adColumnDTOs);
				applicationDictionaryFacade.addADTable(adTableDTO);
			} else {
				//TODO - Add Message
			}
		}
		return null;
	}
	
	
	public void setAdTableDTOs(List<SelectItem> adTableDTOs) {
		this.adTableDTOs = adTableDTOs;
	}

	public List<ADColumnBean> getAdColumns() {
		return adColumns;
	}

	public void setAdColumns(List<ADColumnBean> adColumns) {
		this.adColumns = adColumns;
	}
	
}