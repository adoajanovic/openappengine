<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro grid>
	<#local cols = .node["@columns"]?number>
	<table>
	<#foreach child in .node?children>
		<#if child_index%cols = 0>
			<tr>
		</#if>
			<td>
				<#visit child using .namespace />
			</td>
		<#if child_index%cols= cols-1>
			</tr>
		</#if>
	</#foreach>
	</table>
</#macro>