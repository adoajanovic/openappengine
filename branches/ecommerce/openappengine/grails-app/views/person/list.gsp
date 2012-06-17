
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<script>
			$(function() {
				$( "#slider-range-max" ).slider({
					range: true,
					min: 0,
					max: 500,
					values: [ 75, 300 ],
					slide: function( event, ui ) {
						$("#amount").val(ui.values[0] + " - " + ui.values[1]);
					}
				});
				$("#amount").val($( "#slider-range-max" ).slider( "values", 0 ) + " - " + $( "#slider-range-max" ).slider( "values", 1 ));
			});
		
			$(function() {
				$('#searchForm').submit(function() {
					$.ajax({
                        type : "POST",
                        url : '/openappengine/person/filter',
                        data : {firstName:$('#firstName').val()},
                        dataType : "json",
                        success: function(result) {
                        	$('#listing').html('');

                        	$.each(result, function(i, person) {
                               var d = '<tr>' 
                               		   + '<td>'  + person.partyId + '</td>'
		                               + '<td>' + person.firstName + '</td>'
		                               + '<td>' + person.lastName + '</td>'
		                               + '<td>' + person.externalId + '</td>'
		                               + '<td>' + person.partyType + '</td>'
		                               + '</tr>';
                               	
                        	   $(d).appendTo('#listing');
                        	});
	                    },
	                    error : function() {
                            alert("Sorry, The requested property could not be found.");
               			}
                	});
					return false;
				});
			});
			</script>
	</head>
	<body>
		<br/>
		
		<form id="searchForm">
			First Name: <input id="firstName" name="firstName" type="text" />
			<input id="searchButton" type="submit" value="search"/> <br/>
			
			<label for="amount">Range:</label>
			<input type="text" id="amount" style="border:0; color:#f6931f; font-weight:bold;" />
			<div id="slider-range-max" style="width:400px;"></div>
		</form>
		
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