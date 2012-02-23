<#import "/spring.ftl" as spring/>

<#macro textField node>
	<#local val = node>
	<input id="${node["@id"]}" name="${node["@name"]}" type="text" value="${val}" />
</#macro>