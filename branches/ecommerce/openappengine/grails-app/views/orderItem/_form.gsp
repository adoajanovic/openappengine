<%@ page import="com.openappengine.model.fm.OiOrderItem" %>

<div class="fieldcontain ${hasErrors(bean: oiOrderItemInstance, field: 'product', 'error')} ">
	<label for="product">
		<g:message code="contractLineItem.product.label" default="Product" />
	</label>
	<g:select id="pdProductId" name="product.pdProductId" from="${com.openappengine.model.product.Product.list()}" noSelection="['':'']"
			optionKey="pdProductId" optionValue="pdProductName" required="true" value="${oiOrderItemInstance?.product?.pdProductId}"
			onchange="${remoteFunction(controller:'product',action:'ajaxGetProductPrice',params:'\'id=\' + escape(this.value)', 
            			onSuccess:'$("input#unitPrice").val(data);')}" 
			class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: oiOrderItemInstance, field: 'quantity', 'error')} ">
	<label for="quantity">
		<g:message code="oiOrderItem.quantity.label" default="Quantity" />
		
	</label>
	<g:field type="number" name="quantity" value="${fieldValue(bean: oiOrderItemInstance, field: 'quantity')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: oiOrderItemInstance, field: 'unitPrice', 'error')} ">
	<label for="unitPrice">
		<g:message code="oiOrderItem.unitPrice.label" default="Unit Price" />
		
	</label>
	<g:field type="number" name="unitPrice" value="${fieldValue(bean: oiOrderItemInstance, field: 'unitPrice')}" readonly="readonly"/>
</div>

<!-- TODO -->
<div class="fieldcontain ${hasErrors(bean: oiOrderItemInstance, field: 'taxPrice', 'error')} ">
	<label for="taxPrice">
		<g:message code="oiOrderItem.taxPrice.label" default="Tax Price" />
		
	</label>
	<g:field type="number" name="taxPrice" value="${fieldValue(bean: oiOrderItemInstance, field: 'taxPrice')}" />
</div>

<div class="fieldcontain ${hasErrors(bean: oiOrderItemInstance, field: 'lineTotalPrice', 'error')} ">
	<label for="lineTotalPrice">
		<g:message code="oiOrderItem.lineTotalPrice.label" default="Line Total Price" />
		
	</label>
	<g:field type="number" name="lineTotalPrice" value="${fieldValue(bean: oiOrderItemInstance, field: 'lineTotalPrice')}" />
</div>