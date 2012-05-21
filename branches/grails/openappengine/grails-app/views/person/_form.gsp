<%@page import="com.openappengine.master.*"%>
<%@ page import="com.openappengine.model.party.Person"%>

    <script type="text/javascript">
        $(document).ready(function () {
            var theme = getTheme();
            // Create jqxTabs.
            $('#jqxTabs').jqxTabs({ width: 580, height: 370, position: 'top', theme: theme });
            $('#animation').bind('change', function (event) {
                var checked = event.args.checked;
                $('#jqxTabs').jqxTabs({ selectionTracker: checked });
            });
        });
    </script>
    
    <script type="text/javascript">
	        $(document).ready(function () {
	            var theme = getTheme();
	            $('#sendButton').jqxButton({ width: 60, height: 25, theme: theme });

	            $('#sendButton').bind('click', function () {
	                $('#testForm').jqxValidator('validate');
	            });

	            // initialize validator.
	            $('#testForm').jqxValidator({
	             rules: [
	                    { input: '#userInput', message: 'Username is required!', action: 'keyup, blur', rule: 'required' },
	                    { input: '#userInput', message: 'Your username must be between 3 and 12 characters!', action: 'keyup', rule: 'length=3,12' },
	                    { input: '#realNameInput', message: 'Your real name must contain only letters!', action: 'keyup', rule: 'notNumber' },
	                    { input: '#realNameInput', message: 'Your real name must be between 3 and 12 characters!', action: 'keyup', rule: 'length=3,12' },
	                    { input: '#birthInput', message: 'Your birth date must be between 1/1/1900 and 1/1/2012.', action: 'valuechanged', rule: function () {
	                        var date = $('#birthInput').jqxDateTimeInput('value');
	                        var result = date.dateTime.getFullYear() >= 1900 && date.dateTime.getFullYear() <= 2012;
	                        return result;
	                    }
	                    },
	                    { input: '#passwordInput', message: 'Password is required!', action: 'keyup', rule: 'required' },
	                    { input: '#passwordInput', message: 'Your password must be between 4 and 12 characters!', action: 'keyup', rule: 'length=4,12' },
	                    { input: '#passwordConfirmInput', message: 'Password is required!', action: 'keyup', rule: 'required' },
	                    { input: '#passwordConfirmInput', message: 'Passwords doesn\'t match!', action: 'keyup, focus', rule: function (input) {
	                        if (input.val() === $('#passwordInput').val()) {
	                            return true;
	                        }
	                        return false;
	                    }
	                    },
	                    { input: '#emailInput', message: 'E-mail is required!', action: 'keyup', rule: 'required' },
	                    { input: '#emailInput', message: 'Invalid e-mail!', action: 'keyup', rule: 'email' },
	                    { input: '#ssnInput', message: 'Invalid SSN!', action: 'valuechanged, blur', rule: 'ssn' },
	                    { input: '#phoneInput', message: 'Invalid phone number!', action: 'valuechanged, blur', rule: 'phone' },
	                    { input: '#zipInput', message: 'Invalid zip code!', action: 'valuechanged, blur', rule: 'zipCode' },
	                    { input: '#acceptInput', message: 'You have to accept the terms', action: 'change', rule: 'required', position: 'right:0,0'}], theme: theme
	            });
	        });
	    </script>
<br/>

<%--<div>
	<g:remoteLink controller="person" action="createAddress" onSuccess="showAddress();">
		<img src="${resource(dir: 'images', file: 'address.png')}" alt="Add Address"/>
		Add Address
	</g:remoteLink>
</div>
--%>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'externalId', 'error')} ">
	<label for="externalId"> <g:message
			code="person.externalId.label" default="External Id" />
	</label>
	<g:textField class="ui-widget" name="externalId"
		value="${personInstance?.externalId}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} ">
	<label for="firstName"> <g:message
			code="person.firstName.label" default="First Name" />
	</label>
	<g:textField name="firstName" value="${personInstance?.firstName}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'middleName', 'error')} ">
	<label for="middleName"> <g:message
			code="person.middleName.label" default="Middle Name" />
	</label>
	<g:textField name="middleName" value="${personInstance?.middleName}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} ">
	<label for="lastName"> <g:message code="person.lastName.label"
			default="Last Name" />
	</label>
	<g:textField name="lastName" value="${personInstance?.lastName}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'gender', 'error')} ">
	<label for="gender"> <g:message code="person.gender.label"
			default="Gender" />
	</label>
	<g:textField name="gender" value="${personInstance?.gender}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'birthDate', 'error')} ">
	<label for="birthDate"> <g:message
			code="person.birthDate.label" default="Birth Date" />
	</label>
	<g:datePicker name="birthDate" precision="day"
		value="${personInstance?.birthDate}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'description', 'error')} ">
	<label for="description"> <g:message
			code="person.description.label" default="Description" />

	</label>
	<g:textField name="description" value="${personInstance?.description}" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'preferredCurrencyUom', 'error')} ">
	<label for="preferredCurrencyUom"> <g:message
			code="person.preferredCurrencyUom.label"
			default="Preferred Currency Uom" />
	</label>
	<g:select name="preferredCurrencyUom" from="${Currency?.values()}"
		value="${personInstance?.preferredCurrencyUom}" optionKey="key" />
</div>
<div
	class="fieldcontain ${hasErrors(bean: personInstance, field: 'status', 'error')} ">
	<label for="status"> <g:message code="person.status.label"
			default="Status" />
	</label>
	<g:select name="status" from="${PartyStatus?.values()}"
		value="${personInstance?.status}" optionKey="key" />
</div>