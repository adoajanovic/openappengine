package com.ms.openapps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ms.openapps.entity.GenericEntity;


/**
 * The persistent class for the ARCH_AGGREGATE database table.
 * 
 */
@Entity
@Table(name="ARCH_AGGREGATE")
public class ArchAggregate extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AGGREGATE_ID", unique=true, nullable=false)
	private int aggregateId;

	@Column(name="AGGREGATE_NAME", length=255)
	private String aggregateName;
	
	@Column(name="CLASS_LOADER", length=255)
	private String classLoader;

	//bi-directional many-to-one association to ArchAggregateService
	@OneToMany(mappedBy="archAggregate", cascade={CascadeType.ALL})
	private List<ArchAggregateService> archAggregateServices;

    public ArchAggregate() {
    }

	public int getAggregateId() {
		return this.aggregateId;
	}

	public void setAggregateId(int aggregateId) {
		this.aggregateId = aggregateId;
	}

	public String getAggregateName() {
		return this.aggregateName;
	}

	public void setAggregateName(String aggregateName) {
		this.aggregateName = aggregateName;
	}

	public List<ArchAggregateService> getArchAggregateServices() {
		return this.archAggregateServices;
	}

	public void setArchAggregateServices(List<ArchAggregateService> archAggregateServices) {
		this.archAggregateServices = archAggregateServices;
	}

	public String getClassLoader() {
		return classLoader;
	}

	public void setClassLoader(String classLoader) {
		this.classLoader = classLoader;
	}
	
}