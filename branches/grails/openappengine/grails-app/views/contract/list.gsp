
<%@ page import="com.openappengine.model.contract.Contract" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contract.label', default: 'Contract')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-contract" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="contractId" title="${message(code: 'contract.contractId.label', default: 'Contract Id')}" />
					
						<g:sortableColumn property="contractNumber" title="${message(code: 'contract.contractNumber.label', default: 'Contract Number')}" />
					
						<g:sortableColumn property="discontinueDate" title="${message(code: 'contract.discontinueDate.label', default: 'Discontinue Date')}" />
					
						<g:sortableColumn property="fromDate" title="${message(code: 'contract.fromDate.label', default: 'From Date')}" />
					
						<g:sortableColumn property="orderRecurrence" title="${message(code: 'contract.orderRecurrence.label', default: 'Order Recurrence')}" />
					
						<g:sortableColumn property="partyId" title="${message(code: 'contract.partyId.label', default: 'Party Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contractInstanceList}" status="i" var="contractInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contractInstance.id}">${fieldValue(bean: contractInstance, field: "contractId")}</g:link></td>
					
						<td>${fieldValue(bean: contractInstance, field: "contractNumber")}</td>
					
						<td><g:formatDate date="${contractInstance.discontinueDate}" /></td>
					
						<td><g:formatDate date="${contractInstance.fromDate}" /></td>
					
						<td>${fieldValue(bean: contractInstance, field: "orderRecurrence")}</td>
					
						<td>${fieldValue(bean: contractInstance, field: "partyId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contractInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
