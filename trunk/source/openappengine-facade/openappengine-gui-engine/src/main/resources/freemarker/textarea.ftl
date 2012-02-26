<#import "/spring.ftl" as spring/>

<#macro textarea>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	
	<textarea id="${.node["@id"]}" name="${.node["@name"]}" rows="${.node["@rows"]}" cols="${.node["@cols"]}">
		${.node}
	</textarea>
</#macro>