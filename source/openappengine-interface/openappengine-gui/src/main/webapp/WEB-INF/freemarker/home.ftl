<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<#import "/spring.ftl" as spring/>
<#import "/widgets.ftl" as gui/>

<body id="index">					
        
 <#if serverTime?exists>
	<div style="z-index: 99; position: absolute; left: 200px;">
	 <div class="message">${serverTime}</div>
	</div>
 </#if>			  	 	  
 
 <br/><br/>
 	
 <div id="main">
 
 	<!-- Message -->
	<#if successMessages?size!=0>
		<div class="success" >
		<ul style="margin-left:-35px;">
			<#list successMessages as message>
				<li>
					<div style="margin-left:34px;">	
						${message}
					</div>
				</li>	 
			</#list>
		</ul>	
		</div>
	</#if>
	
	<!-- Error Message -->
	<#if errorMessages?size!=0>
		<div class="success ui-state-error">
		<ul style="margin-left:-35px;">
			<#list errorMessages as message>
				<li>
					<div style="margin-left:34px;">	
						${message}
					</div>
				</li>	 
			</#list>
		</ul>	
		</div>
	</#if>
	
	<#assign widgetIds = guiEngineContext.getWidgets() >
 	
 	<#list widgetIds as widgetId>
 		<#assign widgetTemplateNode = guiEngineContext.getWidget(widgetId) >
 		<@gui.renderWidget widgetTemplateNode />
		<!-- Can be replaced with visit directive -->
 	</#list>
 </div>
	
  </script>   
</body>
</html>