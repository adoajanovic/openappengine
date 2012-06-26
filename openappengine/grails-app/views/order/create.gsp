<%@ page import="com.openappengine.model.fm.OhOrderHeader" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ohOrderHeader.label', default: 'OhOrderHeader')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="create-ohOrderHeader" class="content scaffold-create" role="main">
			<g:hasErrors bean="${ohOrderHeaderInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${ohOrderHeaderInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'fromDate', 'error')} ">
						<label for="toDate">
							<g:message code="ohOrderHeader.toDate.label" default="From Date" />
						</label>
						<g:jqDatePicker name="toDate" value="${contractInstance?.fromDate}" />
					</div>
					
					<div class="fieldcontain ${hasErrors(bean: ohOrderHeaderInstance, field: 'toDate', 'error')} ">
						<label for="toDate">
							<g:message code="ohOrderHeader.toDate.label" default="To Date" />
						</label>
						<g:jqDatePicker name="toDate" value="${contractInstance?.toDate}" />
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save"
						value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
