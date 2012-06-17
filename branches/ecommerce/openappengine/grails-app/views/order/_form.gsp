<%@ page import="com.openappengine.model.fm.OhOrderHeader" %>



<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'orderId', 'error')} ">
	<label for="orderId">
		<g:message code="ohOrderHeader.orderId.label" default="Order Id" />
		
	</label>
	<g:field type="number" name="orderId" value="${fieldValue(bean: ohOrderHeaderInstance, field: 'orderId')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'billingAccountId', 'error')} ">
	<label for="billingAccountId">
		<g:message code="ohOrderHeader.billingAccountId.label" default="Billing Account Id" />
		
	</label>
	<g:textField name="billingAccountId" value="${ohOrderHeaderInstance?.billingAccountId}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'contractNumber', 'error')} ">
	<label for="contractNumber">
		<g:message code="ohOrderHeader.contractNumber.label" default="Contract Number" />
		
	</label>
	<g:textField name="contractNumber" value="${ohOrderHeaderInstance?.contractNumber}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'currencyUom', 'error')} ">
	<label for="currencyUom">
		<g:message code="ohOrderHeader.currencyUom.label" default="Currency Uom" />
		
	</label>
	<g:textField name="currencyUom" value="${ohOrderHeaderInstance?.currencyUom}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'entryDate', 'error')} ">
	<label for="entryDate">
		<g:message code="ohOrderHeader.entryDate.label" default="Entry Date" />
		
	</label>
	<g:datePicker name="entryDate" precision="day" value="${ohOrderHeaderInstance?.entryDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'externalId', 'error')} ">
	<label for="externalId">
		<g:message code="ohOrderHeader.externalId.label" default="External Id" />
		
	</label>
	<g:textField name="externalId" value="${ohOrderHeaderInstance?.externalId}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'fromDate', 'error')} ">
	<label for="fromDate">
		<g:message code="ohOrderHeader.fromDate.label" default="From Date" />
		
	</label>
	<g:datePicker name="fromDate" precision="day" value="${ohOrderHeaderInstance?.fromDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'grandTotal', 'error')} ">
	<label for="grandTotal">
		<g:message code="ohOrderHeader.grandTotal.label" default="Grand Total" />
		
	</label>
	<g:field type="number" name="grandTotal" value="${fieldValue(bean: ohOrderHeaderInstance, field: 'grandTotal')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'orderDate', 'error')} ">
	<label for="orderDate">
		<g:message code="ohOrderHeader.orderDate.label" default="Order Date" />
		
	</label>
	<g:datePicker name="orderDate" precision="day" value="${ohOrderHeaderInstance?.orderDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'orderItems', 'error')} ">
	<label for="orderItems">
		<g:message code="ohOrderHeader.orderItems.label" default="Order Items" />
		
	</label>
	<g:select name="orderItems" from="${com.openappengine.model.fm.OiOrderItem.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${ohOrderHeaderInstance?.orderItems*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'orderName', 'error')} ">
	<label for="orderName">
		<g:message code="ohOrderHeader.orderName.label" default="Order Name" />
		
	</label>
	<g:textField name="orderName" value="${ohOrderHeaderInstance?.orderName}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'orderType', 'error')} ">
	<label for="orderType">
		<g:message code="ohOrderHeader.orderType.label" default="Order Type" />
		
	</label>
	<g:textField name="orderType" value="${ohOrderHeaderInstance?.orderType}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'priority', 'error')} ">
	<label for="priority">
		<g:message code="ohOrderHeader.priority.label" default="Priority" />
		
	</label>
	<g:field type="number" name="priority" value="${fieldValue(bean: ohOrderHeaderInstance, field: 'priority')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'productStoreId', 'error')} ">
	<label for="productStoreId">
		<g:message code="ohOrderHeader.productStoreId.label" default="Product Store Id" />
		
	</label>
	<g:textField name="productStoreId" value="${ohOrderHeaderInstance?.productStoreId}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="ohOrderHeader.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${ohOrderHeaderInstance?.status}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'toDate', 'error')} ">
	<label for="toDate">
		<g:message code="ohOrderHeader.toDate.label" default="To Date" />
	</label>
	<g:datePicker name="toDate" precision="day" value="${ohOrderHeaderInstance?.toDate}" />
</div>

<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'transactionId', 'error')} ">
	<label for="transactionId">
		<g:message code="ohOrderHeader.transactionId.label" default="Transaction Id" />
		
	</label>
	<g:textField name="transactionId" value="${ohOrderHeaderInstance?.transactionId}" />
</div>

