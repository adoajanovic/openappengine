<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro textfield>
	<td>
	<#if .node["@labelId"]??>
		<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
			<@common.message .node["@labelId"] />
		</label>
	</#if>
	</td>
	<td>
		<input type="text" id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget ui-corner-all" />
	</td>
</#macro>