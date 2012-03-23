<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro textfield>
	<td>
		<@common.displayLabel .node />
	</td>
	<td>
		<#local field = .node["@path"]>
		<input type="text" id="${.node["@id"]}" name="${.node["@name"]}" 
			value = "<@common.evaluateValue values field />" class="ui-widget ui-corner-all" />
	</td>
	
	<script type="text/javascript">
		<!--  Add Error CSS Highlight JS here -->
		
	</script>	
</#macro>