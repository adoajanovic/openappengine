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

<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
<#macro message code>${messageContext.getMessageText(code)}</#macro>