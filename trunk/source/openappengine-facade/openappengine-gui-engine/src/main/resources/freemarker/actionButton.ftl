<#import "/spring.ftl" as spring/>
<#import "common.ftl" as common />

<#macro actionButton>
	<td>
		<input type="submit" id="${.node["@id"]}" name="${.node["@action"]}" 
			value="${.node["@labelId"]}"
			class="ui-widget ui-corner-all" />
	</td>
</#macro>