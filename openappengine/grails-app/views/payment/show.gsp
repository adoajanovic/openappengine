
<%@ page import="com.openappengine.model.fm.Payment" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fmPayment.label', default: 'FmPayment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-fmPayment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-fmPayment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list fmPayment">
			
				<g:if test="${fmPaymentInstance?.paymentId}">
				<li class="fieldcontain">
					<span id="paymentId-label" class="property-label"><g:message code="fmPayment.paymentId.label" default="Payment Id" /></span>
					
						<span class="property-value" aria-labelledby="paymentId-label"><g:fieldValue bean="${fmPaymentInstance}" field="paymentId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="fmPayment.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${fmPaymentInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.billingAccountId}">
				<li class="fieldcontain">
					<span id="billingAccountId-label" class="property-label"><g:message code="fmPayment.billingAccountId.label" default="Billing Account Id" /></span>
					
						<span class="property-value" aria-labelledby="billingAccountId-label"><g:fieldValue bean="${fmPaymentInstance}" field="billingAccountId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.contractExternalId}">
				<li class="fieldcontain">
					<span id="contractExternalId-label" class="property-label"><g:message code="fmPayment.contractExternalId.label" default="Contract External Id" /></span>
					
						<span class="property-value" aria-labelledby="contractExternalId-label"><g:fieldValue bean="${fmPaymentInstance}" field="contractExternalId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.currencyUom}">
				<li class="fieldcontain">
					<span id="currencyUom-label" class="property-label"><g:message code="fmPayment.currencyUom.label" default="Currency Uom" /></span>
					
						<span class="property-value" aria-labelledby="currencyUom-label"><g:fieldValue bean="${fmPaymentInstance}" field="currencyUom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.effectiveDate}">
				<li class="fieldcontain">
					<span id="effectiveDate-label" class="property-label"><g:message code="fmPayment.effectiveDate.label" default="Effective Date" /></span>
					
						<span class="property-value" aria-labelledby="effectiveDate-label"><g:formatDate date="${fmPaymentInstance?.effectiveDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.orderNumber}">
				<li class="fieldcontain">
					<span id="orderNumber-label" class="property-label"><g:message code="fmPayment.orderNumber.label" default="Order Number" /></span>
					
						<span class="property-value" aria-labelledby="orderNumber-label"><g:fieldValue bean="${fmPaymentInstance}" field="orderNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.partyExternalIdFrom}">
				<li class="fieldcontain">
					<span id="partyExternalIdFrom-label" class="property-label"><g:message code="fmPayment.partyExternalIdFrom.label" default="Party External Id From" /></span>
					
						<span class="property-value" aria-labelledby="partyExternalIdFrom-label"><g:fieldValue bean="${fmPaymentInstance}" field="partyExternalIdFrom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.partyExternalIdTo}">
				<li class="fieldcontain">
					<span id="partyExternalIdTo-label" class="property-label"><g:message code="fmPayment.partyExternalIdTo.label" default="Party External Id To" /></span>
					
						<span class="property-value" aria-labelledby="partyExternalIdTo-label"><g:fieldValue bean="${fmPaymentInstance}" field="partyExternalIdTo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.paymentMethod}">
				<li class="fieldcontain">
					<span id="paymentMethod-label" class="property-label"><g:message code="fmPayment.paymentMethod.label" default="Payment Method" /></span>
					
						<span class="property-value" aria-labelledby="paymentMethod-label"><g:fieldValue bean="${fmPaymentInstance}" field="paymentMethod"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.paymentNumber}">
				<li class="fieldcontain">
					<span id="paymentNumber-label" class="property-label"><g:message code="fmPayment.paymentNumber.label" default="Payment Number" /></span>
					
						<span class="property-value" aria-labelledby="paymentNumber-label"><g:fieldValue bean="${fmPaymentInstance}" field="paymentNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.paymentType}">
				<li class="fieldcontain">
					<span id="paymentType-label" class="property-label"><g:message code="fmPayment.paymentType.label" default="Payment Type" /></span>
					
						<span class="property-value" aria-labelledby="paymentType-label"><g:fieldValue bean="${fmPaymentInstance}" field="paymentType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="fmPayment.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${fmPaymentInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fmPaymentInstance?.transactionId}">
				<li class="fieldcontain">
					<span id="transactionId-label" class="property-label"><g:message code="fmPayment.transactionId.label" default="Transaction Id" /></span>
					
						<span class="property-value" aria-labelledby="transactionId-label"><g:fieldValue bean="${fmPaymentInstance}" field="transactionId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${fmPaymentInstance?.id}" />
					<g:link class="edit" action="edit" id="${fmPaymentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
