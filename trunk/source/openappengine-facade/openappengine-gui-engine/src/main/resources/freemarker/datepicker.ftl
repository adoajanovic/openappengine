<#import "/spring.ftl" as spring/>

<#macro datepicker node>
	<#local val = node>
	<input id="${node["@id"]}" name="${node["@name"]}" type="text" value="${val}" class="datepicker"/>
</#macro>