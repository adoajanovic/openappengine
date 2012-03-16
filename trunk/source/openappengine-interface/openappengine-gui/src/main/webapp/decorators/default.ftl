<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>

<#--NOTE: this is the webapp/decorators/spring.ftl-->
<#import "spring.ftl" as spring/>

<head>
  	  <!--default.ftl-->
	  <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
	  
	  <!-- default css -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/css/styles.css">
	  
	  <style type="text/css" media="screen">
        <!--
       .drawers-wrapper {
            position: relative;
            width: 188px;
            
        }

        .drawer {
            background:transparent url(http://images.apple.com/downloads/images/sideboxlight_bg20070611.gif) repeat-y scroll 0pt;
            color:#76797C;
            font-size:11px;
            line-height:1.3em;
        }

        .boxcap {
            height:5px;
            left:0pt;
            position:absolute;
            width:100%;
            z-index:100;
            background:transparent url(http://images.apple.com/downloads/images/sidenav_capbottom.png) no-repeat scroll 0%;
            margin-top:-5px;
        }

        .captop {
            background-image:url(http://images.apple.com/downloads/images/box_188captop.png);
            bottom:auto;
            top:0pt;
            margin-top:0;
        }

        .drawers {
            margin-bottom:15px;
            color:#76797C;
            font-size:11px;
            line-height: 18px;
        }

        .drawers A {
            color:#666666;
            text-decoration:none;
            font-family:"Lucida Grande",Geneva,Arial,Verdana,sans-serif;
            font-size-adjust:none;
            font-style:normal;
            font-variant:normal;
            font-weight:normal;
        }

        .drawer li {
            border-bottom:1px solid #E5E5E5;
            line-height:16px;
            padding:6px 0pt;
        }

        UL {
            list-style: none;
            padding: 0;
        }

        UL.drawers {
            margin: 0;
        }

        .drawer-handle {
            background:#939393 url(http://images.apple.com/downloads/images/slider_handlebg188.png) no-repeat scroll 0pt;
            color:#333333;
            cursor:default;
            font-size:12px;
            font-weight:normal;
            height:25px;
            line-height:25px;
            margin-bottom:0pt;
            text-indent:15px;
            width:100%;
        }

        .drawer-handle.open {
            background-color:#72839D;
            background-position:-188px 0pt;
            color:#FFFFFF;
        }

        .drawer UL {
            padding: 0 12px;
            padding-bottom:0pt;
        }

        .drawer-content UL {
            padding-top: 7px;
        }

        .drawer-content LI A {
            display:block;
            overflow:hidden;
        }

        .alldownloads li {
            border:0pt none;
            line-height:18px;
            padding:0pt;
        }
        -->
        </style>
	  
	  <!-- FavIcon -->
	  <link rel="shortcut icon" href="${rc.getContextPath()}/resources/favicon.ico" type="image/x-icon" />
	  
	  <!-- jquery css and js -->
	  <link rel="stylesheet" href="${rc.getContextPath()}/resources/jquery/themes/base/jquery.ui.all.css">
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/jquery-1.6.2.js"></script>
	  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.pack.js"></script>
	  <script type="text/javascript" src="${rc.getContextPath()}/resources/jquery/jquery.loadmask.js"></script>
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