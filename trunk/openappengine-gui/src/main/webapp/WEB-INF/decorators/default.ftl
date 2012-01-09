<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>

<#--NOTE: this is the webapp/decorators/spring.ftl-->
<#import "spring.ftl" as spring/>

<head>
  	  <!--default.ftl-->
	  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
	  
	  <!-- default css -->
	  <style type="text/css">@import "${rc.getContextPath()}/resources/css/styles.css";</style>
	  
	  <!-- jquery css and js -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/jquery/themes/base/jquery.ui.all.css">
	  <script src="${rc.getContextPath()}/resources/jquery/jquery-1.6.2.js"></script>
	  <script src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.position.js"></script>
	  <script src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.core.js"></script>
	  <script src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.widget.js"></script>
	  <script src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.button.js"></script>
	  <script src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.tabs.js"></script>
	  <script src="${rc.getContextPath()}/resources/jquery/ui/jquery.ui.dialog.js"></script>
	  
	  <script>
			$(function() {
				alert('Hi..');
			}
	  </script>
	  
	  <!-- Title -->
	  <title>
	  	${title}
	  </title>
	  
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
		        <!-- Header -->
		    	Header          
		      </div>
		      
		      <div  id="menu">
		        <!-- Menu -->
		      </div>
		        
		      <!-- Left Menu -->
		      <div  id="left-menu">
		       	<ul>
		       		<li><a href="#">A</a></li>
		       		<li><a href="#">B</a></li>
		       		<li><a href="#">C</a></li>
		       	</ul>
		      </div>
		            
			  <!--page-content-->
		      <div id="page-content">
		             ${body}      
		      </div>
		      
		      <!--footer-->
			  <div id="footer">
			      ©2008 <a href="<@spring.url "/site/index.html"/>">Index</a>
			      | <a href="<@spring.url "/site/contact.html"/>">Contact Us</a>
			      | <a href="http://blogger.com/">Blog</a>
			      | <a href="<@spring.url "/site/acknowledgements.html"/>">Acknowledgements</a>
			      <br>
			  </div>
		</div>
		<!--wrapper-->
	
		<#--Google Analytics-->    
		<script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script type="text/javascript">
		var pageTracker = _gat._getTracker("UA-1880676-2");
		pageTracker._initData();
		pageTracker._trackPageview();
		</script>
	</body>
</html>