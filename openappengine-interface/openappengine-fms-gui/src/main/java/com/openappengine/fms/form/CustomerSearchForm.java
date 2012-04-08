/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.List;

import org.apache.pivot.beans.BeanAdapter;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.GridPane;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Panel;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.TableView;

import com.openappengine.fms.interfaces.dto.CustomerSearchResultDTO;


/**
 * @author hrishi
 *
 */
public class CustomerSearchForm extends FleetManagerForm {
	
	private CustomerSearchFilter customerSearchFilter;
	
	private int selectedId;
	
	public class CustomerSearchFilter {
		
		private String firstNameParam;
		
		private String middleNameParam;
		
		private String lastNameParam;
		
		private String mobileNoParam;
		
		private String residenceNoParam;

		public String getFirstNameParam() {
			return firstNameParam;
		}

		public void setFirstNameParam(String firstNameParam) {
			this.firstNameParam = firstNameParam;
		}

		public String getMiddleNameParam() {
			return middleNameParam;
		}

		public void setMiddleNameParam(String middleNameParam) {
			this.middleNameParam = middleNameParam;
		}

		public String getLastNameParam() {
			return lastNameParam;
		}

		public void setLastNameParam(String lastNameParam) {
			this.lastNameParam = lastNameParam;
		}

		public String getResidenceNoParam() {
			return residenceNoParam;
		}

		public void setResidenceNoParam(String residenceNoParam) {
			this.residenceNoParam = residenceNoParam;
		}

		public String getMobileNoParam() {
			return mobileNoParam;
		}

		public void setMobileNoParam(String mobileNoParam) {
			this.mobileNoParam = mobileNoParam;
		}
	}

	@Override
	public void initialize(final Map<String, Object> namespace, URL location,Resources resources) {
		final TableView customerSearchResultsTableView = (TableView) namespace.get("customerSearchResultsTableView");
		PushButton searchButton = (PushButton) namespace.get("searchButton");
		PushButton selectButton = (PushButton) namespace.get("selectButton");
		
		refreshSearchForm(namespace);
		
		searchButton.setAction(new Action() {
			@Override
			public void perform(Component source) {
				GridPane searchFilterPane = (GridPane) namespace.get("searchFilter");
				searchFilterPane.store(customerSearchFilter);
			
				org.apache.pivot.collections.List parties = getFleetManagerServiceFacade().findPartyByName(customerSearchFilter.getFirstNameParam(), customerSearchFilter.getMiddleNameParam(), customerSearchFilter.getLastNameParam());
				customerSearchResultsTableView.setTableData(parties);
			}
		});
		
		
		selectButton.setAction(new Action() {
			
			@Override
			public void perform(Component source) {
				if(customerSearchResultsTableView.getSelectedRow() == null) {
					Alert.alert(MessageType.ERROR, "No record selected", CustomerSearchForm.this.getWindow());
				} else {
					CustomerSearchResultDTO dto = (CustomerSearchResultDTO) customerSearchResultsTableView.getSelectedRow();
					selectedId = dto.getPartyId();
					getWindow().close();
				}
			}
		});
		
	}

	private void refreshSearchForm(Map<String, Object> namespace) {
		GridPane searchFilterPane = (GridPane) namespace.get("searchFilter");
		customerSearchFilter = new CustomerSearchFilter();
		searchFilterPane.load(new BeanAdapter(customerSearchFilter));
	}

	public int getSelectedId() {
		return selectedId;
	}
}
