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
 			
 			<#if childWidget.formBackingObject()??>
 				
 			<#assign formCommand = childWidget.formBackingObject()>
 			
 			<!-- Form -->
 			<form name="${formCommand.class}_Form" action="${springMacroRequestContext.getContextPath()}/action/${childWidget.getId()}" method="post">
	 			<fieldset>
	 			<table>
		 			<#list childWidget.getFormFields() as field>
		 				<#assign property=childWidget.getId()+"."+field.property />
		 				<tr>
			 				<td>
			 					<label>${field.property}</label>
			 				</td>
			 				<td>
			 					<@spring.formInput property/>			
			 				</td>
		 				</tr>
		 			</#list>
		 			<tr>
		 				<td>
		 					<input type="hidden" name="formBackingClass" value="${formCommand.getClass().getName()}" />
		 					
		 					<input type="submit" name="${formCommand.class}" value="Submit"/>
		 				</td>
		 			</tr>
	 			</table>
	 			</fieldset>
 			</form>
 			<!-- Form -->
 			
 			<#else>
 				<fieldset>
 					<h3>
 						Entity Not found..!
 					</h3>
 				</fieldset>
 			
 			</#if>
 			
 		</#list>
 	</#list>
 </div>
    
</body>
</html>