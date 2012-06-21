
<%@ page import="com.openappengine.model.fm.Payment" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fmPayment.label', default: 'FmPayment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-fmPayment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="paymentId" title="${message(code: 'fmPayment.paymentId.label', default: 'Payment Id')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'fmPayment.amount.label', default: 'Amount')}" />
					
						<g:sortableColumn property="billingAccountId" title="${message(code: 'fmPayment.billingAccountId.label', default: 'Billing Account Id')}" />
					
						<g:sortableColumn property="contractExternalId" title="${message(code: 'fmPayment.contractExternalId.label', default: 'Contract External Id')}" />
					
						<g:sortableColumn property="currencyUom" title="${message(code: 'fmPayment.currencyUom.label', default: 'Currency Uom')}" />
					
						<g:sortableColumn property="effectiveDate" title="${message(code: 'fmPayment.effectiveDate.label', default: 'Effective Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${fmPaymentInstanceList}" status="i" var="fmPaymentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${fmPaymentInstance.paymentId}">${fieldValue(bean: fmPaymentInstance, field: "paymentId")}</g:link></td>
					
						<td>${fieldValue(bean: fmPaymentInstance, field: "amount")}</td>
					
						<td>${fieldValue(bean: fmPaymentInstance, field: "billingAccountId")}</td>
					
						<td>${fieldValue(bean: fmPaymentInstance, field: "contractExternalId")}</td>
					
						<td>${fieldValue(bean: fmPaymentInstance, field: "currencyUom")}</td>
					
						<td><g:formatDate date="${fmPaymentInstance.effectiveDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${fmPaymentInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
