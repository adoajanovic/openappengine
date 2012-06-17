<%@ page import="com.openappengine.model.contract.ContractLineItem" %>

<g:hiddenField name="contract.id" value="${contractLineItemInstance?.contract?.contractId}" />

<div class="fieldcontain ${hasErrors(bean: contractLineItemInstance, field: 'product', 'error')} ">
	<label for="product">
		<g:message code="contractLineItem.product.label" default="Product" />
	</label>
	<g:select name="pdProductId" from="${com.openappengine.model.product.Product.list()}" 
			optionKey="pdProductId" optionValue="pdProductName" required="true" value="${contractLineItemInstance?.product?.pdProductId}" 
			class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractLineItemInstance, field: 'fromDate', 'error')} ">
	<label for="fromDate">
		<g:message code="contract.fromDate.label" default="From Date" />
		
	</label>
	<g:jqDatePicker id="lineItemFromDate" name="fromDate" value="${contractLineItemInstance?.fromDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractLineItemInstance, field: 'toDate', 'error')} ">
	<label for="toDate">
		<g:message code="contract.toDate.label" default="To Date" />
		
	</label>
	<g:jqDatePicker id="lineItemToDate" name="toDate" value="${contractLineItemInstance?.toDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractLineItemInstance, field: 'quantity', 'error')} ">
	<label for="quantity">
		<g:message code="contractLineItem.quantity.label" default="Quantity" />
	</label>
	<g:field type="number" name="quantity" value="${fieldValue(bean: contractLineItemInstance, field: 'quantity')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: contractLineItemInstance, field: 'selectedAmouunt', 'error')} ">
	<label for="selectedAmouunt">
		<g:message code="contractLineItem.selectedAmouunt.label" default="Selected Amouunt" />
	</label>
	<g:field type="number" name="selectedAmouunt" value="${fieldValue(bean: contractLineItemInstance, field: 'selectedAmouunt')}" />
</div>