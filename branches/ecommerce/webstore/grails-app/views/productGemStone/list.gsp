
<%@ page import="com.openappengine.product.ProductGemStone" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productGemStone.label', default: 'ProductGemStone')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
	<div id="top-bar">
			<div id="top-bar-content">
				
			</div>
		</div>
		
		<div class="clearfix shadow"
			style="padding-top: 5px; margin-top: 10px;">
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
				<!--  thead>
					<tr>
					
						<g:sortableColumn property="carat" title="${message(code: 'productGemStone.carat.label', default: 'Carat')}" />
					
						<g:sortableColumn property="clarity" title="${message(code: 'productGemStone.clarity.label', default: 'Clarity')}" />
					
						<g:sortableColumn property="color" title="${message(code: 'productGemStone.color.label', default: 'Color')}" />
					
						<g:sortableColumn property="cut" title="${message(code: 'productGemStone.cut.label', default: 'Cut')}" />
					
						<g:sortableColumn property="grade" title="${message(code: 'productGemStone.grade.label', default: 'Grade')}" />
					
						<g:sortableColumn property="hardness" title="${message(code: 'productGemStone.hardness.label', default: 'Hardness')}" />
					
					</tr>
				</thead-->
				<tbody>
			
				<g:each in="${productGemStoneInstanceList}" status="i" var="productGemStoneInstance">
					<div class="${(i % 3) == 0 ? 'even' : 'odd'}">
					<div class="row">
					<div class="fourcol box-small">
						<!-- title -->
						<h2 class="title">
							${fieldValue(bean: productGemStoneInstance, field: "pdDescription")}
						</h2>
						<div id="content">
							<div class="left" style="max-width: 200px;">
								<ul class="ullist">
									<li>
										<g:link action="show" id="${productGemStoneInstance.id}">${fieldValue(bean: productGemStoneInstance, field: "pdProductName")}</g:link></td>
									<li>
										Grade : <a href="#">${fieldValue(bean: productGemStoneInstance, field: "grade")}</a></li>
									<li><g:actionSubmit class="save" action="AddtoCart" value="Add to Cart" /></li>	
									<li>${productGemStoneInstance.prodProductPrices.ppPrice}</li>
								</ul>
							</div>
							<div class="right">
								<img
									src="${resource(dir: 'images/site/home', file: 'gem-stones.jpg')}"
									style="width: 180px; height: 120px; padding: 5px; margin-top: 25px; display: block;" />
							</div>
						</div>
					</div>
					
					<!-- 
						${fieldValue(bean: productGemStoneInstance, field: "clarity")}
					
						${fieldValue(bean: productGemStoneInstance, field: "color")}
					
						${fieldValue(bean: productGemStoneInstance, field: "cut")}
					
						${fieldValue(bean: productGemStoneInstance, field: "grade")}
					
						${fieldValue(bean: productGemStoneInstance, field: "hardness")}
					-->
				  </div>
				</g:each>
				
				</tbody>
			
			</table>
			<div class="pagination">
				<g:paginate total="${productGemStoneInstanceTotal}" />
			</div>
		</div>
		</div>
	</body>
</html>
