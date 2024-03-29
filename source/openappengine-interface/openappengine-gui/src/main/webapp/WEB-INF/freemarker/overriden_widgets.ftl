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

<#macro login>
	<table>
		<tr>
			<#recurse node using .namespace />
		</tr>
	</table>
</#macro>

<#macro renderFieldsRecursively templateRootNode>
	<#if templateRootNode["@rendersChildren"]?has_content>
		<#visit templateRootNode using .namespace />
	<#else>
		<#if templateRootNode?children?size != 0>
			<#foreach node in templateRootNode?children>
				<#recurse node using .namespace />
			</#foreach>
		<#else>
			<#visit templateRootNode using .namespace />
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

<#macro renderWidget widgetTemplateNode>
	<#assign widgetTemplateXml = widgetTemplateNode.widgetTemplateXml>
	<#assign widgetDataXml = widgetTemplateNode.widgetDataXml>
	<div>
		<#if widgetDataXml?has_content>
	 		<@renderFieldsRecursively widgetTemplateXml />
		</#if>
	</div>
</#macro>

<#macro formGrid widgetDataNode>
	<#local cols = .node["@columns"]?number>
	<form action="${currentURL}" method="post">
	<table class="ui-widget-content ui-corner-all">
	<#if .node["@headerLabel"]?has_content>
		<tr>
			<td colspan=${.node?children?size?number*2}>
				<div class="ui-widget-header ui-widget-headerLabel ui-corner-all">
					${.node["@headerLabel"]}
				</div>
			</td>
		</tr>
	</#if>
	<tr style="margin-bottom:0.8em;">
		<td>
			<table>
			<#foreach child in .node?children>
				<#if child_index%cols = 0>
					<tr>
				</#if>
					<td>
						<#visit child using .namespace />
					</td>
				<#if child_index%cols= cols-1>
					</tr>
				</#if>
			</#foreach>
			</table>
		</td>
	</tr>
	</table>
	</form>
</#macro>