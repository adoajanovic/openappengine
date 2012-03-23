/**
 * 
 */
package com.openappengine.model.meta.search;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.openappengine.model.ad.ADTable;
import com.truemesh.squiggle.output.Output;
import com.truemesh.squiggle.output.Outputable;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_CRITERIA")
@Inheritance(strategy=InheritanceType.JOINED)
public class Criteria implements Serializable,Outputable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CR_CRITERIA_ID", unique = true, nullable = false)
	private int criteriaId;
	
	public int getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(int criteriaId) {
		this.criteriaId = criteriaId;
	}

	public void write(Output out) {
		
	}
	
	public Set<ADTable> getReferenceTables() {
		Set<ADTable> adTables = new HashSet<ADTable>();
		 
		return adTables;
	}
	
}
