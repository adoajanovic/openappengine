<#import "/spring.ftl" as spring/>

<#macro dropdown>
	<td>
		<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
			<@common.message .node["@labelId"] />
		</label>
	</td>
	
	<td>
		<select id="${.node["@id"]}" name="${.node["@path"]}" class="ui-widget">
			<#if .node["@path"]?has_content>
				<#local val = widgetDataXml[.node["@path"]]?trim>
			</#if>
			<#foreach child in .node.option>
				<option id="${child["@id"]?string}" value="${child["@value"]}"
					<#if val == child["@value"]>selected = "selected"</#if>	>
					<@common.message child["@labelId"] />
				</option>
			</#foreach>
		</select>
	</td>
	
</#macro>