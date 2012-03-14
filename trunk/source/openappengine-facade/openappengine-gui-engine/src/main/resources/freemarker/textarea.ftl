<#import "/spring.ftl" as spring/>

<#macro textarea>
	<td>
		<@common.displayLabel .node />
	</td>
	<td>
		<#local field = .node["@name"]>	
		<textarea id="${.node["@id"]}" name="${.node["@name"]}" rows="${.node["@rows"]}" cols="${.node["@cols"]}">
			<@common.evaluateValue values field />
		</textarea>
	</td>	
</#macro>