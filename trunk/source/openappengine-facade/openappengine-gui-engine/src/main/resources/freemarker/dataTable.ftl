<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro column>
	<#recurse .node using namespace>
</#macro>

<#macro dataTable>
	<#local cols = .node.column?size?number>
	<form action="${currentURL}" method="post">
	<div class="ui-grid ui-widget ui-widget-content ui-corner-all">
		<table class="ui-grid-content ui-widget-content">
			<thead>
				<tr>
					<#foreach headerColumn in .node.header?children>
						<th class="ui-state-default">
							${headerColumn["@labelId"]}
						</th>
					</#foreach>
				</tr>
			</thead>
			<tbody>
				<#foreach child in .node.column>
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
			</tbody>
		</table>	
	</div>
	</form>
</#macro>