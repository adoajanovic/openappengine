<%@page import="com.openappengine.master.*"%>
<%@ page import="com.openappengine.model.party.Person" %>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'externalId', 'error')} ">
	<label for="externalId">
		<g:message code="person.externalId.label" default="External Id" />
	</label>
	<g:textField name="externalId" value="${personInstance?.externalId}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
	</label>
	<g:textField name="firstName" value="${personInstance?.firstName}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="person.middleName.label" default="Middle Name" />
	</label>
	<g:textField name="middleName" value="${personInstance?.middleName}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
	</label>
	<g:textField name="lastName" value="${personInstance?.lastName}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'gender', 'error')} ">
	<label for="gender">
		<g:message code="person.gender.label" default="Gender" />
	</label>
	<g:textField name="gender" value="${personInstance?.gender}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'birthDate', 'error')} ">
	<label for="birthDate">
		<g:message code="person.birthDate.label" default="Birth Date" />
	</label>
	<g:datePicker name="birthDate" precision="day" value="${personInstance?.birthDate}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="person.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${personInstance?.description}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'preferredCurrencyUom', 'error')} ">
	<label for="preferredCurrencyUom">
		<g:message code="person.preferredCurrencyUom.label" default="Preferred Currency Uom" />
	</label>
	<g:select name="preferredCurrencyUom" from="${Currency?.values()}"
		value="${personInstance?.preferredCurrencyUom}" optionKey="key" /> 
</div>
<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="person.status.label" default="Status" />
	</label>
	<g:select name="status" from="${PartyStatus?.values()}"
		value="${personInstance?.status}" optionKey="key" /> 
</div>