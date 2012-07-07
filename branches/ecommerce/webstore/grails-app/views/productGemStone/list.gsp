
<%@ page import="com.openappengine.product.ProductGemStone" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productGemStone.label', default: 'ProductGemStone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productGemStone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productGemStone" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="carat" title="${message(code: 'productGemStone.carat.label', default: 'Carat')}" />
					
						<g:sortableColumn property="clarity" title="${message(code: 'productGemStone.clarity.label', default: 'Clarity')}" />
					
						<g:sortableColumn property="color" title="${message(code: 'productGemStone.color.label', default: 'Color')}" />
					
						<g:sortableColumn property="cut" title="${message(code: 'productGemStone.cut.label', default: 'Cut')}" />
					
						<g:sortableColumn property="grade" title="${message(code: 'productGemStone.grade.label', default: 'Grade')}" />
					
						<g:sortableColumn property="hardness" title="${message(code: 'productGemStone.hardness.label', default: 'Hardness')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productGemStoneInstanceList}" status="i" var="productGemStoneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productGemStoneInstance.id}">${fieldValue(bean: productGemStoneInstance, field: "carat")}</g:link></td>
					
						<td>${fieldValue(bean: productGemStoneInstance, field: "clarity")}</td>
					
						<td>${fieldValue(bean: productGemStoneInstance, field: "color")}</td>
					
						<td>${fieldValue(bean: productGemStoneInstance, field: "cut")}</td>
					
						<td>${fieldValue(bean: productGemStoneInstance, field: "grade")}</td>
					
						<td>${fieldValue(bean: productGemStoneInstance, field: "hardness")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productGemStoneInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
