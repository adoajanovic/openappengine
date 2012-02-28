<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />
<#include "datepicker.ftl" />
<#include "grid.ftl" />
<#include "textfield.ftl" />
<#include "textarea.ftl" />
<#include "checkbox.ftl" />
<#include "radio.ftl" />
<#include "password.ftl" />
<#include "dropdown.ftl" />

<!-- Render Widget -->
<#macro renderWidget childWidget>
  <@formSingle childWidget />
</#macro>

<#macro login>
	<table>
		<tr>
			<#recurse node using .namespace />
		</tr>
		
	</table>
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

<#macro control>
	<tr>
		<td valign="center">
			<#if .node["@type"] != "checkbox">
				<#local for = .node["@id"] >
			<#else>
				<#local for = .node["@id"] + "_Checkbox">
			</#if>
			<label id="${.node["@id"]}_Label" for="${for}">
				<@common.message .node["@labelId"] />
			</label>
		</td>
		
		<td>
			<#if .node["@type"] = "textfield">
				<@textfield .node />
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

<#macro formSingle widgetDataXml>
	<!-- Form Command Object -->
	<div>
		<#if widgetDataXml?has_content>
	 		<!-- Widget : form-single -->
			<form action="${currentURL}" method="post">
				<!-- Meta Model Attributes Used for Processing Widget Submits -->
				<fieldset class="ui-corner-all">
					<table style="width:auto;">
						<@renderFieldsRecursively widgetDataXml />
			 		</table>
		 		</fieldset>
	 		</form>
		</#if>
	</div>
</#macro>

