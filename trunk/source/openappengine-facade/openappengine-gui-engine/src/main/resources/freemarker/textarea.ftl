<#import "/spring.ftl" as spring/>

<#macro textarea>
	<td>
		<@common.displayLabel .node />
	</td>
	<td>
		<textarea id="${.node["@id"]}" name="${.node["@name"]}" rows="${.node["@rows"]}" cols="${.node["@cols"]}">
			<@common.evalXpathExpression widgetDataXml "path" />
		</textarea>
	</td>	
</#macro>