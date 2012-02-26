<#import "/spring.ftl" as spring/>

<#macro checkbox>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	<!-- Add class="checkbox" to enable jquery checkbox -->
	<input type="checkbox" id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget ui-corner-all" />
</#macro>