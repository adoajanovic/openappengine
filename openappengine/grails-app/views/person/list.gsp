
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title>
			<g:message code="party.list.title" default="Party Manager"/>
		</title>
	</head>
	<body>
		<div>
			<h2>
				Person Search
			</h2>
			<g:formRemote name="searchForm" on404="alert('not found!')" update="list-person"
	              url="[action:'filter']">
	            <table style="width:25%;">
	            	<tr>
	            		<td>
	            			First Name:
	            		</td>
	            		<td>
	            			<input id="firstName" name="firstName" type="text" />			
	            		</td>
	            	</tr>
	            	<tr>
	            		<td>
	            			Last Name:
	            		</td>
	            		<td>
	            			<input id="lastName" name="lastName" type="text" />			
	            		</td>
	            	</tr>
	            	<tr>
	            		<th colspan="2">
	            			<input type="submit" value="Search" />			
	            		</th>
	            	</tr>
	            </table>  
				 
				
			</g:formRemote>
		</div>
		
		<br />
		
		<div id="list-person" class="content scaffold-list" role="main">
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="partyId" title="${message(code: 'person.partyId.label', default: 'Party Id')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'person.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'person.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="externalId" title="${message(code: 'person.externalId.label', default: 'External Id')}" />
					
						<g:sortableColumn property="partyType" title="${message(code: 'person.partyType.label', default: 'Party Type')}" />
					
					</tr>
				</thead>
				<tbody id="listing">
				<g:each in="${personInstanceList}" status="i" var="personInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personInstance.partyId}">${fieldValue(bean: personInstance, field: "partyId")}</g:link></td>
					
						<td>${fieldValue(bean: personInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "externalId")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "partyType")}</td>
					
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