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

import com.openappengine.model.meta.ADColumn;
import com.openappengine.model.meta.ADTable;
import com.truemesh.squiggle.output.Output;
import com.truemesh.squiggle.output.Outputable;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_SELECTION")
public class Selection implements Serializable,Outputable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SL_SELECTION_ID", unique=true, nullable=false)
	private int selectionId;
	
	@OneToOne
	@Column(name="SL_COLUMN_ID", nullable=false)
	private ADColumn adColumn;
	
	@OneToOne
	@Column(name="SL_TABLE_ID", nullable=false)
	private ADTable adTable;
	
	@Column(name="SL_DISPLAY_NAME", nullable=false)
	private String displayName;

	public int getSelectionId() {
		return selectionId;
	}

	public void setSelectionId(int selectionId) {
		this.selectionId = selectionId;
	}

	public ADColumn getAdColumn() {
		return adColumn;
	}

	public void setAdColumn(ADColumn adColumn) {
		this.adColumn = adColumn;
	}

	public ADTable getAdTable() {
		return adTable;
	}

	public void setAdTable(ADTable adTable) {
		this.adTable = adTable;
	}

	public void write(Output out) {
		out.print(adTable.getTableName() + "." + adColumn.getColumnName());
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
