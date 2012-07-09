
<%@ page import="com.openappengine.product.ProductGemStone"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<title>Gemstone</title>
</head>
<body>
	<div class="row">
		<div class="left threecol product-filter">
			<div class="row clearfix">
				<h1 class="filter-heading">Narrow Results</h1>
			</div>
			
			<hr />
			
			<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
			<br /> <br /> <br /> <br /><br /> <br /> 
		</div>

		<!--
			margin-left: -2.5em; : Provides more space in the list area 
		 -->
		<div class="right product-list-wrapper" style="margin-left: -2.5em;">
			<div class="row clearfix">
				<h1 class="promo-area">Featured Gemstones</h1>
			</div>

			<hr />

			<div id="product-list">
				<g:each in="${productGemStoneInstanceList}" status="i"
					var="productGemStoneInstance">
					<div class="${(i % 3) == 0 ? '' : ''}">
						<div class="row" style="width:100%">
							<!--
								padding-right: 25px; : add space between the products
							 -->
							<div class="threecol box-small" style="padding-right: 25px;">
								<div id="content">
									<img class="product-img"
										src="${resource(dir: 'images/site/home', file: productGemStoneInstance.thumbImg )}" />
									<!-- Product Name and Description -->
									<div class='product-name'>
										${fieldValue(bean: productGemStoneInstance, field: "pdDescription")}
									</div>
									<div>
										<ul class="ullist">
											<li>Grade : <a href="#"> ${fieldValue(bean: productGemStoneInstance, field: "grade")}
											</a>
											</li>
											<li>
												${productGemStoneInstance.prodProductPrices.ppPrice}
											</li>
										</ul>
									</div>
									<div class="add-to-cart">
										<g:actionSubmit class="save" action="AddtoCart"
											value="Add to Cart" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</g:each>
				<div class="pagination">
					<g:paginate total="${productGemStoneInstanceTotal}" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>