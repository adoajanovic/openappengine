/**
 * 
 */
package com.openappengine.model.meta.search;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.openappengine.model.ad.ADColumn;
import com.openappengine.model.ad.ADTable;
import com.truemesh.squiggle.output.Output;
import com.truemesh.squiggle.output.Outputable;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_ORDER_BY")
public class Order implements Serializable, Outputable {

	private static final String ASC = "ASC";

	private static final String DESC = "DESC";

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OB_ORDER_BY_ID", unique=true, nullable=false)
	private int orderbyId;
	
	@OneToOne
	private ADColumn orderByColumn;
	
	@OneToOne
	private ADTable orderTable;
	
	@Column(name="OB_ASCDESC_ID", nullable=false)
	private String orderByMode = ASC;
	
	public int getOrderbyId() {
		return orderbyId;
	}

	public void setOrderbyId(int orderbyId) {
		this.orderbyId = orderbyId;
	}

	public ADColumn getOrderByColumn() {
		return orderByColumn;
	}

	public void setOrderByColumn(ADColumn orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

	public ADTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(ADTable orderTable) {
		this.orderTable = orderTable;
	}

	public String getOrderByMode() {
		return orderByMode;
	}

	public void setOrderByMode(String orderByMode) {
		this.orderByMode = orderByMode;
	}

	public void write(Output out) {
		out.print(orderByColumn.getColumnName());
		if(!orderByMode.equalsIgnoreCase(ASC)) {
			out.print(" " + DESC);	
		}
	}

}
