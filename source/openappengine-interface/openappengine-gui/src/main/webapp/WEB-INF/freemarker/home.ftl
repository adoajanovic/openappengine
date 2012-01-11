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
 	<#assign pageContent = uiRoot.pageContent >
 	<#assign widgets = pageContent.getWidgets() >
 	
 	<#list widgets as widget>
 		<#assign childWidgets = widget.getChildComponents() >
 		<#list widget.getChildComponents() as childWidget>
 			
 			<!-- FormSingleComponent -->
 			
 			<!-- Form Command Object -->
 			<#assign formCommand = childWidget.getFormCommand() >
 			
 			<!-- Form Values -->
 			<table>
 			<#list childWidget.getFormFields() as field>
 				<tr>
 				<td>
 				${field.property}
 				</td>
 				<td>
 				${childWidget.getFormCommandValue(field.property)?default("")}
 				</td>
 				</tr>
 			</#list>
 			</table>
 		</#list>
 	</#list>
 </div>
    
</body>
</html>