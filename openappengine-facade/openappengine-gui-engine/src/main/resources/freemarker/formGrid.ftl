<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro formGrid>
	<#local cols = .node["@columns"]?number>
	<form action="${currentURL}" method="post">
	<table class="ui-widget-content ui-corner-all">
	<#if .node["@headerLabel"]?has_content>
			<thead>
				<tr class="ui-widget-header ui-widget-headerLabel ui-corner-all">
					<th colspan=${.node?children?size?number*2}>
						<div class="ui-widget-header ui-widget-headerLabel">
							${.node["@headerLabel"]}
						</div>
					</th>
				</tr>
			</thead>
	</#if>
	<tr style="margin-bottom:0.8em;">
		<td>
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
		</td>
	</tr>
	</table>
	</form>
</#macro>