<!-- Box -->
<#macro box class id title>
	<div class="${class}">	  
	<h2>${title}</h2>
	  <div class="right"></div>
	  <div id="${id}" class="boxContent">		
		<#nested>		
	  </div>	  
	</div>
</#macro>

<!--
	InputText
-->
<#macro formInputText type name id value>
	<tr>
		<td>
			${name}
		</td>
		<td>
			<input id="${id}" type="${type}" name="${name}" value="${value}" class="ui-widget"/>
		</td>
	</tr>	
</#macro>

<#macro formSubmit name id value>
<tr>
	<td>
		<input type="submit" id="${id}"  name="${name}"  class="button ui-state-default ui-corner-all" value="${value}"/>
	</td>
</tr>
</#macro>