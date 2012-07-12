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

			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
			<br /> <br /> <br />
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
				<g:each in="${prodGemstoneInstanceList}" status="i"
					var="productGemStoneInstance">
							<g:if test="${(i % 3) == 0}">
								<div class="row" style="width: 100%">
							</g:if>
							<!--
								padding-right: 25px; : add space between the products
							 -->
							<div class="threecol box-small"
								style="padding-right: 25px; border-right: 1px solid #D9DCDC;">
								<div id="content">
									<g:link action="viewDetails" id="${productGemStoneInstance.pdProductId}"
											class="product-box-link">
									<img
										class="product-img"
										alt="${productGemStoneInstance.pdProductName}"
										title="${productGemStoneInstance.pdProductName}"
										src="${resource(dir: '/images/uploads/product', file: productGemStoneInstance?.smallImage?.imageUrl)}" />
									</g:link>
									
									<!-- 
										Product Tags (GIFs for individual tags to be displayed)
										For e.g. NEW,FEATURED,SALE etc. 
									-->
									<div class="product-tag">
										<!-- Create CSS classes for each tag -->
										<span class="new">
											NEW
										</span>
									</div>

									<!-- Product Name and Description -->
									<div class='product-name'>
										<g:link action="viewDetails" id="${productGemStoneInstance.pdProductId}"
											class="product-box-link">
											${fieldValue(bean: productGemStoneInstance, field: "pdProductName")}
										</g:link>	
									</div>
									
									<div class='product-name'>
										<g:link action="viewDetails" id="${productGemStoneInstance.pdProductId}"
											class="product-box-link"> 
											${fieldValue(bean: productGemStoneInstance, field: "pdDescription")}
										</g:link>
									</div>
									
									<!-- Product Name and Description -->
									<div class='product-price'>
										${productGemStoneInstance.getProductPrice(new Date())}
									</div>
								</div>
							</div>
						<!--  -->
							<g:if test="${(i % 3) == 0}">
								</div>
							</g:if>
						<!--  -->	
				</g:each>
			</div>
			
			<div>
				<g:paginate total="${prodGemstoneInstanceTotal}" />
			</div>
		</div>
	</div>
</body>
</html>