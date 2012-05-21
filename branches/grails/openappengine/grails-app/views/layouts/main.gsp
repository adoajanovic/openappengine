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

		<link rel="stylesheet" href="${resource(dir: 'css/smoothness', file: 'jquery-ui-1.8.2.custom.css')}" type="text/css">
		<script src="${resource(dir: 'js', file: 'jquery-1.7.1.js')}"></script>
		<script src="${resource(dir: 'js/external', file: 'jquery.tmpl.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.core.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.widget.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.button.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.observable.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dataview.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.grid.js')}"></script>
		<script src="${resource(dir: 'js/ui', file: 'jquery.ui.dataviewlocal.js')}"></script>
		<script src="${resource(dir: 'js', file: 'dataview-odata.js')}"></script>
		<script src="${resource(dir: 'js', file: 'jquery.validate.js')}"></script>
		
		<link rel="stylesheet" href="${resource(dir: 'css/jqwidgets', file: 'jqx.base.css')}" type="text/css">
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxcore.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxbuttons.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxscrollbar.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxmenu.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxgrid.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxgrid.selection.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxgrid.columnsresize.js')}"></script> 
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxdata.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'gettheme.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxmenu.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxtabs.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxbuttons.js')}"></script>
    	<script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxcheckbox.js')}"></script>
    	<script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxscrollbar.js')}"></script>
    	<script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxlistbox.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxwindow.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxpanel.js')}"></script>
	    <script type="text/javascript" src="${resource(dir: 'js/jqwidgets', file: 'jqxvalidator.js')}"></script>
	    
	    <script type="text/javascript">
            $(document).ready(function () {
                var theme = getTheme();
                // Create a jqxMenu
                $("#menubar").jqxMenu({ theme: theme });
                $("#menubar").css('visibility', 'visible');
                $("#menubar").jqxMenu('disable', 'fin', true);
            });
        </script> 
         
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<div id='menubar' style='visibility: hidden;'>
			<ul>
				<li><a href="#Home">Home</a></li>
				<li>Party
					<ul>
						<li><a href="/openappengine/person/create">New</a></li>
						<li><a href="/openappengine/person/list">List</a></li>
						<%--<li>Software Solutions
									<ul style='width: 220px;'>
										<li><a href="#ConsumerPhoto">Consumer photo and video</a></li>
										<li><a href="#Mobile">Mobile</a></li>
										<li><a href="#RIA">Rich Internet applications</a></li>
										<li><a href="#TechnicalCommunication">Technical
												communication</a></li>
										<li><a href="#Training">Training and eLearning</a></li>
										<li><a href="#WebConferencing">Web conferencing</a></li>
									</ul>
								</li>
								--%>
					</ul>
				</li>
				<li>Products
					<ul>
						<li><a href="#">New</a></li>
						<li><a href="#">List</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="grailsLogo" role="banner"><a href="http://grails.org"><img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/></a></div>
		<div id="body-content">
				<g:layoutBody/>
		</div>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
	    <r:layoutResources />
		</body>
</html>