
<%@ page import="com.openappengine.model.contract.ContractLineItem" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contractLineItem.label', default: 'ContractLineItem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-contractLineItem" class="content scaffold-show" role="main">
			<h1>Line Item </h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contractLineItem">
			
				<g:if test="${contractLineItemInstance?.contract}">
					<li class="fieldcontain">
						<span id="contract-label" class="property-label"><g:message code="contractLineItem.contract.label" default="Contract" /></span>
						<span class="property-value" aria-labelledby="contract-label"><g:link controller="contract" action="show" id="${contractLineItemInstance?.contract?.contractId}">${contractLineItemInstance?.contract?.contractNumber}</g:link></span>
					</li>
				</g:if>
			
				<g:if test="${contractLineItemInstance?.product}">
					<li class="fieldcontain">
						<span id="product-label" class="property-label"><g:message code="contractLineItem.product.label" default="Product" /></span>
						<span class="property-value" aria-labelledby="product-label">${contractLineItemInstance?.product?.pdProductName}</span>
					</li>
				</g:if>
			
				<g:if test="${contractLineItemInstance?.quantity}">
					<li class="fieldcontain">
						<span id="quantity-label" class="property-label"><g:message code="contractLineItem.quantity.label" default="Quantity" /></span>
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${contractLineItemInstance}" field="quantity"/></span>
					</li>
				</g:if>
			
				<g:if test="${contractLineItemInstance?.selectedAmouunt}">
					<li class="fieldcontain">
						<span id="selectedAmouunt-label" class="property-label"><g:message code="contractLineItem.selectedAmouunt.label" default="Selected Amouunt" /></span>
						<span class="property-value" aria-labelledby="selectedAmouunt-label"><g:fieldValue bean="${contractLineItemInstance}" field="selectedAmouunt"/></span>
					</li>
				</g:if>
			
				<g:if test="${contractLineItemInstance?.status}">
					<li class="fieldcontain">
						<span id="status-label" class="property-label"><g:message code="contractLineItem.status.label" default="Status" /></span>
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${contractLineItemInstance}" field="status"/></span>
					</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${contractLineItemInstance?.lineItemId}" />
					<g:link class="edit" action="edit" id="${contractLineItemInstance?.lineItemId}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
