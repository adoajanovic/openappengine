<#import "/spring.ftl" as spring/>

<#macro datepicker>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	
	<input id="${.node["@id"]}" name="${.node["@name"]}" type="text" value="${.node}" class="datepicker"/>
</#macro>