package com.ms.openapps.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ms.openapps.entity.GenericEntity;


/**
 * The persistent class for the ARCH_AGGREGATE_SERVICE database table.
 * 
 */
@Entity
@Table(name="ARCH_AGGREGATE_SERVICE")
public class ArchAggregateService extends GenericEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="AGGREGATE_SERVICE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aggregateServiceId;

	@Column(name = "REQUIRES_DELEGATOR", length = 1)
	private Boolean requiresDelegator;

	@Column(name="SERVICE_NAME", nullable=false, length=255)
	private String serviceName;

	@Column(name="SERVICE_RUNNER_CLASS", nullable=false, length=100)
	private String serviceRunnerClass;

	@Column(name="XML_SERVICE", length=1)
	private Boolean xmlService;

	//bi-directional many-to-one association to ArchAggregate
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="AGGREGATE_ID", nullable=false)
	private ArchAggregate archAggregate;

    public ArchAggregateService() {
    }

	public Boolean getRequiresDelegator() {
		return this.requiresDelegator;
	}

	public void setRequiresDelegator(Boolean requiresDelegator) {
		this.requiresDelegator = requiresDelegator;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceRunnerClass() {
		return this.serviceRunnerClass;
	}

	public void setServiceRunnerClass(String serviceRunnerClass) {
		this.serviceRunnerClass = serviceRunnerClass;
	}

	public Boolean getXmlService() {
		return this.xmlService;
	}

	public void setXmlService(Boolean xmlService) {
		this.xmlService = xmlService;
	}

	public ArchAggregate getArchAggregate() {
		return this.archAggregate;
	}

	public void setArchAggregate(ArchAggregate archAggregate) {
		this.archAggregate = archAggregate;
	}

	public int getAggregateServiceId() {
		return aggregateServiceId;
	}

	public void setAggregateServiceId(int aggregateServiceId) {
		this.aggregateServiceId = aggregateServiceId;
	}
	
}