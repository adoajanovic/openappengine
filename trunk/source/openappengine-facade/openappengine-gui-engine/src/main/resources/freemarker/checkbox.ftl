<#import "/spring.ftl" as spring/>

<#macro checkbox node>
	<!-- Add class="checkbox" to enable jquery checkbox -->
	<input type="checkbox" id="${node["@id"]}" name="${node["@name"]}" class="ui-widget ui-corner-all" />
</#macro>