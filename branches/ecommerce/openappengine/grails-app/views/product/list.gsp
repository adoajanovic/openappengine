
<%@ page import="com.openappengine.model.product.Product" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<script src="${resource(dir: 'js', file: 'jquery.betterTooltip.js')}"></script>
			<script>
			//Ajax Search Function
			var ajaxFilter = function() {
				var $divListing = $('#productTable');
                var $divOverlay = $('#overlay');

				var rowPos = $divListing.position();
				bottomTop = rowPos.top;
				bottomLeft = rowPos.left;
				
				//
				$divOverlay.css({
				    position: 'absolute',
				    top: bottomTop,
				    left: bottomLeft,
				    width: bottomWidth,
				    height: bottomHeight
				});
				
                var bottomTop = $divListing.attr('offsetTop');
                var bottomLeft = $divListing.attr('offsetLeft');
                var bottomWidth = $divListing.css('width');
                var bottomHeight = $divListing.css('height');
                $divOverlay.css('top', bottomTop);
                $divOverlay.css('left', bottomLeft);
                $divOverlay.css('width', bottomWidth);
                $divOverlay.css('height', bottomHeight);
				
				$.ajax({
					beforeSend: function() {
						$("#overlay").fadeIn(1000);
					},
					complete: function(){
						$("#overlay").fadeOut(1000);
					},				
	                type : "POST",
	                url : '/openappengine/product/filterProducts',
	                data : {
	                			productName:$('#productName').val(),
	                			priceMin:$("#slider-range-max").slider("values", 0 ),
	                			priceMax:$( "#slider-range-max" ).slider("values",1) 
	                       },
	                dataType : "json",
	                success: function(result) {
	                	$("#productTableData").html("");
		                $.each(result, function(i, product) {
	                       var d = '<tr>' 
	                           		   + '<td>'  + product.pdProductId + '</td>'
		                               + '<td>' + product.pdProductName + '</td>'
		                               + '<td>' + product.pdIntroductionDate + '</td>'
		                               + '<td>' + product.pdSalesDiscontinuationDate + '</td>'
		                               + '<td>' + product.pdPrice + '</td>'  
		                               + '<td>'
		   							   + '<a class="toolTipTrigger" rel=' + product.pdProductId + ' href="#">'
		   							   + 'View Details'
		   							   + '</a'
		   							   + '</td>'
	                               + '</tr>';
	                       	
	                	   $(d).appendTo('#productTableData');
	                	});
	                },
	                error : function() {
	                    //alert("Sorry, The requested property could not be found.");
	       			}
	        	});
			}
			//End 
			
			$(function() {
				$( "#format" ).buttonset();
				
				$( "#slider-range-max" ).slider({
					range: true,
					min: 0,
					max: 500,
					values: [ 75, 300 ],
					slide: function( event, ui ) {
						$("#priceMin").val(ui.values[0]);
						$("#priceMax").val(ui.values[1]);
					},
					stop: function(event, ui) {
						ajaxFilter(); 
					}
				});
				$("#priceMin").val($("#slider-range-max").slider("values", 0))
				$("#priceMax").val($("#slider-range-max").slider("values", 1));
			});
		
			$(function() {
				$('#searchForm').submit(function() {
					ajaxFilter();
					return false;
				});
			});
		</script>
	</head>
	<body>
		<script id="productDetailTooltipTemplate" type="text/x-jQuery-tmpl">
			<table>
        		  	<tr><td>Name: </td><td> ${pdProductName} </td></tr>
                  	<tr><td>Introduction Date: </td><td> ${pdIntroductionDate} </td></tr>
                  	<tr><td>Discontinuation Date:</td><td> ${pdSalesDiscontinuationDate}  </td></tr>
                 	<tr><td>Price : </td><td> ${pdPrice} </td></tr>
            </table>   
		</script>
		<br/>
		
		<form id="searchForm">
			<label for="name">Name:</label>
			<input id="productName" name="productName" type="text" /> <br/>
			
			<label for="amount">Price Range:</label>
			<div id="slider-range-max" style="width:400px;"></div> <br/>
			<input type="text" id="priceMin" style="border:0; color:#f6931f; font-weight:bold;" maxlength="5" />
			-
			<input type="text" id="priceMax" style="border:0; color:#f6931f; font-weight:bold;" maxlength="5"/>
			
			<div id="format">
				<input type="checkbox" id="roundShape" />
				<label for="roundShape">
					<img id="overlay-img" src="${resource(dir: 'images/diamond/shapes_small', file: 'round.jpg')}" alt="Round" 
							width="35" height="40"/>
				</label>
				
				<input type="checkbox" id="princessShape" />
				<label for="princessShape">
				<img for="princessShape" id="overlay-img" src="${resource(dir: 'images/diamond/shapes_small', file: 'princess.jpg')}" alt="Princess" 
						width="40" height="40"/>
				</label>
				
				<input type="checkbox" id="emeraldShape" />
				<label for="emeraldShape">
				<img id="overlay-img" src="${resource(dir: 'images/diamond/shapes_small', file: 'emerald.jpg')}" alt="Emerald" 
						width="40" height="40"/>
				</label>		
			</div> <br/>
			
			<input id="searchButton" type="submit" value="search"/> <br/>
		</form>
		
		<div id="overlay">
				<div class="loaderMsgDiv" style="border:1;color:#f6931f; font-weight:bold;color:#f6931f;height:50px;width:150px;z-index: 20;">
					 <img id="overlay-img" src="${resource(dir: 'images', file: 'ajax-loader.gif')}" alt="loading" width="100px;"/>
					 <b>Loading...</b> 
				</div>
		</div>
		<br/>
		
		<div id="list-product" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table id="productTable">
				<thead id="productTableHeader">
					<tr>
						<g:sortableColumn property="pdProductId" title="${message(code: 'product.pdProductId.label', default: 'Product Id')}" />
						
						<g:sortableColumn property="pdProductName" title="${message(code: 'product.pdProductName.label', default: 'Product Name')}" />
					
						<g:sortableColumn property="pdIntroductionDate" title="${message(code: 'product.pdIntroductionDate.label', default: 'Introduction Date')}" />
						
						<g:sortableColumn property="pdSalesDiscontinuationDate" title="${message(code: 'product.pdSalesDiscontinuationDate.label', default: 'Discontinuation Date')}" />
					
						<g:sortableColumn property="pdFixedAmount" title="${message(code: 'product.pdFixedAmount.label', default: 'Amount')}" />
						
						<th></th>
					</tr>
				</thead>
				<tbody id="productTableData">
				<g:each in="${productInstanceList}" status="i" var="productInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
							<g:link class="toolTipTrigger" rel="${productInstance.pdProductId}" action="show" id="${productInstance.pdProductId}">
								${fieldValue(bean: productInstance, field: "pdProductId")}
							</g:link>
						</td>
					
						<td>${fieldValue(bean: productInstance, field: "pdProductName")}</td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${productInstance.pdIntroductionDate}" /></td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${productInstance.pdSalesDiscontinuationDate}" /></td>
					
						<td>
							<g:formatNumber number="${pdFixedAmount}" type="number" maxFractionDigits="2" />
						</td>
						
						<td>
							<g:link class="toolTipTrigger" rel="${productInstance.pdProductId}" action="show" id="${productInstance.pdProductId}">
								View Details
							</g:link>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productInstanceTotal}" />
			</div>
			
		</div>
	</body>
</html>
