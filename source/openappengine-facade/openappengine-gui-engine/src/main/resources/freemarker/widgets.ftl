<#import "/spring.ftl" as spring/>
<#include "datepicker.ftl" />
<#include "textField.ftl" />
<#include "textArea.ftl" />
<#include "checkbox.ftl" />
<#include "radio.ftl" />
<#include "password.ftl" />
<#include "dropdown.ftl" />

<!-- Render Widget -->
<#macro renderWidget childWidget>
  <!-- Form Single -->
  <#if childWidget.getWidgetType() = "widget">
	  <@formSingle childWidget />
  </#if>
  <!-- Add Custom Widgets -->
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
	<#recurse>
</#macro>

<#macro fieldGroup>
	<@start_td .node/>
	<div class="ui-widget-content" style="border-right=0px;border-left:0px;border-top:0px">
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

<#macro field>
	<@start_td .node/>
		<#recurse .node using .namespace />
	<@end_td .node/>
</#macro>

<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
<#macro message code>${messageContext.getMessageText(code)}</#macro>

<#macro control>
	<tr>
		<td valign="center">
			<#if .node["@type"] != "checkbox">
				<#local for = .node["@id"] >
			<#else>
				<#local for = .node["@id"] + "_Checkbox">
			</#if>
			<label id="${.node["@id"]}_Label" for="${for}">
				<@message .node["@labelId"] />
			</label>
		</td>
		
		<td>
			<#if .node["@type"] = "textfield">
				<@textField .node />
			</#if>
			<#if .node["@type"] = "textarea">
				<@textArea .node />
			</#if>
			<#if .node["@type"] = "password">
				<@password .node />
			</#if>
			<#if .node["@type"] = "date">
				<@datepicker .node />
			</#if>
			<#if .node["@type"] = "checkbox">
				<@checkbox .node />
			</#if>
			<#if .node["@type"] = "dropdown">
				<@dropdown .node />
			</#if>
			<#if .node["@type"] = "radio">
				<@radio .node />
			</#if>
		</td>
	</tr>	
</#macro>

<#macro formSubmit name id value>
	<input type="submit" id="${id}"  name="${name}"  class="button ui-widget ui-corner-all" value="${value}"/>
</#macro>

<#macro formSingle childWidget>
	<!-- Form Command Object -->
	<div>
		<#local widgetDataXml = childWidget.getWidgetDataXml()>	
	 	<#if widgetDataXml?has_content>
	 		<!-- Widget : form-single -->
			<form action="${currentURL}" method="post">
			<!-- Meta Model Attributes Used for Processing Widget Submits -->
				<input type="hidden" name="widgetId" value="${childWidget.getId()}" />
		 		<fieldset>
					<table style="width:auto;">
						<@renderFieldsRecursively widgetDataXml />
		 			</table>
		 			<@gui.formSubmit childWidget.getId() childWidget.getId() 'OK' />
	 			</fieldset>
	 		</form>
		</#if>
	</div>
</#macro>

