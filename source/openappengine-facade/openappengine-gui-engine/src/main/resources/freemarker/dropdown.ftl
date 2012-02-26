<#import "/spring.ftl" as spring/>


<#macro dropdown>
	<select id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget">
		<#foreach child in .node?children>
			<option id="${child["@id"]}" value="${child["@value"]}">
				<@common.message child["@labelId"] />
			</option>
		</#foreach>
	</select>
</#macro>