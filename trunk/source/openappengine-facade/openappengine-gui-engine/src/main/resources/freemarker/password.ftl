<#import "/spring.ftl" as spring/>

<#macro password>
	<input id="${.node["@id"]}" name="${.node["@name"]}" type="password" value="${.node}" />
</#macro>