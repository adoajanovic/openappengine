/**
 * 
 */
package com.openappengine.model.fm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="fm_order_type")
public class OtOrderType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="seqGenerator")  
	@TableGenerator(name="seqGenerator", table="ad_table_sequences",pkColumnName="TS_SEQUENCE_NAME",valueColumnName="TS_SEQUENCE_VALUE",
	                allocationSize=1 // flush every 1 insert  
	)
	@Column(name="OT_ORDER_TYPE_ID", unique=true, nullable=false)
	private int orderTypeId;
	
	@Column(name="OT_HAS_TABLE")
	private boolean hasTable;
	
	@Column(name="OT_DESCRIPTION")
	private String description;

	public int getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(int orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public boolean isHasTable() {
		return hasTable;
	}

	public void setHasTable(boolean hasTable) {
		this.hasTable = hasTable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
