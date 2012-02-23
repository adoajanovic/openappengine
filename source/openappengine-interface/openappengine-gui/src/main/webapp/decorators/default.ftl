<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>

<#--NOTE: this is the webapp/decorators/spring.ftl-->
<#import "spring.ftl" as spring/>

<head>
  	  <!--default.ftl-->
	  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
	  
	  <!-- default css -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/css/styles.css">
	  
	  <!-- FavIcon -->
	  <link rel="shortcut icon" href="${rc.getContextPath()}/resources/favicon.ico" type="image/x-icon" />
	  
	  <!-- jquery css and js -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/jquery/themes/base/jquery.ui.all.css">
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/jquery-1.6.2.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.position.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.core.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.widget.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.button.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.tabs.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dialog.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.datepicker.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.accordian.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dimensions.js"></script>
	  
	  <!-- Title -->
	  <title>
	  	${title}
	  </title>
	  
	  <script type="text/javascript">
	  jQuery(document).ready(function (){
			//Trim Whitespaces from Text Area.
			jQuery("textarea").val(function(i,v){
	    		return v.replace(/\s+/g,' ').replace(/>(\s)</g,'>\n<');
			}); 
			
			jQuery("textarea").addClass('ui-widget');
			
			jQuery(".datepicker").datepicker();
			
			$(function() {
				jQuery(".checkbox" ).button();
			});
			
			$(function() {
				jQuery(".radio" ).button();
			});
	  	 }
	  	);
	  	
	  <!-- head -->
	  ${head}
	  
	  
	</head>

	<#--
	Freemarker SiteMesh properties extraction from:
	http://jdwyah.blogspot.com/2006/04/freemarker-sitemesh-body-onload.html
	
	See the very slick use of the ID property to highlight the menu tabs with css:
	http://www.dehora.net/journal/2007/08/tab_switching_with_sitemesh.html
	-->
	<body onload="${page.properties["body.onload"]?default("")}"  id="${page.properties["body.id"]?default("")}">
		
		<!--wrapper-->
		<div id="wrapper">
		        
		      <div id="header">
		 		
		 		<div class="top-right-content">
		 			<label>Logged In Time :</label> ${serverTime} |
		 		</div>
		      </div>
		      
		      <div  id="menu">
		        <!-- Menu -->
		      </div>
		        
		      <!-- Left Menu -->
		      <div  id="left-menu">
		       	<#include "left-navigation.ftl" />
		      </div>
		            
			  <!--page-content-->
		      <div id="page-content">
		             ${body}      
		      </div>
		      
		      <!--footer-->
			  <div id="footer">
			      ©2011 <a href="<@spring.url "/site/index.html"/>">Index</a>
			      | <a href="<@spring.url "/site/contact.html"/>">Contact Us</a>
			      | <a href="http://blogger.com/">Blog</a>
			      | <a href="<@spring.url "/site/acknowledgements.html"/>">Acknowledgements</a>
			      <br>
			  </div>
		</div>
	<!--wrapper-->
		
	<script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/openappengine.ui.default.js"></script>
		
	</body>
	
	
</html>