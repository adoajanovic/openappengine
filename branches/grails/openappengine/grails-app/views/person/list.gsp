
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-person" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="partyId" title="${message(code: 'person.partyId.label', default: 'Party Id')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'person.birthDate.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'person.comments.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="birthDate" title="${message(code: 'person.deceasedDate.label', default: 'Birth Date')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'person.description.label', default: 'Status')}" />
					
						<g:sortableColumn property="externalId" title="${message(code: 'person.externalId.label', default: 'External Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personInstanceList}" status="i" var="personInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personInstance.partyId}">${fieldValue(bean: personInstance, field: "partyId")}</g:link></td>
					
						<td>${fieldValue(bean: personInstance, field: "firstName")}</td>
						
						<td>${fieldValue(bean: personInstance, field: "lastName")}</td>
					
						<td><g:formatDate date="${personInstance.birthDate}" /></td>
					
						<td>${fieldValue(bean: personInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "externalId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
