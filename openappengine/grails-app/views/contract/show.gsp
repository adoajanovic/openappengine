
<%@ page import="com.openappengine.model.contract.Contract" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contract.label', default: 'Contract')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-contract" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contract">
			
				<g:if test="${contractInstance?.contractId}">
				<li class="fieldcontain">
					<span id="contractId-label" class="property-label"><g:message code="contract.contractId.label" default="Contract Id" /></span>
					
						<span class="property-value" aria-labelledby="contractId-label"><g:fieldValue bean="${contractInstance}" field="contractId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.contractNumber}">
				<li class="fieldcontain">
					<span id="contractNumber-label" class="property-label"><g:message code="contract.contractNumber.label" default="Contract Number" /></span>
					
						<span class="property-value" aria-labelledby="contractNumber-label"><g:fieldValue bean="${contractInstance}" field="contractNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.discontinueDate}">
				<li class="fieldcontain">
					<span id="discontinueDate-label" class="property-label"><g:message code="contract.discontinueDate.label" default="Discontinue Date" /></span>
					
						<span class="property-value" aria-labelledby="discontinueDate-label"><g:formatDate date="${contractInstance?.discontinueDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.fromDate}">
				<li class="fieldcontain">
					<span id="fromDate-label" class="property-label"><g:message code="contract.fromDate.label" default="From Date" /></span>
					
						<span class="property-value" aria-labelledby="fromDate-label"><g:formatDate date="${contractInstance?.fromDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.lineItems}">
				<li class="fieldcontain">
					<span id="lineItems-label" class="property-label"><g:message code="contract.lineItems.label" default="Line Items" /></span>
					
						<g:each in="${contractInstance.lineItems}" var="l">
						<span class="property-value" aria-labelledby="lineItems-label"><g:link controller="contractLineItem" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.orderRecurrence}">
				<li class="fieldcontain">
					<span id="orderRecurrence-label" class="property-label"><g:message code="contract.orderRecurrence.label" default="Order Recurrence" /></span>
					
						<span class="property-value" aria-labelledby="orderRecurrence-label"><g:fieldValue bean="${contractInstance}" field="orderRecurrence"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.partyId}">
				<li class="fieldcontain">
					<span id="partyId-label" class="property-label"><g:message code="contract.partyId.label" default="Party Id" /></span>
					
						<span class="property-value" aria-labelledby="partyId-label"><g:fieldValue bean="${contractInstance}" field="partyId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractInstance?.toDate}">
				<li class="fieldcontain">
					<span id="toDate-label" class="property-label"><g:message code="contract.toDate.label" default="To Date" /></span>
					
						<span class="property-value" aria-labelledby="toDate-label"><g:formatDate date="${contractInstance?.toDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${contractInstance?.id}" />
					<g:link class="edit" action="edit" id="${contractInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
