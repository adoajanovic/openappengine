<%@ page import="com.openappengine.model.contract.Contract" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contract.label', default: 'Contract')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	
	<body>
		<div id="order-success" class="content scaffold-create" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<div class="fieldcontain">
				<label for="fromDate">
					<g:message code="orderExtraction.fromDate.label" default="From Date" />
				</label>
				
				<g:formatDate name="fromDate" format="yyyy-MM-dd" date="${params.fromDate}" readonly="true"/>
			</div>
			
			<div class="fieldcontain">
				<label for="toDate">
					<g:message code="orderExtraction.toDate.label" default="To Date" />
				</label>
				
				<g:formatDate name="toDate" format="yyyy-MM-dd" date="${params.toDate}" readonly="true"/>
			</div>
			
			<div class="fieldcontain">
				<label for="orderExtractionCount">
					<g:message code="orderExtraction.count.label" default="Total Orders Extracted" />
				</label>
				<input type="text" name="orderExtractionCount" value="${params.count}" readonly="true"/>
			</div>
			
		</div>
	</body>
</html>
