
<%@ page import="com.openappengine.model.party.Party" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'party.label', default: 'Party')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-party" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-party" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="partyId" title="${message(code: 'party.partyId.label', default: 'Party Id')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'party.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="externalId" title="${message(code: 'party.externalId.label', default: 'External Id')}" />
					
						<g:sortableColumn property="partyType" title="${message(code: 'party.partyType.label', default: 'Party Type')}" />
					
						<g:sortableColumn property="preferredCurrencyUom" title="${message(code: 'party.preferredCurrencyUom.label', default: 'Preferred Currency Uom')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'party.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${partyInstanceList}" status="i" var="partyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${partyInstance.id}">${fieldValue(bean: partyInstance, field: "partyId")}</g:link></td>
					
						<td>${fieldValue(bean: partyInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: partyInstance, field: "externalId")}</td>
					
						<td>${fieldValue(bean: partyInstance, field: "partyType")}</td>
					
						<td>${fieldValue(bean: partyInstance, field: "preferredCurrencyUom")}</td>
					
						<td>${fieldValue(bean: partyInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${partyInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
