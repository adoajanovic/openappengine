<%@ page import="com.openappengine.model.contract.Contract" %>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'contractNumber', 'error')} ">
	<label for="contractNumber">
		<g:message code="contract.contractNumber.label" default="Contract Number" />
		
	</label>
	<g:textField name="contractNumber" value="${contractInstance?.contractNumber}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'fromDate', 'error')} ">
	<label for="fromDate">
		<g:message code="contract.fromDate.label" default="From Date" />
		
	</label>
	<g:datePicker name="fromDate" precision="day" value="${contractInstance?.fromDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'toDate', 'error')} ">
	<label for="toDate">
		<g:message code="contract.toDate.label" default="To Date" />
		
	</label>
	<g:datePicker name="toDate" precision="day" value="${contractInstance?.toDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'orderRecurrence', 'error')} ">
	<label for="orderRecurrence">
		<g:message code="contract.orderRecurrence.label" default="Order Recurrence" />
		
	</label>
	<g:textField name="orderRecurrence" value="${contractInstance?.orderRecurrence}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'partyId', 'error')} ">
	<label for="partyId">
		<g:message code="contract.partyId.label" default="Party Id" />
		
	</label>
	<g:textField name="partyId" value="${contractInstance?.partyId}" />
</div>

<g:if test="${contractInstance?.lineItems}">
<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'lineItems', 'error')} ">
	<label for="lineItems">
		<g:message code="contract.lineItems.label" default="Line Items" />
		
	</label>
	<g:select name="lineItems" from="${com.openappengine.model.contract.ContractLineItem.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${contractInstance?.lineItems*.id}" class="many-to-many"/>
</div>
</g:if>