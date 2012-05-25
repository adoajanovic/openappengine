<%@ page import="com.openappengine.model.contract.Contract" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contract.label', default: 'Contract')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="create-contract" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${contractInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${contractInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="buttons">
					<button id="addLineItemBtn">
						<img src="${resource(dir: 'images', file: 'add_item.png')}" alt="Add Line Item"/>
						Add Line Item
					</button>
				</fieldset>
				<fieldset class="form">
					<g:render template="form"/>
					
					<div id="childList">
						<table>
							<thead>
								<tr>
									<th>Line Item</th>
									<th>Quantity</th>
									<th>From Date</th>
									<th>To Date</th>
								</tr>
							</thead>
							<tbody>
								<g:each var="lineItem" in="${contractInstance.lineItems}" status="i">
									<tr id="row0">
							        	<td>
	    									<g:textField name='lineItem[${i}].itemDescription' value='${lineItem.itemDescription}'/>
							        	</td>
							        	<td>
	    									<g:textField name='lineItem[${i}].quantity' value='${lineItem.quantity}'/>
							        	</td>
							        	<td>
	    									<g:textField name='lineItem[${i}].fromDate' value='${lineItem.fromDate}'/>
							        	</td>
							        	<td>
	    									<g:textField name='lineItem[${i}].toDate' value='${lineItem.toDate}'/>
							        	</td>
									</tr>
							    </g:each>
							</tbody>
						</table>
					</div>
				</fieldset>
				
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
				
			</g:form>
		</div>
	</body>
</html>
