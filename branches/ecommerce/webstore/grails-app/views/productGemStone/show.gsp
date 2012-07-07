
<%@ page import="com.openappengine.product.ProductGemStone" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productGemStone.label', default: 'ProductGemStone')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-productGemStone" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-productGemStone" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list productGemStone">
			
				<g:if test="${productGemStoneInstance?.carat}">
				<li class="fieldcontain">
					<span id="carat-label" class="property-label"><g:message code="productGemStone.carat.label" default="Carat" /></span>
					
						<span class="property-value" aria-labelledby="carat-label"><g:fieldValue bean="${productGemStoneInstance}" field="carat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.clarity}">
				<li class="fieldcontain">
					<span id="clarity-label" class="property-label"><g:message code="productGemStone.clarity.label" default="Clarity" /></span>
					
						<span class="property-value" aria-labelledby="clarity-label"><g:fieldValue bean="${productGemStoneInstance}" field="clarity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.color}">
				<li class="fieldcontain">
					<span id="color-label" class="property-label"><g:message code="productGemStone.color.label" default="Color" /></span>
					
						<span class="property-value" aria-labelledby="color-label"><g:fieldValue bean="${productGemStoneInstance}" field="color"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.cut}">
				<li class="fieldcontain">
					<span id="cut-label" class="property-label"><g:message code="productGemStone.cut.label" default="Cut" /></span>
					
						<span class="property-value" aria-labelledby="cut-label"><g:fieldValue bean="${productGemStoneInstance}" field="cut"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.grade}">
				<li class="fieldcontain">
					<span id="grade-label" class="property-label"><g:message code="productGemStone.grade.label" default="Grade" /></span>
					
						<span class="property-value" aria-labelledby="grade-label"><g:fieldValue bean="${productGemStoneInstance}" field="grade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.hardness}">
				<li class="fieldcontain">
					<span id="hardness-label" class="property-label"><g:message code="productGemStone.hardness.label" default="Hardness" /></span>
					
						<span class="property-value" aria-labelledby="hardness-label"><g:fieldValue bean="${productGemStoneInstance}" field="hardness"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.measurements}">
				<li class="fieldcontain">
					<span id="measurements-label" class="property-label"><g:message code="productGemStone.measurements.label" default="Measurements" /></span>
					
						<span class="property-value" aria-labelledby="measurements-label"><g:fieldValue bean="${productGemStoneInstance}" field="measurements"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.origin}">
				<li class="fieldcontain">
					<span id="origin-label" class="property-label"><g:message code="productGemStone.origin.label" default="Origin" /></span>
					
						<span class="property-value" aria-labelledby="origin-label"><g:fieldValue bean="${productGemStoneInstance}" field="origin"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdAmountUomType}">
				<li class="fieldcontain">
					<span id="pdAmountUomType-label" class="property-label"><g:message code="productGemStone.pdAmountUomType.label" default="Pd Amount Uom Type" /></span>
					
						<span class="property-value" aria-labelledby="pdAmountUomType-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdAmountUomType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdComments}">
				<li class="fieldcontain">
					<span id="pdComments-label" class="property-label"><g:message code="productGemStone.pdComments.label" default="Pd Comments" /></span>
					
						<span class="property-value" aria-labelledby="pdComments-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdComments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdCreatedDate}">
				<li class="fieldcontain">
					<span id="pdCreatedDate-label" class="property-label"><g:message code="productGemStone.pdCreatedDate.label" default="Pd Created Date" /></span>
					
						<span class="property-value" aria-labelledby="pdCreatedDate-label"><g:formatDate date="${productGemStoneInstance?.pdCreatedDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdDescription}">
				<li class="fieldcontain">
					<span id="pdDescription-label" class="property-label"><g:message code="productGemStone.pdDescription.label" default="Pd Description" /></span>
					
						<span class="property-value" aria-labelledby="pdDescription-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdDescription"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdFixedAmount}">
				<li class="fieldcontain">
					<span id="pdFixedAmount-label" class="property-label"><g:message code="productGemStone.pdFixedAmount.label" default="Pd Fixed Amount" /></span>
					
						<span class="property-value" aria-labelledby="pdFixedAmount-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdFixedAmount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdInternalName}">
				<li class="fieldcontain">
					<span id="pdInternalName-label" class="property-label"><g:message code="productGemStone.pdInternalName.label" default="Pd Internal Name" /></span>
					
						<span class="property-value" aria-labelledby="pdInternalName-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdInternalName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdIntroductionDate}">
				<li class="fieldcontain">
					<span id="pdIntroductionDate-label" class="property-label"><g:message code="productGemStone.pdIntroductionDate.label" default="Pd Introduction Date" /></span>
					
						<span class="property-value" aria-labelledby="pdIntroductionDate-label"><g:formatDate date="${productGemStoneInstance?.pdIntroductionDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdIsVirtual}">
				<li class="fieldcontain">
					<span id="pdIsVirtual-label" class="property-label"><g:message code="productGemStone.pdIsVirtual.label" default="Pd Is Virtual" /></span>
					
						<span class="property-value" aria-labelledby="pdIsVirtual-label"><g:formatBoolean boolean="${productGemStoneInstance?.pdIsVirtual}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdPiecesIncluded}">
				<li class="fieldcontain">
					<span id="pdPiecesIncluded-label" class="property-label"><g:message code="productGemStone.pdPiecesIncluded.label" default="Pd Pieces Included" /></span>
					
						<span class="property-value" aria-labelledby="pdPiecesIncluded-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdPiecesIncluded"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdProductName}">
				<li class="fieldcontain">
					<span id="pdProductName-label" class="property-label"><g:message code="productGemStone.pdProductName.label" default="Pd Product Name" /></span>
					
						<span class="property-value" aria-labelledby="pdProductName-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdProductName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdProductType}">
				<li class="fieldcontain">
					<span id="pdProductType-label" class="property-label"><g:message code="productGemStone.pdProductType.label" default="Pd Product Type" /></span>
					
						<span class="property-value" aria-labelledby="pdProductType-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdProductType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdQuantityIncluded}">
				<li class="fieldcontain">
					<span id="pdQuantityIncluded-label" class="property-label"><g:message code="productGemStone.pdQuantityIncluded.label" default="Pd Quantity Included" /></span>
					
						<span class="property-value" aria-labelledby="pdQuantityIncluded-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdQuantityIncluded"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdQuantityUom}">
				<li class="fieldcontain">
					<span id="pdQuantityUom-label" class="property-label"><g:message code="productGemStone.pdQuantityUom.label" default="Pd Quantity Uom" /></span>
					
						<span class="property-value" aria-labelledby="pdQuantityUom-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdQuantityUom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdRequireAmount}">
				<li class="fieldcontain">
					<span id="pdRequireAmount-label" class="property-label"><g:message code="productGemStone.pdRequireAmount.label" default="Pd Require Amount" /></span>
					
						<span class="property-value" aria-labelledby="pdRequireAmount-label"><g:formatBoolean boolean="${productGemStoneInstance?.pdRequireAmount}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdRequireInventory}">
				<li class="fieldcontain">
					<span id="pdRequireInventory-label" class="property-label"><g:message code="productGemStone.pdRequireInventory.label" default="Pd Require Inventory" /></span>
					
						<span class="property-value" aria-labelledby="pdRequireInventory-label"><g:formatBoolean boolean="${productGemStoneInstance?.pdRequireInventory}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdReturnable}">
				<li class="fieldcontain">
					<span id="pdReturnable-label" class="property-label"><g:message code="productGemStone.pdReturnable.label" default="Pd Returnable" /></span>
					
						<span class="property-value" aria-labelledby="pdReturnable-label"><g:formatBoolean boolean="${productGemStoneInstance?.pdReturnable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdSalesDiscWhenNotAvail}">
				<li class="fieldcontain">
					<span id="pdSalesDiscWhenNotAvail-label" class="property-label"><g:message code="productGemStone.pdSalesDiscWhenNotAvail.label" default="Pd Sales Disc When Not Avail" /></span>
					
						<span class="property-value" aria-labelledby="pdSalesDiscWhenNotAvail-label"><g:formatBoolean boolean="${productGemStoneInstance?.pdSalesDiscWhenNotAvail}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdSalesDiscontinuationDate}">
				<li class="fieldcontain">
					<span id="pdSalesDiscontinuationDate-label" class="property-label"><g:message code="productGemStone.pdSalesDiscontinuationDate.label" default="Pd Sales Discontinuation Date" /></span>
					
						<span class="property-value" aria-labelledby="pdSalesDiscontinuationDate-label"><g:formatDate date="${productGemStoneInstance?.pdSalesDiscontinuationDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdSupportDiscontinuationDate}">
				<li class="fieldcontain">
					<span id="pdSupportDiscontinuationDate-label" class="property-label"><g:message code="productGemStone.pdSupportDiscontinuationDate.label" default="Pd Support Discontinuation Date" /></span>
					
						<span class="property-value" aria-labelledby="pdSupportDiscontinuationDate-label"><g:formatDate date="${productGemStoneInstance?.pdSupportDiscontinuationDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdTaxable}">
				<li class="fieldcontain">
					<span id="pdTaxable-label" class="property-label"><g:message code="productGemStone.pdTaxable.label" default="Pd Taxable" /></span>
					
						<span class="property-value" aria-labelledby="pdTaxable-label"><g:formatBoolean boolean="${productGemStoneInstance?.pdTaxable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdWeight}">
				<li class="fieldcontain">
					<span id="pdWeight-label" class="property-label"><g:message code="productGemStone.pdWeight.label" default="Pd Weight" /></span>
					
						<span class="property-value" aria-labelledby="pdWeight-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdWeight"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.pdWeightUomId}">
				<li class="fieldcontain">
					<span id="pdWeightUomId-label" class="property-label"><g:message code="productGemStone.pdWeightUomId.label" default="Pd Weight Uom Id" /></span>
					
						<span class="property-value" aria-labelledby="pdWeightUomId-label"><g:fieldValue bean="${productGemStoneInstance}" field="pdWeightUomId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.prodProductPrices}">
				<li class="fieldcontain">
					<span id="prodProductPrices-label" class="property-label"><g:message code="productGemStone.prodProductPrices.label" default="Prod Product Prices" /></span>
					
						<g:each in="${productGemStoneInstance.prodProductPrices}" var="p">
						<span class="property-value" aria-labelledby="prodProductPrices-label"><g:link controller="prodProductPrice" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.shape}">
				<li class="fieldcontain">
					<span id="shape-label" class="property-label"><g:message code="productGemStone.shape.label" default="Shape" /></span>
					
						<span class="property-value" aria-labelledby="shape-label"><g:fieldValue bean="${productGemStoneInstance}" field="shape"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productGemStoneInstance?.traetement}">
				<li class="fieldcontain">
					<span id="traetement-label" class="property-label"><g:message code="productGemStone.traetement.label" default="Traetement" /></span>
					
						<span class="property-value" aria-labelledby="traetement-label"><g:fieldValue bean="${productGemStoneInstance}" field="traetement"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${productGemStoneInstance?.id}" />
					<g:link class="edit" action="edit" id="${productGemStoneInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
