<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro password>
	<td>
		<@common.displayLabel .node />
	</td>
	<td>
		<#local field = .node["@path"]>	
		<input id="${.node["@id"]}" name="${.node["@name"]}" type="password" 
				value = "<@common.evaluateValue values field />" 
				class="ui-widget ui-corner-all" />
	</td>	
</#macro>