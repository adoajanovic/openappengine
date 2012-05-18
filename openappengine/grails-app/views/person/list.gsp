
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<script>
			var jsonResult;
			$.ajax({
				dataType: "json",
				url:"${createLink(action: 'listJSON')}",
				async: false,
				success: function( result ) {
					jsonResult = result;
				}
			});
		
			$(function() {
				var developers = $.ui.dataviewlocal({
					input: jsonResult,
					paging: {
						limit: 3
					}
				});
		
				$("#list-person").grid({
					heightStyle: "fill",
					source: developers.result,
					select: function( event, ui ) {
						console.log( "Selected " + ui.item.firstName );
					}
				});
		
				$("#pager").pager({
					source: developers
				});
		
				developers.refresh();
			});
		 </script>
	</head>
	<body>
		<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div style="width: 65%;">
			<table id="list-person">
				<thead>
					<tr>
						<th data-property="firstName">First Name</th>
						<th data-property="lastName">Last Name</th>
						<th data-property="externalId">External Id</th>
						<th data-property="status">Status</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<p id="pager">
				<button data-page="first">First</button>
				<button data-page="prev">Prev</button>
				<button data-page="prevStep">-1</button>
				<span> Page <input class="current" size="4" />/<span
					class="total">0</span>, Total records <span class="totalRecords">0</span>
				</span>
				<button data-page="nextStep">+1</button>
				<button data-page="next">Next</button>
				<button data-page="last">Last</button>
			</p>
		</div>
</body>
</html>
