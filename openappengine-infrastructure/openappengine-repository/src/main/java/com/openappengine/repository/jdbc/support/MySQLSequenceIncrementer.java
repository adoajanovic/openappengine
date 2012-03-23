/**
 * 
 */
package com.openappengine.repository.jdbc.support;

import javax.sql.DataSource;

import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

/**
 * @author hrishi
 *
 */
public class MySQLSequenceIncrementer {
	
	private static final String COLUMN_SEQ = "value";
	
	private DataSource dataSource;
	
	public int nextValue(String tableName) {
		MySQLMaxValueIncrementer incrementer = new MySQLMaxValueIncrementer(dataSource, tableName, COLUMN_SEQ);
		return incrementer.nextIntValue();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
