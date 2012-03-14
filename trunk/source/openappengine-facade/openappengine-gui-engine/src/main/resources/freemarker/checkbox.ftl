<#import "/spring.ftl" as spring/>

<#macro evalBooleanCheckbox>
	
	<@common.evalXpathExpression widgetDataXml "path" />
</#macro>

<#macro checkbox>
	<td>
		<@common.displayLabel .node />
	</td>
	
	<td>
		<#local field = .node["@name"]>	
		<#local val = "<@common.evaluateValue values field />">
		<input type="checkbox" id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget ui-corner-all" 
			<#if val == "true">checked</#if>	 />
	</td>
</#macro>