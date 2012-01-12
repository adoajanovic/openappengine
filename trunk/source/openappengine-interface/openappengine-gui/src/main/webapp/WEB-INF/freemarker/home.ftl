<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
 			
 			<@spring.bind formCommand.getClass().getName() />
 			
 			<!-- Form -->
 			<form name="${formCommand.class}_Form" action="" method="post">
	 			<fieldset>
	 			<table>
		 			<#list childWidget.getFormFields() as field>
		 				<tr>
			 				<td>
			 					<label>${field.property}</label>
			 				</td>
			 				<td>
		 						<input name="${field.property}" value="${childWidget.getFormCommandValue(field.property)}" />
			 				</td>
		 				</tr>
		 			</#list>
		 			<tr>
		 				<td>
		 					<input type="submit" name="${formCommand.class}" value="Submit"/>
		 				</td>
		 			</tr>
	 			</table>
	 			</fieldset>
 			</form>
 			<!-- Form -->
 			
 		</#list>
 	</#list>
 </div>
    
</body>
</html>