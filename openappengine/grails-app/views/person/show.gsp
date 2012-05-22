
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.firstName}">
					<li class="fieldcontain">
						<span id="firstName-label" class="property-label"><g:message code="person.firstName.label" default="First Name" /></span>
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${personInstance}" field="firstName"/></span>
					</li>
				</g:if>
				
				<g:if test="${personInstance?.middleName}">
					<li class="fieldcontain">
						<span id="middleName-label" class="property-label"><g:message code="person.middleName.label" default="Middle Name" /></span>
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${personInstance}" field="middleName"/></span>
					</li>
				</g:if>
				
				<g:if test="${personInstance?.lastName}">
					<li class="fieldcontain">
						<span id="lastName-label" class="property-label"><g:message code="person.lastName.label" default="Last Name" /></span>
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${personInstance}" field="lastName"/></span>
					</li>
				</g:if>
				
				<g:if test="${personInstance?.birthDate}">
					<li class="fieldcontain">
						<span id="birthDate-label" class="property-label"><g:message code="person.birthDate.label" default="Birth Date" /></span>
						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate date="${personInstance?.birthDate}" /></span>
					</li>
				</g:if>
			
				<g:if test="${personInstance?.gender}">
					<li class="fieldcontain">
						<span id="gender-label" class="property-label"><g:message code="person.gender.label" default="Gender" /></span>
						<span class="property-value" aria-labelledby="gender-label"><g:fieldValue bean="${personInstance}" field="gender"/></span>
					</li>
				</g:if>
				
				<g:if test="${personInstance?.description}">
					<li class="fieldcontain">
						<span id="description-label" class="property-label"><g:message code="person.description.label" default="Description" /></span>
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${personInstance}" field="description"/></span>
					</li>
				</g:if>
			
				<g:if test="${personInstance?.partyContactMechs}">
				<li class="fieldcontain">
						<span id="partyContactMechs-label" class="property-label"><g:message code="person.partyContactMechs.label" default="Party Contact Mechs" /></span>
					
						<g:each in="${personInstance.partyContactMechs}" var="p">
						<span class="property-value" aria-labelledby="partyContactMechs-label"><g:link controller="partyContactMech" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.addresses}">
				<li class="fieldcontain">
					<%--<span id="addresses-label" class="property-label">
						<g:message code="person.addresses.label" default="Addresses" />
					</span>
						--%>
						<table style="width:50%;">
							<thead>
								<tr>
									<th>Address</th>
									<th />
								</tr>
							</thead>
							<tbody>
							<g:each in="${personInstance.addresses}" var="a">
									<tr>
										<td>
											${a?.address1}, ${a?.address2}, <br /> 
													${a?.city}, ${a?.postalCode}
													${a?.stateProvince}, <br /> 
													${a?.country} <br />
										</td>
										<td>
											<g:link controller="address" action="show" id="${a.addressBookId}">
												<img src="${resource(dir: 'images', file: 'view_detail.png')}" alt="View"/>
											</g:link>
										</td>
									</tr>
							</g:each>
							</tbody>
						</table>
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personInstance?.partyId}" />
					<g:link class="edit" action="edit" id="${personInstance?.partyId}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
