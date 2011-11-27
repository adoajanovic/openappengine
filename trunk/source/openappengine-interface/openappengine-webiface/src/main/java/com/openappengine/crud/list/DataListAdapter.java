/**
 * 
 */
package com.openappengine.crud.list;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.openappengine.crud.Row;


/**
 * @author hrishi
 *
 */
public class DataListAdapter<T> {
    
    private DataModel<Row> dataModel = new ListDataModel<Row>();
    
    private List<T> data = new ArrayList<T>();
    
    public void addData(T t) {
	data.add(t);
    }

    public DataModel getDataModel() {
	List<Row> rows = new ArrayList<Row>();
	for(T t : data) {
	    rows.add(new Row(t));
	}
	dataModel.setWrappedData(rows);
	return dataModel;
    }

    public void setDataModel(DataModel<Row> dataModel) {
        this.dataModel = dataModel;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
