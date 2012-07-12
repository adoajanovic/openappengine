<div id="product-list" class="ajax">
	<g:each in="${prodGemstoneInstanceList}" status="i"
		var="productGemStoneInstance">
		<div class="row" style="width: 100%">
			<!--
			padding-right: 25px; : add space between the products
		-->
			<div class="threecol box-small"
				style="padding-right: 25px; border-right: 1px solid #D9DCDC;">
				<div id="content">
					<g:link action="viewDetails"
						id="${productGemStoneInstance.pdProductId}"
						class="product-box-link">
						<img class="product-img"
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
						<span class="new"> NEW </span>
					</div>

					<!-- Product Name and Description -->
					<div class='product-name'>
						<g:link action="viewDetails"
							id="${productGemStoneInstance.pdProductId}"
							class="product-box-link">
							${fieldValue(bean: productGemStoneInstance, field: "pdProductName")}
						</g:link>
					</div>

					<div class='product-name'>
						<g:link action="viewDetails"
							id="${productGemStoneInstance.pdProductId}"
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
		</div>
		<!--  -->
	</g:each>

	<div class="pager">
		<g:paginate total="${prodGemstoneInstanceTotal}" />
	</div>
</div>
