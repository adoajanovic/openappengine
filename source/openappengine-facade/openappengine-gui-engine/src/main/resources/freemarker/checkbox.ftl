<#import "/spring.ftl" as spring/>

<#macro evalBooleanCheckbox>
	
	<@common.evalXpathExpression widgetDataXml "path" />
</#macro>

<#macro checkbox>
	<td>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	</td>
	
	<td>
		<#if .node["@path"]?has_content>
			<#local val = widgetDataXml[.node["@path"]]?trim>
		</#if>
		<input type="checkbox" id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget ui-corner-all" 
			<#if val == "true">checked</#if>	 />
	</td>
</#macro>