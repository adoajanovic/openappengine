/**
 * 
 */
package com.openappengine.crud.datasource;

import java.util.List;

/**
 * @author hrishi
 *
 */
public interface DataSource {

    public List getData();
    
    public int size();
}
