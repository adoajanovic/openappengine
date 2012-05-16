
<%@ page import="com.openappengine.model.party.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<script type="text/javascript">
	        $(document).ready(function() {
                         <jqgrid:grid
                                id="person"
                                url="'${createLink(action: 'listJSON')}'"
                                editurl="'${createLink(action: 'editJSON')}'"
                                colNames="'First Name','Last Name','External Id', 'Status', 'Description'"
                                colModel="
                                		  {name:'firstName', editable: false},
                                		  {name:'lastName', editable: false},
                                		  {name:'externalId', editable: false},
                                          {name:'status', editable: true},
                                          {name:'description', editable: true}"
                                sortname="'externalId'"
                                caption="'Party List'"
                                height="300"
                                autowidth="true"
                                scrollOffset="0"
                                viewrecords="true"
                                showPager="true"
                                datatype="'json'">
                                <jqgrid:navigation id="partyStandard" add="true" edit="true" 
                                      del="true" search="true" refresh="true" />
                         </jqgrid:grid>
               });
               
               $(document).ready(function() {
					var objRows = $("#list_accounts tr"); 
					var objHeader = $("#list_accounts .jqgfirstrow td"); 
					if (objRows.length > 1) { 
						var objFirstRowColumns = $(objRows[1]).children("td"); 
						for (i = 0; i < objFirstRowColumns.length; i++) { 
							$(objFirstRowColumns[i]).css("width", $(objHeader[i]).css("width"));
						 } 
					} 	               
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
		<div id="list-person" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<!-- jqgrid -->
			<jqgrid:wrapper id="person" />
		</div>
	</body>
</html>
