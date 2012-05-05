
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
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.partyId}">
				<li class="fieldcontain">
					<span id="partyId-label" class="property-label"><g:message code="person.partyId.label" default="Party Id" /></span>
					
						<span class="property-value" aria-labelledby="partyId-label"><g:fieldValue bean="${personInstance}" field="partyId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.addresses}">
				<li class="fieldcontain">
					<span id="addresses-label" class="property-label"><g:message code="person.addresses.label" default="Addresses" /></span>
					
						<g:each in="${personInstance.addresses}" var="a">
						<span class="property-value" aria-labelledby="addresses-label"><g:link controller="address" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.birthDate}">
				<li class="fieldcontain">
					<span id="birthDate-label" class="property-label"><g:message code="person.birthDate.label" default="Birth Date" /></span>
					
						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate date="${personInstance?.birthDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="person.comments.label" default="Comments" /></span>
					
						<span class="property-value" aria-labelledby="comments-label"><g:fieldValue bean="${personInstance}" field="comments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.deceasedDate}">
				<li class="fieldcontain">
					<span id="deceasedDate-label" class="property-label"><g:message code="person.deceasedDate.label" default="Deceased Date" /></span>
					
						<span class="property-value" aria-labelledby="deceasedDate-label"><g:formatDate date="${personInstance?.deceasedDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="person.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${personInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.externalId}">
				<li class="fieldcontain">
					<span id="externalId-label" class="property-label"><g:message code="person.externalId.label" default="External Id" /></span>
					
						<span class="property-value" aria-labelledby="externalId-label"><g:fieldValue bean="${personInstance}" field="externalId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="person.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${personInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.gender}">
				<li class="fieldcontain">
					<span id="gender-label" class="property-label"><g:message code="person.gender.label" default="Gender" /></span>
					
						<span class="property-value" aria-labelledby="gender-label"><g:fieldValue bean="${personInstance}" field="gender"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="person.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${personInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.maritalStatus}">
				<li class="fieldcontain">
					<span id="maritalStatus-label" class="property-label"><g:message code="person.maritalStatus.label" default="Marital Status" /></span>
					
						<span class="property-value" aria-labelledby="maritalStatus-label"><g:fieldValue bean="${personInstance}" field="maritalStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="person.middleName.label" default="Middle Name" /></span>
					
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${personInstance}" field="middleName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.nickname}">
				<li class="fieldcontain">
					<span id="nickname-label" class="property-label"><g:message code="person.nickname.label" default="Nickname" /></span>
					
						<span class="property-value" aria-labelledby="nickname-label"><g:fieldValue bean="${personInstance}" field="nickname"/></span>
					
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
			
				<g:if test="${personInstance?.partyType}">
				<li class="fieldcontain">
					<span id="partyType-label" class="property-label"><g:message code="person.partyType.label" default="Party Type" /></span>
					
						<span class="property-value" aria-labelledby="partyType-label"><g:fieldValue bean="${personInstance}" field="partyType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.passportExpireDate}">
				<li class="fieldcontain">
					<span id="passportExpireDate-label" class="property-label"><g:message code="person.passportExpireDate.label" default="Passport Expire Date" /></span>
					
						<span class="property-value" aria-labelledby="passportExpireDate-label"><g:formatDate date="${personInstance?.passportExpireDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.passportNumber}">
				<li class="fieldcontain">
					<span id="passportNumber-label" class="property-label"><g:message code="person.passportNumber.label" default="Passport Number" /></span>
					
						<span class="property-value" aria-labelledby="passportNumber-label"><g:fieldValue bean="${personInstance}" field="passportNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.preferredCurrencyUom}">
				<li class="fieldcontain">
					<span id="preferredCurrencyUom-label" class="property-label"><g:message code="person.preferredCurrencyUom.label" default="Preferred Currency Uom" /></span>
					
						<span class="property-value" aria-labelledby="preferredCurrencyUom-label"><g:fieldValue bean="${personInstance}" field="preferredCurrencyUom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.salutation}">
				<li class="fieldcontain">
					<span id="salutation-label" class="property-label"><g:message code="person.salutation.label" default="Salutation" /></span>
					
						<span class="property-value" aria-labelledby="salutation-label"><g:fieldValue bean="${personInstance}" field="salutation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.socialSecurityNumber}">
				<li class="fieldcontain">
					<span id="socialSecurityNumber-label" class="property-label"><g:message code="person.socialSecurityNumber.label" default="Social Security Number" /></span>
					
						<span class="property-value" aria-labelledby="socialSecurityNumber-label"><g:fieldValue bean="${personInstance}" field="socialSecurityNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="person.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${personInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.suffix}">
				<li class="fieldcontain">
					<span id="suffix-label" class="property-label"><g:message code="person.suffix.label" default="Suffix" /></span>
					
						<span class="property-value" aria-labelledby="suffix-label"><g:fieldValue bean="${personInstance}" field="suffix"/></span>
					
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
