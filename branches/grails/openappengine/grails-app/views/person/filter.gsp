<div id="list-person" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="partyId" title="${message(code: 'person.partyId.label', default: 'Party Id')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'person.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'person.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'person.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="externalId" title="${message(code: 'person.externalId.label', default: 'External Id')}" />
					
						<g:sortableColumn property="partyType" title="${message(code: 'person.partyType.label', default: 'Party Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personInstanceList}" status="i" var="personInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personInstance.partyId}">${fieldValue(bean: personInstance, field: "partyId")}</g:link></td>
					
						<td>${fieldValue(bean: personInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "externalId")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "partyType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personInstanceTotal}" />
			</div>