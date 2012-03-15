<#import "/spring.ftl" as spring/>

<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
<#macro message code>${messageContext.getMessageText(code)}</#macro>

<#macro writePath node path>
	<#local root = node?root >
	${root.metadata.widgetId?string} + ${path}
</#macro>

<#macro evaluateValue values fieldName defaultValue="">
	<#if values[fieldName]??>
		${values[fieldName]}<#t>
	<#else>
		${defaultValue}<#t>	
	</#if>
</#macro>

<#macro evalXpathExpression dataDoc xpath>
	<#if .node["@" + xpath]?has_content>
		${dataDoc[.node["@" + xpath]]}<#t>
	</#if>
</#macro>

<#macro displayLabel node>
	<label id="${.node["@id"]}_Label" for="${.node["@id"]}">
			<@message .node["@labelId"] />
	</label>
</#macro>