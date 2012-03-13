<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro password>
	<td>
		<@common.displayLabel .node />
	</td>
	<td>	
		<input id="${.node["@id"]}" name="${.node["@name"]}" type="password" 
				value = "<@common.evalXpathExpression widgetDataXml "path" />" 
				class="ui-widget ui-corner-all" />
	</td>	
</#macro>