/**
 * 
 */
package com.openappengine.crud.datasource;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.ad.ApplicationDictionaryFacade;
import com.openappengine.facade.context.FacadeContext;

/**
 * @author hrishi
 *
 */
public class ADListDataSource implements DataSource {
    
    private List list = new ArrayList();
    
    private ApplicationDictionaryFacade applicationDictionaryFacade = FacadeContext.getApplicationDictionaryFacade();
    
    public ADListDataSource(String listType) {
	super();
	initDataSource(listType);
    }

    /**
     * @param listType
     */
    private void initDataSource(String listType) {
	if(listType == null || listType.isEmpty()) {
	    throw new DataSourceException("Property ListType cannot be blank.");
	}
	this.applicationDictionaryFacade.getADListItems(listType);
    }

    /* (non-Javadoc)
     * @see com.openappengine.crud.datasource.DataSource#getData()
     */
    public List getData() {
	return list;
    }

    /* (non-Javadoc)
     * @see com.openappengine.crud.datasource.DataSource#size()
     */
    public int size() {
	return list.size();
    }

    public ApplicationDictionaryFacade getApplicationDictionaryFacade() {
	return applicationDictionaryFacade;
    }

    public void setApplicationDictionaryFacade(
	    ApplicationDictionaryFacade applicationDictionaryFacade) {
	this.applicationDictionaryFacade = applicationDictionaryFacade;
    }

}
