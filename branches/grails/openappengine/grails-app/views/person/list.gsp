
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<script type="text/javascript">
	        $(document).ready(function () {
	            var theme = getTheme();
	
	            var url="${createLink(action: 'listJSON')}";
	
	            // prepare the data
	            var source =
	            {
	                datatype: "json",
	                datafields: [
	                    { name: 'firstName' },
	                    { name: 'lastName' },
	                    { name: 'externalId'},
	                    { name: 'status' },
	                ],
	                id: 'partyId',
	                url: url
	            };
	            var dataAdapter = new $.jqx.dataAdapter(source);

	            var linkrenderer = function (row, column, value) {
	                value = <a href="/openappengine/person/show/">value</a>
	                var format = { target: "_self" };
	                var html = $.jqx.dataFormat.formatlink(value, format);
	                return html;
	            }

	            var cellsrenderer = function (row, columnfield, value, defaulthtml, columnproperties) {
	               	return '<a href="show?id=' + value + '">' + value + '</a>';
	            }
	
	            $("#jqxgrid").jqxGrid(
	            {
	                source: dataAdapter,
	                theme: theme,
	                columnsresize: true,
	                sortable:true,
	                columns: [
	                  { text: 'First Name', datafield: 'firstName', width: 250 },
	                  { text: 'Last Name', datafield: 'lastName', width: 250 },
	                  { text: 'External Id', datafield: 'externalId', width: 180 ,cellsrenderer: cellsrenderer},
	                  { text: 'Status', datafield: 'status', width: 120 }
	              ]
	            });
	        });
	    </script>
	</head>
	<body>
		<h1><g:message code="default.list.label" args="[entityName]" /></h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		
		<br/>
		<div id='jqxWidget' style="ui-widget">
	        <div id="jqxgrid"></div>
	    </div>
</body>
</html>
