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
		<script src="${resource(dir: 'js', file: 'jquery-ui.min.js')}"></script>
		
		 <script type="text/javascript">    
		    $(function(){
		    	// BUTTONS
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
			<div id="header_stat" style="float: right; margin-right: 1em;">
				<sec:ifNotLoggedIn>
					<g:link controller="login" action="auth">Login</g:link>
				</sec:ifNotLoggedIn>
				<sec:ifLoggedIn>
					   Welcome : <sec:username /> 
					   |<g:link controller="logout" style="color:#EEE;">Log out</g:link>
				</sec:ifLoggedIn>
			</div>
		</div>

		<div style="float: left; font: Tahoma;margin-bottom: 1em;">
			<sec:ifAnyGranted roles="ROLE_ADMIN">
				<div id="menubar" style="float: left;">
					<ul id="menubar_ul" aria-label="Sample Options">
						<li><a href="#">Party</a>
							<ul aria-label="Party">
								<li><g:link controller="person" action="create">New Party</g:link>
								</li>
								<li><g:link controller="person" action="list">Find Party</g:link>
								</li>
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
								<li><g:link controller="order" action="create">New Order</g:link>
								</li>
								<li><g:link controller="order" action="list">View Orders</g:link>
								</li>
							</ul></li>
						<li><a href="#">Contract</a>
							<ul aria-label="Contract">
								<li><g:link controller="contract" action="create">New Contract</g:link>
								</li>
								<li><g:link controller="contract" action="list">View Existing Contract</g:link>
								</li>
								<li><g:link controller="contract" action="list">Terminate Existing Contract</g:link>
								</li>
							</ul></li>	
						<li><a href="#">Financials</a>
							<ul aria-label="Financials">
								<li><g:link controller="payment" action="list">View Payments</g:link>
								</li>
							</ul></li>	
					</ul>
				</div>
			</sec:ifAnyGranted>
		</div>

		<br/>
		<br/>
	
		<div id="body-content">
			<g:layoutBody/>
		</div>
		
		<div class="footer" role="contentinfo"></div>
		
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		
		<g:javascript library="application"/>
	    <r:layoutResources />
	    
		</body>
</html>