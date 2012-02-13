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


<#macro renderWidget childWidget>
  <#assign widgetType = "formSingle" >
  <@formSingle childWidget />
</#macro>

<#macro formSingle childWidget>
	<!-- Form Command Object -->
 			<#if childWidget.formBackingObject()?has_content>
 			
 			<#assign formCommand = childWidget.formBackingObject()>
 			
 			<!-- Widget : form-single -->
	 			<form action="${currentURL}" method="post">
	 			
	 			<!-- Meta Model Attributes Used for Processing Widget Submits -->
	 			<input type="hidden" name="widgetId" value="${childWidget.getId()}" />
		 		<input type="hidden" name="widgetValueRef" value="${childWidget.getValueRef()}" />
		 		<input type="hidden" name="widgetTransition" value="${childWidget.getTransition()}" />
		 		<input type="hidden" name="widgetType" value="${childWidget.getWidgetType()}" />
		 		
	 			<fieldset>
		 			<table>
		 				<#foreach formField in formCommand.form.formfield>
		 					<@gui.formInputText formField.@type formField.@name childWidget.getId()+"."+formField.@name formField />
		 				</#foreach>
		 			
		 				<@gui.formSubmit childWidget.getId() childWidget.getId() 'OK' />
		 			</table>
	 			</fieldset>
	 			</form>
 				
 				<!-- Widget : form-single -->
 			
	 			<#else>
	 				<#if childWidget.formBackingObject()?has_content>
		 				<div>
			 				<fieldset>
			 					<form>
			 					<h4>
			 						No Record Found.
			 					</h4>
			 					</form>
			 				</fieldset>
		 				</div>
	 				</#if>
	 			</#if>
</#macro>