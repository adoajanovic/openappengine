<%@page import="com.openappengine.master.OrderRecurrence"%>
<%@ page import="com.openappengine.model.contract.Contract" %>
<script type="text/javascript">
	formatResult = function(oResultData, sQuery, sResultMatch) {
	    var sMarkup = (sResultMatch) ? sResultMatch : "";
	    return oResultData[1];
	};
</script>
<div>
	<label for="partyId">
		<g:message code="contract.partyId.label" default="Party Id" />
	</label>
	
	<richui:autoComplete name="partyId" action="${createLinkTo('dir': 'person/searchAJAX')}" 
		onItemSelect="alert(id);" formatResult="formatResult" />
	<g:hiddenField name="partyId" value="" /> 	
</div>

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
	<g:jqDatePicker name="fromDate" value="${contractInstance?.fromDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'toDate', 'error')} ">
	<label for="toDate">
		<g:message code="contract.toDate.label" default="To Date" />
	</label>
	<g:jqDatePicker name="toDate" value="${contractInstance?.toDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'orderRecurrence', 'error')} ">
	<label for="orderRecurrence">
		<g:message code="contract.orderRecurrence.label" default="Order Recurrence" />
	</label>
	<g:select name="orderRecurrence" from="${OrderRecurrence?.values()}"
		value="${contractInstance?.orderRecurrence}" optionKey="key" />	
</div>

<g:if test="${contractInstance?.lineItems}">
<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'lineItems', 'error')} ">
	<label for="lineItems">
		<g:message code="contract.lineItems.label" default="Line Items" />
	</label>
	<g:select name="lineItems" from="${com.openappengine.model.contract.ContractLineItem.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${contractInstance?.lineItems*.lineItemId}" class="many-to-many"/>
</div>
</g:if>