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
import javax.persistence.Table;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_CRITERIA")
public class Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CR_CRITERIA_ID", unique = true, nullable = false)
	private int criteriaId;
	
	
}
