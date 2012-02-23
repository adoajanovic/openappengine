<#import "/spring.ftl" as spring/>

<#macro password node>
	<#local val = node>
	<input id="${node["@id"]}" name="${node["@name"]}" type="password" value="${val}" />
</#macro>