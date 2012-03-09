<#import "/spring.ftl" as spring/>

<#macro datepicker>
	<td>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
		<@common.message .node["@labelId"] />
	</label>
	</td>
	
	<td>
		<input id="${.node["@id"]}" name="${.node["@path"]}" type="text" value="${.node}" class="datepicker" 
			value = "<@common.evalXpathExpression widgetDataXml "path" />" />
	</td>
	<script type="text/javascript">
		jQuery(document).ready(function (){
			jQuery("#${.node["@id"]}").datepicker(
				{
					changeMonth: true,
					changeYear: true,
					dateFormat: dd/mm/yy
				}
			);
			
		});
	</script>	
</#macro>