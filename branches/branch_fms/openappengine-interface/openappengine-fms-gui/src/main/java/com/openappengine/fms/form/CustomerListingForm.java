/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.List;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewSelectionListener;

import com.openappengine.fms.interfaces.dto.CustomerDTO;
import com.openappengine.fms.util.PivotUtils;

/**
 * @author hrishikesh.joshi
 * @since  Mar 28, 2012
 *
 */
public class CustomerListingForm extends FleetManagerForm {

	@BXML
	private TableView customerTableView;
	
	@BXML
	private LinkButton refresh;
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location,Resources resources) {
		refreshData();
		
		customerTableView.getTableViewSelectionListeners().add(new TableViewSelectionListener.Adapter() {

			@Override
			public void selectedRowChanged(TableView tableView,Object previousSelectedRow) {
				Map<String, Object> selectedRow = (Map<String, Object>) tableView.getSelectedRow();
				if(selectedRow == null) {
					return;
				}
				
				org.apache.pivot.collections.HashMap<String, Object> namespace = new org.apache.pivot.collections.HashMap<String, Object>();
				namespace.put("CustomerId", selectedRow.get("CustomerId"));
				String name = (String) selectedRow.get("Name");
				PivotUtils.addTab(CustomerListingForm.this, "Customer.bxml",namespace,name);
			}
		});
		
		setRefreshActions();
	}

	private void setRefreshActions() {
		refresh.setAction(new Action() {
			
			@Override
			public void perform(Component source) {
				refreshData();
			}
		});
	}

	private void refreshData() {
		ArrayList<HashMap<String, Object>> tableData = new ArrayList<HashMap<String, Object>>();
		List<CustomerDTO> customerList = getFleetManagerServiceFacade().loadActiveCustomerDTOs();
		if(customerList != null) {
			for (CustomerDTO customer : customerList) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("CustomerId", customer.getPartyId());
				row.put("Name", customer.getLastName() + "," + customer.getFirstName());
				row.put("BirthDate", customer.getBirthDate());
				row.put("Gender", customer.getGender());
				row.put("Status", customer.getStatus());
				tableData.add(row);
			}
		}
		customerTableView.setTableData(tableData);
	}

}
