<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro grid>
	<#local cols = .node["columns"] >
	<table>
	<#foreach child in .node?children>
		<tr>
			<td>
				<#visit child using .namespace />
			</td>	
		</tr>
	</#foreach>
	</table>
</#macro>