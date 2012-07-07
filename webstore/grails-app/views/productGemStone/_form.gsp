<%@ page import="com.openappengine.product.ProductGemStone" %>



<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'carat', 'error')} required">
	<label for="carat">
		<g:message code="productGemStone.carat.label" default="Carat" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="carat" required="" value="${fieldValue(bean: productGemStoneInstance, field: 'carat')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'clarity', 'error')} ">
	<label for="clarity">
		<g:message code="productGemStone.clarity.label" default="Clarity" />
		
	</label>
	<g:textField name="clarity" value="${productGemStoneInstance?.clarity}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'color', 'error')} ">
	<label for="color">
		<g:message code="productGemStone.color.label" default="Color" />
		
	</label>
	<g:textField name="color" value="${productGemStoneInstance?.color}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'cut', 'error')} ">
	<label for="cut">
		<g:message code="productGemStone.cut.label" default="Cut" />
		
	</label>
	<g:textField name="cut" value="${productGemStoneInstance?.cut}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'grade', 'error')} ">
	<label for="grade">
		<g:message code="productGemStone.grade.label" default="Grade" />
		
	</label>
	<g:textField name="grade" value="${productGemStoneInstance?.grade}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'hardness', 'error')} ">
	<label for="hardness">
		<g:message code="productGemStone.hardness.label" default="Hardness" />
		
	</label>
	<g:textField name="hardness" value="${productGemStoneInstance?.hardness}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'measurements', 'error')} ">
	<label for="measurements">
		<g:message code="productGemStone.measurements.label" default="Measurements" />
		
	</label>
	<g:textField name="measurements" value="${productGemStoneInstance?.measurements}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'origin', 'error')} ">
	<label for="origin">
		<g:message code="productGemStone.origin.label" default="Origin" />
		
	</label>
	<g:textField name="origin" value="${productGemStoneInstance?.origin}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdAmountUomType', 'error')} ">
	<label for="pdAmountUomType">
		<g:message code="productGemStone.pdAmountUomType.label" default="Pd Amount Uom Type" />
		
	</label>
	<g:textField name="pdAmountUomType" value="${productGemStoneInstance?.pdAmountUomType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdComments', 'error')} ">
	<label for="pdComments">
		<g:message code="productGemStone.pdComments.label" default="Pd Comments" />
		
	</label>
	<g:textField name="pdComments" value="${productGemStoneInstance?.pdComments}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdCreatedDate', 'error')} required">
	<label for="pdCreatedDate">
		<g:message code="productGemStone.pdCreatedDate.label" default="Pd Created Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="pdCreatedDate" precision="day"  value="${productGemStoneInstance?.pdCreatedDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdDescription', 'error')} ">
	<label for="pdDescription">
		<g:message code="productGemStone.pdDescription.label" default="Pd Description" />
		
	</label>
	<g:textField name="pdDescription" value="${productGemStoneInstance?.pdDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdFixedAmount', 'error')} required">
	<label for="pdFixedAmount">
		<g:message code="productGemStone.pdFixedAmount.label" default="Pd Fixed Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pdFixedAmount" required="" value="${fieldValue(bean: productGemStoneInstance, field: 'pdFixedAmount')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdInternalName', 'error')} ">
	<label for="pdInternalName">
		<g:message code="productGemStone.pdInternalName.label" default="Pd Internal Name" />
		
	</label>
	<g:textField name="pdInternalName" value="${productGemStoneInstance?.pdInternalName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdIntroductionDate', 'error')} required">
	<label for="pdIntroductionDate">
		<g:message code="productGemStone.pdIntroductionDate.label" default="Pd Introduction Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="pdIntroductionDate" precision="day"  value="${productGemStoneInstance?.pdIntroductionDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdIsVirtual', 'error')} ">
	<label for="pdIsVirtual">
		<g:message code="productGemStone.pdIsVirtual.label" default="Pd Is Virtual" />
		
	</label>
	<g:checkBox name="pdIsVirtual" value="${productGemStoneInstance?.pdIsVirtual}" />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdPiecesIncluded', 'error')} required">
	<label for="pdPiecesIncluded">
		<g:message code="productGemStone.pdPiecesIncluded.label" default="Pd Pieces Included" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pdPiecesIncluded" required="" value="${fieldValue(bean: productGemStoneInstance, field: 'pdPiecesIncluded')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdProductName', 'error')} ">
	<label for="pdProductName">
		<g:message code="productGemStone.pdProductName.label" default="Pd Product Name" />
		
	</label>
	<g:textField name="pdProductName" value="${productGemStoneInstance?.pdProductName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdProductType', 'error')} ">
	<label for="pdProductType">
		<g:message code="productGemStone.pdProductType.label" default="Pd Product Type" />
		
	</label>
	<g:textField name="pdProductType" value="${productGemStoneInstance?.pdProductType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdQuantityIncluded', 'error')} required">
	<label for="pdQuantityIncluded">
		<g:message code="productGemStone.pdQuantityIncluded.label" default="Pd Quantity Included" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pdQuantityIncluded" required="" value="${fieldValue(bean: productGemStoneInstance, field: 'pdQuantityIncluded')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdQuantityUom', 'error')} ">
	<label for="pdQuantityUom">
		<g:message code="productGemStone.pdQuantityUom.label" default="Pd Quantity Uom" />
		
	</label>
	<g:textField name="pdQuantityUom" value="${productGemStoneInstance?.pdQuantityUom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdRequireAmount', 'error')} ">
	<label for="pdRequireAmount">
		<g:message code="productGemStone.pdRequireAmount.label" default="Pd Require Amount" />
		
	</label>
	<g:checkBox name="pdRequireAmount" value="${productGemStoneInstance?.pdRequireAmount}" />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdRequireInventory', 'error')} ">
	<label for="pdRequireInventory">
		<g:message code="productGemStone.pdRequireInventory.label" default="Pd Require Inventory" />
		
	</label>
	<g:checkBox name="pdRequireInventory" value="${productGemStoneInstance?.pdRequireInventory}" />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdReturnable', 'error')} ">
	<label for="pdReturnable">
		<g:message code="productGemStone.pdReturnable.label" default="Pd Returnable" />
		
	</label>
	<g:checkBox name="pdReturnable" value="${productGemStoneInstance?.pdReturnable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdSalesDiscWhenNotAvail', 'error')} ">
	<label for="pdSalesDiscWhenNotAvail">
		<g:message code="productGemStone.pdSalesDiscWhenNotAvail.label" default="Pd Sales Disc When Not Avail" />
		
	</label>
	<g:checkBox name="pdSalesDiscWhenNotAvail" value="${productGemStoneInstance?.pdSalesDiscWhenNotAvail}" />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdSalesDiscontinuationDate', 'error')} required">
	<label for="pdSalesDiscontinuationDate">
		<g:message code="productGemStone.pdSalesDiscontinuationDate.label" default="Pd Sales Discontinuation Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="pdSalesDiscontinuationDate" precision="day"  value="${productGemStoneInstance?.pdSalesDiscontinuationDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdSupportDiscontinuationDate', 'error')} required">
	<label for="pdSupportDiscontinuationDate">
		<g:message code="productGemStone.pdSupportDiscontinuationDate.label" default="Pd Support Discontinuation Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="pdSupportDiscontinuationDate" precision="day"  value="${productGemStoneInstance?.pdSupportDiscontinuationDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdTaxable', 'error')} ">
	<label for="pdTaxable">
		<g:message code="productGemStone.pdTaxable.label" default="Pd Taxable" />
		
	</label>
	<g:checkBox name="pdTaxable" value="${productGemStoneInstance?.pdTaxable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdWeight', 'error')} required">
	<label for="pdWeight">
		<g:message code="productGemStone.pdWeight.label" default="Pd Weight" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pdWeight" required="" value="${fieldValue(bean: productGemStoneInstance, field: 'pdWeight')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'pdWeightUomId', 'error')} ">
	<label for="pdWeightUomId">
		<g:message code="productGemStone.pdWeightUomId.label" default="Pd Weight Uom Id" />
		
	</label>
	<g:textField name="pdWeightUomId" value="${productGemStoneInstance?.pdWeightUomId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'prodProductPrices', 'error')} ">
	<label for="prodProductPrices">
		<g:message code="productGemStone.prodProductPrices.label" default="Prod Product Prices" />
		
	</label>
	<g:select name="prodProductPrices" from="${com.openappengine.product.ProdProductPrice.list()}" multiple="multiple" optionKey="id" size="5" value="${productGemStoneInstance?.prodProductPrices*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'shape', 'error')} ">
	<label for="shape">
		<g:message code="productGemStone.shape.label" default="Shape" />
		
	</label>
	<g:textField name="shape" value="${productGemStoneInstance?.shape}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productGemStoneInstance, field: 'traetement', 'error')} ">
	<label for="traetement">
		<g:message code="productGemStone.traetement.label" default="Traetement" />
		
	</label>
	<g:textField name="traetement" value="${productGemStoneInstance?.traetement}"/>
</div>

