<#import "/spring.ftl" as spring/>

<#macro textarea>
	<td>
		<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
			<@common.message .node["@labelId"] />
		</label>
	</td>
	<td>
		<textarea id="${.node["@id"]}" name="${.node["@name"]}" rows="${.node["@rows"]}" cols="${.node["@cols"]}">
			<@common.evalXpathExpression widgetDataXml "path" />
		</textarea>
	</td>	
</#macro>