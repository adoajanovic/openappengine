/**
 * 
 */
package com.openappengine.crud.datasource;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.web.ad.ADListItem;

/**
 * @author hrishi
 * 
 */
public class ADListDataSource implements DataSource {

	private List list = new ArrayList();

	// private ApplicationDictionaryFacade applicationDictionaryFacade =
	// FacadeContext.getApplicationDictionaryFacade();
	
	public ADListDataSource() { 
	}

	public ADListDataSource(String listType) {
		super();
		initDataSource(listType);
	}

	/**
	 * @param listType
	 */
	private void initDataSource(String listType) {
		if (listType == null || listType.isEmpty()) {
			throw new DataSourceException("Property ListType cannot be blank.");
		}
		// this.applicationDictionaryFacade.getADListItems(listType);
		//TODO
		if(listType.equals("currency")) {
			list = new ArrayList();
			list.add(new ADListItem("INR", "INR", "INR"));
			list.add(new ADListItem("USD", "USD", "USD"));
			list.add(new ADListItem("EUR", "EUR", "EUR"));
		}
	}
	
	public List getADDataList(String listType) {
		initDataSource(listType);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openappengine.crud.datasource.DataSource#getData()
	 */
	public List getData() {
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openappengine.crud.datasource.DataSource#size()
	 */
	public int size() {
		return list.size();
	}
}
