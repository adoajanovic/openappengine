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
import org.apache.pivot.wtk.Form;
import org.apache.pivot.wtk.TableView;
import org.apache.pivot.wtk.TableViewSelectionListener;

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
	
	@Override
	public void initialize(Map<String, Object> namespace, URL location,Resources resources) {
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
				row.put("Name", person.getFirstName() + person.getLastName());
				row.put("BirthDate", person.getBirthDate());
				row.put("Gender", person.getGender());
				row.put("Status", person.getStatus());
				tableData.add(row);
			}
		}
		customerTableView.setTableData(tableData);
		
		
		customerTableView.getTableViewSelectionListeners().add(new TableViewSelectionListener.Adapter() {

			@Override
			public void selectedRowChanged(TableView tableView,Object previousSelectedRow) {
				//TODO 
			}
			
		});
	}

}
