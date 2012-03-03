<#import "/spring.ftl" as spring/>

<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
<#macro message code>${messageContext.getMessageText(code)}</#macro>

<#macro evalXpathExpression dataDoc xpath>
	<#if .node["@" + xpath]?has_content>
		${dataDoc[.node["@" + xpath]]}<#t>
	</#if>
</#macro>