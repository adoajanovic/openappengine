<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro evaluateValue fieldName>
	${valueEntity.get(fieldName)}
</#macro>

<#macro textfield>
	<td>
		<@common.displayLabel .node />
	</td>
	<td>
		<input type="text" id="${.node["@id"]}" name="${.node["@name"]}" 
			value = "<@common.evalXpathExpression widgetDataXml "path" />"
			class="ui-widget ui-corner-all" />
	</td>
	
	<script type="text/javascript">
		<!--  Add Error CSS Highlight JS here -->
		
	</script>	
</#macro>