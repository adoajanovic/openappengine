
<%@ page import="com.openappengine.model.fm.OhOrderHeader" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ohOrderHeader.label', default: 'OhOrderHeader')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-ohOrderHeader" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ohOrderHeader">
			
				<g:if test="${ohOrderHeaderInstance?.orderId}">
				<li class="fieldcontain">
					<span id="orderId-label" class="property-label"><g:message code="ohOrderHeader.orderId.label" default="Order Id" /></span>
					
						<span class="property-value" aria-labelledby="orderId-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="orderId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.billingAccountId}">
				<li class="fieldcontain">
					<span id="billingAccountId-label" class="property-label"><g:message code="ohOrderHeader.billingAccountId.label" default="Billing Account Id" /></span>
					
						<span class="property-value" aria-labelledby="billingAccountId-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="billingAccountId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.contractNumber}">
				<li class="fieldcontain">
					<span id="contractNumber-label" class="property-label"><g:message code="ohOrderHeader.contractNumber.label" default="Contract Number" /></span>
					
						<span class="property-value" aria-labelledby="contractNumber-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="contractNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.currencyUom}">
				<li class="fieldcontain">
					<span id="currencyUom-label" class="property-label"><g:message code="ohOrderHeader.currencyUom.label" default="Currency Uom" /></span>
					
						<span class="property-value" aria-labelledby="currencyUom-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="currencyUom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.entryDate}">
				<li class="fieldcontain">
					<span id="entryDate-label" class="property-label"><g:message code="ohOrderHeader.entryDate.label" default="Entry Date" /></span>
					
						<span class="property-value" aria-labelledby="entryDate-label"><g:formatDate date="${ohOrderHeaderInstance?.entryDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.externalId}">
				<li class="fieldcontain">
					<span id="externalId-label" class="property-label"><g:message code="ohOrderHeader.externalId.label" default="External Id" /></span>
					
						<span class="property-value" aria-labelledby="externalId-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="externalId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.fromDate}">
				<li class="fieldcontain">
					<span id="fromDate-label" class="property-label"><g:message code="ohOrderHeader.fromDate.label" default="From Date" /></span>
					
						<span class="property-value" aria-labelledby="fromDate-label"><g:formatDate date="${ohOrderHeaderInstance?.fromDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.grandTotal}">
				<li class="fieldcontain">
					<span id="grandTotal-label" class="property-label"><g:message code="ohOrderHeader.grandTotal.label" default="Grand Total" /></span>
					
						<span class="property-value" aria-labelledby="grandTotal-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="grandTotal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.orderDate}">
				<li class="fieldcontain">
					<span id="orderDate-label" class="property-label"><g:message code="ohOrderHeader.orderDate.label" default="Order Date" /></span>
					
						<span class="property-value" aria-labelledby="orderDate-label"><g:formatDate date="${ohOrderHeaderInstance?.orderDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.orderItems}">
				<li class="fieldcontain">
					<span id="orderItems-label" class="property-label"><g:message code="ohOrderHeader.orderItems.label" default="Order Items" /></span>
						<g:each in="${ohOrderHeaderInstance.orderItems}" var="o">
						<span class="property-value" aria-labelledby="orderItems-label"><g:link controller="oiOrderItem" action="show" id="${o.orderItemId}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.orderName}">
				<li class="fieldcontain">
					<span id="orderName-label" class="property-label"><g:message code="ohOrderHeader.orderName.label" default="Order Name" /></span>
					
						<span class="property-value" aria-labelledby="orderName-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="orderName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.orderType}">
				<li class="fieldcontain">
					<span id="orderType-label" class="property-label"><g:message code="ohOrderHeader.orderType.label" default="Order Type" /></span>
					
						<span class="property-value" aria-labelledby="orderType-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="orderType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.priority}">
				<li class="fieldcontain">
					<span id="priority-label" class="property-label"><g:message code="ohOrderHeader.priority.label" default="Priority" /></span>
					
						<span class="property-value" aria-labelledby="priority-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="priority"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.productStoreId}">
				<li class="fieldcontain">
					<span id="productStoreId-label" class="property-label"><g:message code="ohOrderHeader.productStoreId.label" default="Product Store Id" /></span>
					
						<span class="property-value" aria-labelledby="productStoreId-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="productStoreId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="ohOrderHeader.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.toDate}">
				<li class="fieldcontain">
					<span id="toDate-label" class="property-label"><g:message code="ohOrderHeader.toDate.label" default="To Date" /></span>
					
						<span class="property-value" aria-labelledby="toDate-label"><g:formatDate date="${ohOrderHeaderInstance?.toDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ohOrderHeaderInstance?.transactionId}">
				<li class="fieldcontain">
					<span id="transactionId-label" class="property-label"><g:message code="ohOrderHeader.transactionId.label" default="Transaction Id" /></span>
					
						<span class="property-value" aria-labelledby="transactionId-label"><g:fieldValue bean="${ohOrderHeaderInstance}" field="transactionId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ohOrderHeaderInstance?.orderId}" />
					<g:link class="edit" action="edit" id="${ohOrderHeaderInstance?.orderId}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
