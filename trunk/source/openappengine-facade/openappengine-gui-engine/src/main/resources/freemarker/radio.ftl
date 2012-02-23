<#import "/spring.ftl" as spring/>


<#macro radio node>
	<#foreach child in .node?children>
		<!-- Use this to enable jquery class="radio" -->
		<input type="radio" id="${node["@id"]}" name="${node["@name"]}" value="${node["@value"]}"/>
		
		<label for="${.node["@id"]}" id="${.node["@id"]}">
				${node["@value"]}
		</label>
	</#foreach>
</#macro>