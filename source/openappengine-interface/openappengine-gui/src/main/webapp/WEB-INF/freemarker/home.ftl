<html>
<#import "/spring.ftl" as spring/>
<head>
  <title>
  	Test
  </title>
</head>

<body id="index">					
        
 <#if serverTime?exists>
	<div style="z-index: 99; position: absolute; left: 200px;">
	 <div class="message">${serverTime}</div>
	</div>
 </#if>			  	 	  
 
 <br/><br/>
 	
 <div id="main">
 	Main Content
 	<#assign pageContent = uiRoot.pageContent >
 	<#assign widgets = pageContent.getWidgets() >
 	
 	<#list widgets as widget>
 		<#assign childWidgets = widget.getChildComponents() >
 		<#list widget.getChildComponents() as childWidget>
 			<!-- FormSingleComponent -->
 			<!--
 			<#assign entityValue = childWidget.getValue() >
 			-->
 			${childWidget.getFormCommand()}
 			<#list childWidget.getFormFields() as field>
 				${field}
 			</#list>
 		</#list>
 	</#list>
 </div>
    
</body>
</html>