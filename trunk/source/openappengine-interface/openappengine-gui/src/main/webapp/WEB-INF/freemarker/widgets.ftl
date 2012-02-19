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

<#macro start_td node>
	<#if .node?parent?? && .node?parent?node_name = "row">
		<td>
	</#if>	
</#macro>

<#macro end_td node>
	<#if .node?parent?? && .node?parent?node_name = "row">
		</td>
	</#if>	
</#macro>

<#macro form>
	<!--
	<fieldset <#if .node["@id"]?has_content> id="${.node["@id"]}"</#if><#if .node["@style"]?has_content> class="${.node["@style"]}"</#if>>
	-->
	<#recurse>
	<!--
    </fieldset>
    -->
</#macro>


<!-- GUI Fields -->

<!-- FieldGroup -->
<#macro fieldGroup>
	<@start_td .node/>
	<div class="ui-widget-content">
		<div style="<#if .node?parent??>margin-left:20px;</#if>margin-bottom:20px;" <#if .node?children??>class="ui-widget-content"</#if>>	
			<div class="ui-widget-header">
				<#if .node["@header"]?has_content>
					<h4 style="margin-left:20px;">
						${.node["@header"]}
					</h4>	
				</#if>
			</div>
			<#recurse .node using .namespace >
		</div>
	</div>
	<@end_td .node/>	
</#macro>

<#macro row>
	<tr style="width:100%;">
		<#recurse node using .namespace />
	</tr>
</#macro>

<!-- Field -->
<#macro field>
	<@start_td .node/>
		<#recurse .node using .namespace />
	<@end_td .node/>
</#macro>

<#macro input>
	<input type="text" id="${.node.@name}" name="${.node.@name}" value="${.node}" style="ui-widget" />
</#macro>

<#macro label>
	<@start_td .node/>
	<label id="label_${.node}" for="${.node}"  style="margin-bottom:10px;">
		${.node}
	</label>
	<@end_td .node/>
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