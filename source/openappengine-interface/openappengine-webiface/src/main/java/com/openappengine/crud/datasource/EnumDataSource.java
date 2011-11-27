/**
 * 
 */
package com.openappengine.crud.datasource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class EnumDataSource implements DataSource {
    
    private List list = new ArrayList();
    
    private Class<?> enumClass;
    
    public EnumDataSource(Class<?> enumClass) {
	super();
	this.enumClass = enumClass;
	if(enumClass == null) {
	    throw new DataSourceException("Enum class cannot be null.");
	}
	if(!Enum.class.isAssignableFrom(enumClass)) {
	    throw new DataSourceException("[Enum :" + enumClass.getName() + "] should be an enum.");
	}
	Object[] enumConstants=enumClass.getEnumConstants();
	list.addAll(Arrays.asList(enumConstants));
    }

    public List getData() {
	return list;
    }

    public int size() {
	return list.size();
    }

}
