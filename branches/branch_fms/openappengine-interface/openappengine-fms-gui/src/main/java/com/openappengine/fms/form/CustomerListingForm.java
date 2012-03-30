/**
 * 
 */
package com.openappengine.fms.form;

import java.net.URL;
import java.util.List;

import org.apache.pivot.beans.BXML;
import org.apache.pivot.beans.Bindable;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.HashMap;
import org.apache.pivot.collections.Map;
import org.apache.pivot.util.Resources;
import org.apache.pivot.wtk.Action;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.LinkButton;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewSelectionListener;

import com.openappengine.fms.util.PivotUtils;
import com.openappengine.model.party.Person;
import com.openappengine.service.api.ServiceDispatcher;
import com.openappengine.service.api.ServiceEngineContext;
import com.openappengine.service.api.ServiceException;

/**
 * @author hrishikesh.joshi
 * @since  Mar 28, 2012
 *
 */
public class CustomerListingForm extends Form implements Bindable {

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
		
		refresh.setAction(new Action() {
			
			@Override
			public void perform(Component source) {
				refreshData();
			}
		});
	}

	/**
	 * 
	 */
	private void refreshData() {
		ArrayList<HashMap<String, Object>> tableData = new ArrayList<HashMap<String, Object>>();
		ServiceDispatcher sd = ServiceEngineContext.getDefaultServiceDispatcher();
		java.util.Map<String, Object> context = new java.util.HashMap<String, Object>();
		
		java.util.Map<String, Object> resultMap = new java.util.HashMap<String, Object>();
		try {
			resultMap = sd.runSync("party.getActiveParties", context);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Person> personList = (List<Person>) resultMap.get("personPartyList");
		if(personList != null) {
			for (Person person : personList) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("CustomerId", person.getPartyId());
				row.put("Name", person.getLastName() + "," + person.getFirstName());
				row.put("BirthDate", person.getBirthDate());
				row.put("Gender", person.getGender());
				row.put("Status", person.getStatus());
				tableData.add(row);
			}
		}
		customerTableView.setTableData(tableData);
	}

}
