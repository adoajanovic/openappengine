<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />
<#include "datepicker.ftl" />
<#include "formGrid.ftl" />
<#include "dataTable.ftl" />
<#include "textfield.ftl" />
<#include "textarea.ftl" />
<#include "checkbox.ftl" />
<#include "radio.ftl" />
<#include "password.ftl" />
<#include "dropdown.ftl" />
<#include "actionButton.ftl" />

<#macro login>
	<table>
		<tr>
			<#recurse node using .namespace />
		</tr>
	</table>
</#macro>

<#macro renderFieldsRecursively parent>
	<#if parent["@rendersChildren"]?has_content>
		<#visit parent using .namespace />
	<#else>
		<#if parent?children?size != 0>
			<#foreach node in parent?children>
				<#recurse node using .namespace />
			</#foreach>
		<#else>
			<#visit parent using .namespace />
		</#if>	
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

<#macro metadata>
	<#foreach meta in .node?children>
		<input type="hidden" name="${meta?node_name}" value="${meta}" />
	</#foreach>
</#macro>

<#macro renderWidget widgetTemplateNode>
	<#assign widgetTemplateXml = widgetTemplateNode.widgetTemplateXml>
	<#assign values = widgetTemplateNode.getFieldValues()>
	<#assign widgetId = widgetTemplateNode.widgetId>
	<#local bindingResult = widgetTemplateNode.bindingResult>
	<div>
		<form method="post" action="${currentURL}">
			<@renderFieldsRecursively widgetTemplateXml />
		</form>
	</div>
	<script type="text/javascript">
		<#if bindingResult.hasErrors()>
			<#local fieldErrors = bindingResult.getFieldErrors() >
			<#local fieldsConcat = "Required Fields are missing \n">;
			<#list fieldErrors as fieldError>
				<#local field = fieldError.getField()>
				<#if field?has_content>
					jQuery(document).ready(function (){
						jQuery('[name="${field}"]').addClass(' ui-state-error');
					});
				</#if>
			</#list>
		</#if>
	</script>
</#macro>