<#import "/spring.ftl" as spring/>

<#macro textArea node>
	<#local val = node>
	<#local rows = node["@rows"]>
	<#local cols = node["@cols"]>
	
	<textarea id="${node["@id"]}" name="${node["@name"]}" rows="5" cols="20">
		${val}
	</textarea>
</#macro>