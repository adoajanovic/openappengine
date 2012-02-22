<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common/>

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
			<label for="${.node["@id"]}" id="${.node["@id"]}">
				<@message .node["@labelId"] />
			</label>
		</td>
		
		<td>
			<#if .node["@type"] = "text">
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
		</td>
	</tr>	
</#macro>

<#macro textField node>
	<#local val = node>
	<input id="${node["@id"]}" name="${node["@name"]}" type="text" value="${val}" />
</#macro>

<#macro password node>
	<#local val = node>
	<input id="${node["@id"]}" name="${node["@name"]}" type="password" value="${val}" />
</#macro>

<#macro datepicker node>
	<#local val = node>
	<input id="datepicker" name="${node["@name"]}" type="text" value="${val}" class="datepicker"/>
</#macro>

<#macro textArea node>
	<#local val = node>
	<#local rows = node["@rows"]>
	<#local cols = node["@cols"]>
	
	<textarea id="${node["@id"]}" name="${node["@name"]}" rows="5" cols="20">
		${val}
	</textarea>
</#macro>

<#macro formSubmit name id value>
	<input type="submit" id="${id}"  name="${name}"  class="button ui-widget ui-corner-all" value="${value}"/>
</#macro>

<#macro formSingle childWidget>
	<!-- Form Command Object -->
	<div>	
	 	<#if childWidget.getWidgetDataXml()?has_content>
	 		<!-- Widget : form-single -->
			<form action="${currentURL}" method="post">
			<!-- Meta Model Attributes Used for Processing Widget Submits -->
				<input type="hidden" name="widgetId" value="${childWidget.getId()}" />
		 		<fieldset>
					<table style="width:auto;">
						<#assign formCommand = childWidget.getWidgetDataXml()>
						<@renderFieldsRecursively formCommand />
		 			</table>
		 			<@gui.formSubmit childWidget.getId() childWidget.getId() 'OK' />
	 			</fieldset>
	 		</form>
		</#if>
	</div>
</#macro>