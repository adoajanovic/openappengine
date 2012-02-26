<#import "/spring.ftl" as spring/>

<#macro textfield>
	<input id="${.node["@id"]}" name="${.node["@name"]}" type="text" value="${.node}" />
</#macro>