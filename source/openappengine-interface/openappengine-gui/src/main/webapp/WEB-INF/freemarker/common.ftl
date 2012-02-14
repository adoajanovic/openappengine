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