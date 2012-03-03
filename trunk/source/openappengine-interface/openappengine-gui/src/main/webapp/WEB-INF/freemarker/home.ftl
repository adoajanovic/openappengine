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
		<div class="success">
		<!--	
		<span class="ui-icon ui-icon-trash">
		</span>
		-->
		
		<ul>
			<#list successMessages as message>
				<li>
					<div style="margin-left:18%;">	
						${message}
					</div>
				</li>	 
			</#list>
		</ul>	
		</div>
	</#if>
	
	<!-- Error Message -->
	<#if errorMessages?size!=0>
		<div class="success">
		<ul>
			<#list errorMessages as message>
				<li>
					<div style="margin-left:18%;">	
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