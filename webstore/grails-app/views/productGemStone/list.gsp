
<%@ page import="com.openappengine.product.ProductGemStone"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<title>Gemstone</title>
</head>
<body>

	<div class="row clearfix shadow" style="margin-top: 3.8em;">
		<!--
			TODO : Change inline style to css (class : productCategoryHeader) 
		 -->
		<div class="left sixcol">
			<h1 class="list_header">
				Featured Gemstones
			</h1>
		</div>
	</div>

	<hr />

	<div id="list-productGemStone" class="content scaffold-list"
		role="main">
		<g:each in="${productGemStoneInstanceList}" status="i"
			var="productGemStoneInstance">
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
									<li><g:link action="show"
											id="${productGemStoneInstance.id}">
											${fieldValue(bean: productGemStoneInstance, field: "pdProductName")}
										</g:link>
										</td>
									<li>Grade : <a href="#"> ${fieldValue(bean: productGemStoneInstance, field: "grade")}
									</a></li>
									<li><g:actionSubmit class="save" action="AddtoCart"
											value="Add to Cart" /></li>
									<li>
										${productGemStoneInstance.prodProductPrices.ppPrice}
									</li>
								</ul>
							</div>
							<div class="right">
								<img
									src="${resource(dir: 'images/site/home', file: productGemStoneInstance.thumbImg )}"
									style="width: 180px; height: 120px; padding: 5px; margin-top: 25px; display: block;" />
							</div>
						</div>
					</div>
				</div>
		</g:each>
		<div class="pagination">
			<g:paginate total="${productGemStoneInstanceTotal}" />
		</div>
	</div>
</body>
</html>
