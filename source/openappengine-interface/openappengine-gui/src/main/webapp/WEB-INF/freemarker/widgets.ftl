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
	<#list parent?children as child>
		<#visit child using .namespace>
	</#list>
</#macro>


<!-- GUI Fields -->

<!-- 1. Field Group -->
<#macro fieldGroup>
	<div class="ui-widget-header">
			<label id="label_">
				header
			</label>
	</div>
	<#foreach child in .node?children>
		hi
	</#foreach>
	<#recurse .node using .namespace />
</#macro>

<!-- 1. Field -->
<#macro field>
		<!-- If Simple Node render the input -->
		<#assign fieldType = .node.@type>
		<#if fieldType="">
			<#assign fieldType = "text">	
		</#if>	
		<tr>
			<td>
				<label id="label_${.node.@name}" for="${.node.@name}" >
					${.node.@name}
				</label>
			</td>
			<td>
				<input type="${fieldType}" id="${.node.@name}" name="${.node.@name}" value="${.node}" />
			</td>
		</tr>	
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
 		<form action="${currentURL}" method="post">
		<!-- Meta Model Attributes Used for Processing Widget Submits -->
			<input type="hidden" name="widgetId" value="${childWidget.getId()}" />
			<input type="hidden" name="widgetValueRef" value="${childWidget.getValueRef()}" />
			<input type="hidden" name="widgetTransition" value="${childWidget.getTransition()}" />
			<input type="hidden" name="widgetType" value="${childWidget.getWidgetType()}" />
		 		
				<table>
					<#assign formCommand = childWidget.formBackingObject()>
					<@renderFieldsRecursively formCommand.form />
	 				<@gui.formSubmit childWidget.getId() childWidget.getId() 'OK' />
	 			</table>
 			
 			</form>
		</#if>
</#macro>