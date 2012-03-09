<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro password>
	<td>
		<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
			<@common.message .node["@labelId"] />
		</label>
	</td>
	<td>	
		<input id="${.node["@id"]}" name="${.node["@path"]}" type="password" 
				value = "<@common.evalXpathExpression widgetDataXml "path" />" 
				class="ui-widget ui-corner-all" />
	</td>	
</#macro>