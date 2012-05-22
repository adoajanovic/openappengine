
<%@ page import="com.openappengine.model.product.Product"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'product.label', default: 'Product')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<div id="show-product" class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list product">
			<g:if test="${productInstance?.pdProductName}">
				<li class="fieldcontain"><span id="pdProductName-label"
					class="property-label"><g:message
							code="product.pdProductName.label" default="Product Name" /></span>
					<span class="property-value" aria-labelledby="pdProductName-label"><g:fieldValue
							bean="${productInstance}" field="pdProductName" /></span></li>
			</g:if>

			<g:if test="${productInstance?.pdInternalName}">
				<li class="fieldcontain"><span id="pdInternalName-label"
					class="property-label"><g:message
							code="product.pdInternalName.label" default="Internal Name" /></span>
					<span class="property-value" aria-labelledby="pdInternalName-label"><g:fieldValue
							bean="${productInstance}" field="pdInternalName" /></span></li>
			</g:if>
			
			<g:if test="${productInstance?.pdIntroductionDate}">
				<li class="fieldcontain"><span id="pdIntroductionDate-label"
					class="property-label"><g:message
							code="product.pdIntroductionDate.label"
							default="Introduction Date" /></span> <span class="property-value"
					aria-labelledby="pdIntroductionDate-label">
					<g:formatDate format="yyyy-MM-dd"
							date="${productInstance?.pdIntroductionDate}" /></span></li>
			</g:if>
			
			<g:if test="${productInstance?.pdProductType}">
				<li class="fieldcontain"><span id="pdProductType-label"
					class="property-label"><g:message
							code="product.pdProductType.label" default="Product Type" /></span>
					<span class="property-value" aria-labelledby="pdProductType-label"><g:fieldValue
							bean="${productInstance}" field="pdProductType" /></span></li>
			</g:if>
			
			<g:if test="${productInstance?.pdTaxable}">
				<li class="fieldcontain"><span id="pdTaxable-label"
					class="property-label"><g:message
							code="product.pdTaxable.label" default="Taxable" /></span> <span
					class="property-value" aria-labelledby="pdTaxable-label"><g:formatBoolean
							boolean="${productInstance?.pdTaxable}" /></span></li>
			</g:if>
			
			<g:if test="${productInstance?.pdFixedAmount}">
				<li class="fieldcontain"><span id="pdFixedAmount-label"
					class="property-label"><g:message
							code="product.pdFixedAmount.label" default="Fixed Amount" /></span>
					<span class="property-value" aria-labelledby="pdFixedAmount-label"><g:fieldValue
							bean="${productInstance}" field="pdFixedAmount" /></span></li>
			</g:if>
			
			<g:if test="${productInstance?.pdDescription}">
				<li class="fieldcontain"><span id="pdDescription-label"
					class="property-label"><g:message
							code="product.pdDescription.label" default="Description" /></span> <span
					class="property-value" aria-labelledby="pdDescription-label"><g:fieldValue
							bean="${productInstance}" field="pdDescription" /></span></li>
			</g:if>
			
			<g:if test="${productInstance?.pdIsVirtual}">
				<li class="fieldcontain"><span id="pdIsVirtual-label"
					class="property-label"><g:message
							code="product.pdIsVirtual.label" default="Is Virtual" /></span> <span
					class="property-value" aria-labelledby="pdIsVirtual-label"><g:formatBoolean
							boolean="${productInstance?.pdIsVirtual}" /></span></li>
			</g:if>

			<li class="fieldcontain"><span id="pdCreatedDate-label"
				class="property-label"><g:message
						code="product.pdCreatedDate.label" default="Created Date" /></span> <span
				class="property-value" aria-labelledby="pdCreatedDate-label"><g:formatDate format="yyyy-MM-dd"
						date="${productInstance?.pdCreatedDate}" /></span></li>

			<li class="fieldcontain"><span
				id="pdSalesDiscontinuationDate-label" class="property-label"><g:message
						code="product.pdSalesDiscontinuationDate.label"
						default="Sales Discontinuation Date" /></span> <span
				class="property-value"
				aria-labelledby="pdSalesDiscontinuationDate-label"><g:formatDate format="yyyy-MM-dd"
						date="${productInstance?.pdSalesDiscontinuationDate}" /></span></li>

			<li class="fieldcontain"><span
					id="pdSupportDiscontinuationDate-label" class="property-label"><g:message
							code="product.pdSupportDiscontinuationDate.label"
							default="Support Discontinuation Date" /></span> <span
					class="property-value"
					aria-labelledby="pdSupportDiscontinuationDate-label"><g:formatDate format="yyyy-MM-dd"
							date="${productInstance?.pdSupportDiscontinuationDate}" /></span></li>

			<g:if test="${productInstance?.prodProductPrices}">
				<li class="fieldcontain"><span id="prodProductPrices-label"
					class="property-label"><g:message
							code="product.prodProductPrices.label"
							default="Prod Product Prices" /></span> <g:each
						in="${productInstance.prodProductPrices}" var="p">
						<span class="property-value"
							aria-labelledby="prodProductPrices-label"><g:link
								controller="prodProductPrice" action="show" id="${p.pdProductId}">
								${p?.encodeAsHTML()}
							</g:link></span>
					</g:each></li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${productInstance?.pdProductId}" />
				<g:link class="edit" action="edit" id="${productInstance?.pdProductId}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
