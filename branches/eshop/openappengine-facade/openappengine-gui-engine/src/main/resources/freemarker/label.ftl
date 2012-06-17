<#import "/spring.ftl" as spring/>

<#macro label>
	<input id="${.node["@id"]}" name="${.node["@name"]}" type="text" value="${.node}" />
</#macro>