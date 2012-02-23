<#import "/spring.ftl" as spring/>


<#macro radio node>
	<#foreach child in .node?children>
		<input type="radio" id="${node["@id"]}" name="${node["@name"]}" class="radio"/>
		<label for="${.node["@id"]}" id="${.node["@id"]}">
				<@message .node["@labelId"] />
		</label>
	</#foreach>
</#macro>