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
		<script src="${resource(dir: 'js', file: 'pager.js')}"></script>
		<script src="${resource(dir: 'js', file: 'dataview-odata.js')}"></script>
		
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
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