<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<#import "/spring.ftl" as spring/>
<#import "common.ftl" as gui/>
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
	
	<#assign pageContent = uiRoot.pageContent >
 	<#assign widgets = pageContent.getWidgets() >
 	
 	<#list widgets as widget>
 		<#assign childWidgets = widget.getChildComponents() >
 		<#list widget.getChildComponents() as childWidget>
 			
 			<!-- Get WidgetType -->
 			
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
		 					<@gui.formInputText formField.@type formField.@name formField.@name formField />
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
 			
 		</#list>
 	</#list>
 </div>
  <script>
  	
  	/* attach a submit handler to the form */
  	jQuery("form").submit(function() {
	   
	    /* stop form from submitting normally*/ 
	    	event.preventDefault(); 
	    
	        
	    /* get some values from elements on the page: */
	    var $form = $( this ),
	    
	    /* Get the url for form submit. */
	    urlAction = $form.attr( 'action' );
	
	    /* Send the data using post and put the results in a div */
	    $.ajax( {
	      type: "POST",
	      url: urlAction,
	      success: function() {
	        /*$('#contact_form').html("<div id='message'></div>");*/
	        
	      }
	    });
	   
  	   return true;
	});
	
  </script>   
</body>
</html>