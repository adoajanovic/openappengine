/**
 * 
 */
package com.openappengine.repository.jdbc.support;

import javax.sql.DataSource;

import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

/**
 * @author hrishi
 *
 */
public class MySQLSequenceIncrementer {
	
	private static final String COLUMN_SEQ = "value";
	
	private DataSource dataSource;
	
	public int nextValue(String tableName) {
		H2SequenceMaxValueIncrementer incrementer = new H2SequenceMaxValueIncrementer(dataSource, tableName);
		return incrementer.nextIntValue();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
