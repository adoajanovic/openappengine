<#import "/spring.ftl" as spring/>

<#macro radio node>
	<#foreach child in .node?children>
		<!-- Use this to enable jquery class="radio" -->
		<input type="radio" id="${child["@id"]}" name="${node["@path"]}" value="${child["@value"]}"/>
		
		<label for="${child["@id"]}" id="${child["@id"]}">
			${child["@label"]}
		</label>
	</#foreach>
</#macro>