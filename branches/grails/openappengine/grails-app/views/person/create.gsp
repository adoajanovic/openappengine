<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="create-person" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${personInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${personInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<%--<div id='jqxWidget'>
			        <div id='jqxTabs'>
			            <ul>
			                <li style="margin-left: 30px;">Personal Info</li>
			                <li>Address</li>
			            </ul>
			            <div class="section">
			                <div id="personForm">
			                   <!-- Person Form -->
			                   <fieldset class="form">
									<g:render template="form"/>
								</fieldset>
			                </div>
			            </div>
			            <div class="section">
			                <div id="addressForm">
			                	<fieldset class="form">
									<g:render template="/address/form"/>
								</fieldset>
			                </div>
			            </div>
			        </div>
			    </div>
			    --%>
			    <fieldset class="form">
					<g:render template="tabbedForm"/>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
