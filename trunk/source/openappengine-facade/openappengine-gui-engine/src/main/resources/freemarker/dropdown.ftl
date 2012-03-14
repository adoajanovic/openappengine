<#import "/spring.ftl" as spring/>

<#macro dropdown>
	<td>
		<@common.displayLabel .node />
	</td>
	
	<td>
		<select id="${.node["@id"]}" name="${.node["@name"]}" class="ui-widget">
			<#local field = .node["@name"]>	
			<#local val = "<@common.evaluateValue values field />">
			<#foreach child in .node.option>
				<option id="${child["@id"]?string}" value="${child["@value"]}"
					<#if val == child["@value"]>selected = "selected"</#if>	>
					<@common.message child["@labelId"] />
				</option>
			</#foreach>
		</select>
	</td>
	
</#macro>