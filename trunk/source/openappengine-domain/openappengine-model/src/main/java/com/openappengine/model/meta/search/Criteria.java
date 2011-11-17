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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.openappengine.model.meta.ADTable;
import com.truemesh.squiggle.output.Output;
import com.truemesh.squiggle.output.Outputable;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_CRITERIA")
public class Criteria implements Serializable,Outputable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CR_CRITERIA_ID", unique = true, nullable = false)
	private int criteriaId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private MatchCriteria matchCriteria;

	/*@OneToOne
	@PrimaryKeyJoinColumn
	private LogicCriteria logicCriteria;*/
	
	public int getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(int criteriaId) {
		this.criteriaId = criteriaId;
	}

	public MatchCriteria getMatchCriteria() {
		return matchCriteria;
	}

	public void setMatchCriteria(MatchCriteria matchCriteria) {
		this.matchCriteria = matchCriteria;
	}

	public void write(Output out) {
		
	}
	
	public Set<ADTable> getReferenceTables() {
		Set<ADTable> adTables = new HashSet<ADTable>();
		 
		return adTables;
	}

/*	public LogicCriteria getLogicCriteria() {
		return logicCriteria;
	}

	public void setLogicCriteria(LogicCriteria logicCriteria) {
		this.logicCriteria = logicCriteria;
	}*/
	
}
