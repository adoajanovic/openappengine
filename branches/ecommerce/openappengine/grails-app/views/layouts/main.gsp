<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery.ui.menubar.css')}" type="text/css">

		<link rel="stylesheet" href="${resource(dir: 'css/smoothness', file: 'jquery-ui-1.8.2.custom.css')}" type="text/css">
		<script src="${resource(dir: 'js', file: 'jquery-1.7.1.js')}"></script>
		<script src="${resource(dir: 'js/external', file: 'jquery.bgiframe-2.1.2.js')}"></script>
		<script src="${resource(dir: 'js/external', file: 'jquery.tmpl.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.core.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.widget.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.datepicker.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.widget.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.mouse.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.draggable.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.position.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.resizable.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dialog.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.button.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.observable.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dataview.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.grid.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dataviewlocal.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.autocomplete.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.slider.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.menu.js')}"></script>
		<script src="${resource(dir: 'js', file: 'jquery.validate.js')}"></script>
		<!-- TODO -- Template -->
		<script src="${resource(dir: 'js', file: 'jquery.tmpl.js')}"></script>
		<script src="${resource(dir: 'js', file: 'fg.menu.js')}"></script>
		<script src="${resource(dir: 'js', file: 'jquery-ui.min.js')}"></script>
		
		<style type="text/css">
			.hidden { position:absolute; top:0; left:-9999px; width:1px; height:1px; overflow:hidden; }
			#hierarchybreadcrumb {
				font: Tahoma;
				font-size: 10px;
			}
			.fg-button { background-color:#EEE;color:#666666;clear:left; margin:0 4px 40px 20px; padding: .4em 1em; text-decoration:none !important; 
							cursor:pointer; position: relative; text-align: center; zoom: 1; }
			.fg-button .ui-icon { position: absolute; top: 50%; margin-top: -8px; left: 50%; margin-left: -8px; }
			a.fg-button { float:left; color:#666666;  }
			button.fg-button { width:auto; overflow:visible; } /* removes extra button width in IE */
			
			.fg-button-icon-left { padding-left: 2.1em; }
			.fg-button-icon-right { padding-right: 2.1em; }
			.fg-button-icon-left .ui-icon { right: auto; left: .2em; margin-left: 0; }
			.fg-button-icon-right .ui-icon { left: auto; right: .2em; margin-left: 0; }
			.fg-button-icon-solo { display:block; width:8px; text-indent: -9999px; }	 /* solo icon buttons must have block properties for the text-indent to work */	
			
			.fg-button.ui-state-loading .ui-icon { background: url(../images/spinner_bar.gif) no-repeat 0 0; }
			.fg-menu-container {
				z-index: 999;
			}
		 </style>
		
		 <script type="text/javascript">    
		    $(function(){
		    	// BUTTONS
		    	$('.fg-button').hover(
		    		function(){ $(this).removeClass('ui-state-default').addClass('ui-state-focus'); },
		    		function(){ $(this).removeClass('ui-state-focus').addClass('ui-state-default'); }
		    	);
		    	
		    	// MENUS    	
				$('#hierarchybreadcrumb').menu({
					content: $('#hierarchybreadcrumb').next().html(),
					backLink: false,
					flyOut: true 
				});

				$("#menubar_ul").menubar({
                	menuIcon : true,
                	select : function(event, ui){
                		//$("#menubarStatusUpdater").text("'" + ui.item.text() + "' menubar item selected");
                	}
            	});
				$("#menubar_ul").after($("<p aria-live='polite' id='menubarStatusUpdater'>&nbsp;</p>"));
		    });
		  </script>
		
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		
		<div id="grailsLogo" role="banner">
			<sec:ifAnyGranted roles="ROLE_ADMIN">
				<div id="header_top_links" style="float:left;">
					
					<a tabindex="0" href="#news-items-2" class="fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all" id="hierarchybreadcrumb">
						<span class="ui-icon ui-icon-triangle-1-s"></span>Quick Links</a>
						<div id="news-items-2" class="hidden">
						<ul>
							<li><a href="#">Party</a>
								<ul>
									<li><a href="${createLink(controller:'person',action:'create')}">New</a></li>
									<li><a href="${createLink(controller:'person',action:'list')}">List</a></li>
								</ul>
							</li>
							<li><a href="#">Product</a>
							<ul>
								<li><a href="${createLink(controller:'product',action:'create')}">New</a></li>
								<li><a href="${createLink(controller:'product',action:'list')}">List</a></li>
							</ul>
							</li>
							<li><a href="#">Order</a>
								<ul>
									<li><a href="${createLink(controller:'order',action:'create')}">New Order</a></li>
								</ul>
							</li>
							</ul>
						</div>
				</div>
			</sec:ifAnyGranted>
			
			<div id="header_stat" style="float:right;margin-right: 1em;">
				<sec:ifNotLoggedIn>
				  <g:link controller="login" action="auth">Login</g:link>
				</sec:ifNotLoggedIn>
				<sec:ifLoggedIn>
				   Logged In as : <sec:username/> 
				   |<g:link controller="logout" style="color:#EEE;">sign out</g:link>
				</sec:ifLoggedIn>				
			</div>
		</div>
	
		<div id="menubar" style="float:left;">
			<ul id="menubar_ul" aria-label="Sample Options">
				<li><a href="#">Party</a>
					<ul aria-label="Party">
						<li><a href="#">New</a></li>
						<li><a href="#">List</a></li>
						<%--<li><a href="#">Recent Documents</a>
							<ul>
								<li><a href="#">Document 1</a></li>
								<li><a href="#">Document 2</a></li>
								<li><a href="#">Document 3</a></li>
								<li><a href="#">Continuous Web Accessibility Monitoring</a></li>
								<li><a href="#">Multimedia Transcription and Captioning</a></li>
							</ul>
						</li>
						--%>
					</ul></li>
				<li><a href="#">Order</a>
					<ul aria-label="Order">
						<li><a href="#">New</a></li>
						<li><a href="#">List</a></li>
					</ul>
				</li>
				<li><a href="#">Contract</a>
					<ul aria-label="Contract">
						<li><a href="#">New</a></li>
						<li><a href="#">List</a></li>
					</ul>
				</li>
			</ul>
		</div>
	
		<div id="body-content">
			<g:layoutBody/>
		</div>
		
		<div class="footer" role="contentinfo"></div>
		
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		
		<g:javascript library="application"/>
	    <r:layoutResources />
	    
		</body>
</html>