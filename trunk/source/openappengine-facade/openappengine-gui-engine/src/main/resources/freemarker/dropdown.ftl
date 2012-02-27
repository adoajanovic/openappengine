<#import "/spring.ftl" as spring/>

<#macro dropdown>
	<td>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	</td>
	
	<td>
	<select id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget">
		<#foreach child in .node?children>
			<option id="${child["@id"]}" value="${child["@value"]}">
				<@common.message child["@labelId"] />
			</option>
		</#foreach>
	</select>
	</td>
	
</#macro>