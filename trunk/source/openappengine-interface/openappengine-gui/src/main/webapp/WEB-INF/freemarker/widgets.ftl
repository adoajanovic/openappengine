<!-- Render Widget -->
<#macro renderWidget childWidget>
  <!-- Form Single -->
  <#if childWidget.getWidgetType() = "form-single">
	  <@formSingle childWidget />
  </#if>
  
  <#if childWidget.getWidgetType() = "form-list">
	  <@formList childWidget />
  </#if>
</#macro>

<#macro renderFieldsRecursively parent>
	<#if parent?children?size != 0>
		<#if parent?node_name = "fieldGroup">
			<div class="ui-widget-header" style="margin:top:10px;">
				${parent?node_name}
			</div>
		</#if>
		<#foreach node in parent?children>
			<tr>
				<@renderFieldsRecursively node />
			</tr>
		</#foreach>
	<#else>
		<tr>	
			<#visit parent using .namespace />
		</tr>	
	</#if>
</#macro>


<!-- GUI Fields -->

<!-- FieldGroup -->
<#macro fieldGroup>
	<div class="ui-widget-header">
		header
	</div>
</#macro>

<!-- Field -->
<#macro field>
	<#recurse .node using .namespace />
</#macro>

<#macro input>
	<input type="text" id="${.node.@name}" name="${.node.@name}" value="${.node}" />
</#macro>

<#macro label>
	<td>
		<label>${.node}</label>
	</td>
</#macro>

<!-- 2. FormSubmit -->
<#macro formSubmit name id value>
	<tr>
		<td>
			<input type="submit" id="${id}"  name="${name}"  class="button ui-state-default ui-corner-all" value="${value}"/>
		</td>
	</tr>
</#macro>

<!-- Widget  -->
<!-- 1.  FormSingle -->
<#macro formSingle childWidget>
	<!-- Form Command Object -->
 	<#if childWidget.formBackingObject()?has_content>
 		<!-- Widget : form-single -->
		<form action="${currentURL}" method="post">
		<!-- Meta Model Attributes Used for Processing Widget Submits -->
			<input type="hidden" name="widgetId" value="${childWidget.getId()}" />
			<input type="hidden" name="widgetValueRef" value="${childWidget.getValueRef()}" />
			<input type="hidden" name="widgetTransition" value="${childWidget.getTransition()}" />
			<input type="hidden" name="widgetType" value="${childWidget.getWidgetType()}" />
		 		
	 		<fieldset>
				<table>
					<#assign formCommand = childWidget.formBackingObject()>
					<@renderFieldsRecursively formCommand.form />
	 				<@gui.formSubmit childWidget.getId() childWidget.getId() 'OK' />
	 			</table>
 			</fieldset>
 			</form>
		</#if>
</#macro>