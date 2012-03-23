<#import "/spring.ftl" as spring/>

<#macro radio node>
	<#foreach child in .node?children>
		<!-- Use this to enable jquery class="radio" -->
		<input type="radio" id="${child["@id"]}" name="${node["@name"]}" value="${child["@value"]}"/>
		
		<@common.displayLabel child />
	</#foreach>
</#macro>