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
					<#foreach headerColumn in .node.header.column>
						<th class="ui-state-default tableHeader">
							${headerColumn["@labelId"]}
						</th>
					</#foreach>
				</tr>
			</thead>
			<tbody>
				<#local tableXPath = .node["@path"]?string>
				<#foreach dataNode in widgetDataXml[tableXPath]>
					<#foreach dataColumn in .node.column>
						<#if dataColumn_index%cols = 0>
							<tr>
						</#if>
							<td>
								<#local columnXPath = dataColumn["@path"]?string>
								${dataNode[columnXPath]}
							</td>
						<#if dataColumn_index%cols= cols-1>
							</tr>
						</#if>
					</#foreach>	
				</#foreach>
			</tbody>
		</table>	
	</div>
	</form>
</#macro>