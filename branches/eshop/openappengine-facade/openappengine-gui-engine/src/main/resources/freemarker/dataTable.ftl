<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro column>
	<#recurse .node using namespace>
</#macro>

<#macro dataTable>
	<#local cols = .node.column?size?number>
	<form action="${currentURL}" method="post">
	<div class="ui-grid ui-widget ui-corner-all">
		<table class="ui-grid-content ui-widget-content ui-corner-all">
			<thead>
				<tr class="ui-widget-header ui-widget-headerLabel ui-corner-all">
					<#foreach headerColumn in .node.header.column>
						<th class="ui-widget-content ui-widget-header ui-widget-headerLabel">
							<a href="#">
							${headerColumn["@labelId"]}
							</a>
						</th>
					</#foreach>
				</tr>
			</thead>
			<tbody class="tableBody">
				<#local tableXPath = .node["@path"]?string>
				<#if widgetDataXml[tableXPath]??>
					<#foreach dataNode in widgetDataXml[tableXPath]>
						<#foreach dataColumn in .node.column>
							<#if dataColumn_index%cols = 0>
								<tr class="ui-widget-content">
							</#if>
								<td class="ui-grid-content">
									<#local columnXPath = dataColumn["@path"]?string>
									${dataNode[columnXPath]}
								</td>
							<#if dataColumn_index%cols= cols-1>
								</tr>
							</#if>
						</#foreach>	
					</#foreach>
				</#if>
			</tbody>
		</table>	
	</div>
	</form>
</#macro>