
<%@ page import="com.openappengine.model.fm.OhOrderHeader" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ohOrderHeader.label', default: 'OhOrderHeader')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-ohOrderHeader" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="orderId" title="${message(code: 'ohOrderHeader.orderId.label', default: 'Order Id')}" />
					
						<g:sortableColumn property="billingAccountId" title="${message(code: 'ohOrderHeader.billingAccountId.label', default: 'Billing Account Id')}" />
					
						<g:sortableColumn property="contractNumber" title="${message(code: 'ohOrderHeader.contractNumber.label', default: 'Contract Number')}" />
					
						<g:sortableColumn property="currencyUom" title="${message(code: 'ohOrderHeader.currencyUom.label', default: 'Currency Uom')}" />
					
						<g:sortableColumn property="entryDate" title="${message(code: 'ohOrderHeader.entryDate.label', default: 'Entry Date')}" />
					
						<g:sortableColumn property="externalId" title="${message(code: 'ohOrderHeader.externalId.label', default: 'External Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ohOrderHeaderInstanceList}" status="i" var="ohOrderHeaderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ohOrderHeaderInstance.orderId}">${fieldValue(bean: ohOrderHeaderInstance, field: "orderId")}</g:link></td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "billingAccountId")}</td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "contractNumber")}</td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "currencyUom")}</td>
					
						<td><g:formatDate date="${ohOrderHeaderInstance.entryDate}" /></td>
					
						<td>${fieldValue(bean: ohOrderHeaderInstance, field: "externalId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ohOrderHeaderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
