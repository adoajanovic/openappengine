<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro password>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	<input id="${.node["@id"]}" name="${.node["@name"]}" type="password" value="${.node}" />
</#macro>