
<%@ page import="com.openappengine.model.product.Product" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-product" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="pdProductId" title="${message(code: 'product.pdProductId.label', default: 'Product Id')}" />
						
						<g:sortableColumn property="pdProductName" title="${message(code: 'product.pdProductName.label', default: 'Product Name')}" />
					
						<g:sortableColumn property="pdIntroductionDate" title="${message(code: 'product.pdIntroductionDate.label', default: 'Introduction Date')}" />
						
						<g:sortableColumn property="pdSalesDiscontinuationDate" title="${message(code: 'product.pdSalesDiscontinuationDate.label', default: 'Discontinuation Date')}" />
					
						<g:sortableColumn property="pdFixedAmount" title="${message(code: 'product.pdFixedAmount.label', default: 'Fixed Amount')}" />
					
						<g:sortableColumn property="pdTaxable" title="${message(code: 'product.pdTaxable.label', default: 'Taxable')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productInstanceList}" status="i" var="productInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productInstance.pdProductId}">${fieldValue(bean: productInstance, field: "pdProductId")}</g:link></td>
					
						<td>${fieldValue(bean: productInstance, field: "pdProductName")}</td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${productInstance.pdIntroductionDate}" /></td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${productInstance.pdSalesDiscontinuationDate}" /></td>
					
						<td><g:formatNumber number="${productInstance.pdFixedAmount}" type="number" maxFractionDigits="2" /></td>
						
						<td><g:formatBoolean boolean="${productInstance.pdTaxable}" true="Y" false="N" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
