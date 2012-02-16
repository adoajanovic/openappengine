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
		<#foreach node in parent?children>
			<#recurse node using .namespace />
		</#foreach>
	<#else>
		<#visit parent using .namespace />
	</#if>
</#macro>

<#macro form>
	<fieldset <#if .node["@id"]?has_content> id="${.node["@id"]}"</#if><#if .node["@style"]?has_content> class="${.node["@style"]}"</#if>>
		<#recurse>
    </fieldset>
</#macro>


<!-- GUI Fields -->

<!-- FieldGroup -->
<#macro fieldGroup>
	<div class="ui-widget-header" style="margin-bottom:20px;">
		<#if .node["@header"]?has_content>
			<h4 style="margin-left:20px;">
				${.node["@header"]}
			</h4>	
		</#if>
	</div>
	<#foreach node in .node?children> 
		<tr>
			<#visit node using .namespace />
		</tr>	
	</#foreach>	
</#macro>

<#macro row>
	<#recurse .node using .namespace />
</#macro>

<!-- Field -->
<#macro field>
	<#recurse .node using .namespace />
</#macro>

<#macro input>
	<td>
		<input type="text" id="${.node.@name}" name="${.node.@name}" value="${.node}" style="ui-widget" />
	</td>
</#macro>

<#macro label>
	<td>
		<label id="label_${.node}" for="${.node}"  style="margin-bottom:10px;">
			${.node}
		</label>
	</td>
</#macro>

<!-- 2. FormSubmit -->
<#macro formSubmit name id value>
	<input type="submit" id="${id}"  name="${name}"  class="button ui-widget ui-corner-all" value="${value}"/>
</#macro>

<!-- Widget  -->
<!-- 1.  FormSingle -->
<#macro formSingle childWidget>
	<!-- Form Command Object -->
	<div class="ui-widget-content">	
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
						<@renderFieldsRecursively formCommand />
		 			</table>
		 			<@gui.formSubmit childWidget.getId() childWidget.getId() 'OK' />
	 			</fieldset>
	 			</form>
		</#if>
	</div>
</#macro>