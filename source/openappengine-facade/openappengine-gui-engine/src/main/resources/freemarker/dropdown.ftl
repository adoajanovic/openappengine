<#import "/spring.ftl" as spring/>


<#macro dropdown node>
	<select id="${node["@id"]}" name="${node["@name"]}" class="ui-widget">
		<#foreach child in .node?children>
			<!-- Use this to enable jquery class="radio" -->
			<option id="${child["@id"]}" value="${child["@value"]}">
				${child["@label"]}
			</option>
		</#foreach>
	</select>
</#macro>