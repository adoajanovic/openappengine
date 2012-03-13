<#import "/spring.ftl" as spring/>

<#macro datepicker>
	<td>
		<@common.displayLabel .node />
	</td>
	
	<td>
		<input type="text" id="${.node["@id"]}" name="${.node["@name"]}" class="datepicker" value = "<@common.evalXpathExpression widgetDataXml "path"/>"
			class="ui-widget ui-corner-all" />	
	</td>
	<script type="text/javascript">
		jQuery(document).ready(function (){
			jQuery("#${.node["@id"]}").datepicker(
					{
						changeMonth: true,
						changeYear: true
					}
			);
		});
	</script>	
</#macro>