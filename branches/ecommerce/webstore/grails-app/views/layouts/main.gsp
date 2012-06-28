<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Grails" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="${resource(dir: 'images', file: 'favicon.ico')}"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
<link rel="apple-touch-icon" sizes="114x114"
	href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}"
	type="text/css">
<%--<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		--%>
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">

<!-- jquery -->
<link rel="stylesheet"
	href="${resource(dir: 'css/ui-lightness', file: 'jquery-ui-1.8.21.custom.css')}"
	type="text/css">
<link rel="stylesheet"
	href="${resource(dir: 'css/ui-lightness', file: 'jquery-ui.min.css')}"
	type="text/css">
<link rel="stylesheet"
	href="${resource(dir: 'css/ui-lightness', file: 'jquery.ui.menubar.css')}"
	type="text/css">

<script src="${resource(dir: 'js', file: 'jquery-1.7.2.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'jquery-ui.min.js')}"></script>
<script
	src="${resource(dir: 'js/external', file: 'jquery.bgiframe-2.1.2.js')}"></script>
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
<script
	src="${resource(dir: 'js/ui', file: 'jquery.ui.dataviewlocal.js')}"></script>
<script
	src="${resource(dir: 'js/ui', file: 'jquery.ui.autocomplete.js')}"></script>
<script src="${resource(dir: 'js/ui', file: 'jquery.ui.slider.js')}"></script>
<!-- jquery -->

<g:layoutHead />
<r:layoutResources />
</head>
<body>
	<div id="wrap">
		<div id="header" class="header">
			<div id="logo" class="logo">
				<a href="index.html"><img
					src="${resource(dir: 'images/site', file: 'logo.gif')}" alt=""
					title="" border="0" /></a>
			</div>

			<div id="user">
				<span class="division">
					<a class="user" href="#">
						<i class="icon-user icon-large"></i> <span>Sign In</span>
					</a>
				</span> 
				<span class="sep">|</span> 
				<span class="division"> 
					<a href="#"> <span>Wish List</span>
					</a>
				</span> 
				<span class="sep">|</span> 
				<span class="division"> 
					<a class="basket" href="#"> 
						<i class="icon-shopping-cart icon-large"></i> 
						<span>Basket</span>
					</a>
				</span> 
				<span class="sep">|</span> 
				<span class="division">Ship to:</span> 
				<span id="locselector" class="division"> 
					<a class="dropdown lang en-us" data-loadurl="/header/locale.html"
							data-target="#localeWindow"
							href="#"> 
						<span id="curFlag"></span>
						<span>English, USD</span> <span>
					</a>
				</span>
			</div>
		</div>

		<div class="center_content">
			<g:layoutBody />
		</div>

		<div class="footer">
			<div class="left_footer">
				<img src="${resource(dir: 'images/site', file: 'footer_logo.gif')}"
					alt="" title="" /><br /> <a
					href="http://csscreme.com/freecsstemplates/" title="free templates"><img
					src="${resource(dir: 'images/site', file: 'csscreme.gif')}"
					alt="free templates" title="free templates" border="0" /></a>
			</div>
			<div class="right_footer">
				<a href="#">home</a> <a href="#">about us</a> <a href="#">services</a>
				<a href="#">privacy policy</a> <a href="#">contact us</a>

			</div>
		</div>

		<div id="spinner" class="spinner" style="display: none;">
			<g:message code="spinner.alt" default="Loading&hellip;" />
		</div>
		<g:javascript library="application" />
		<r:layoutResources />
	</div>
</body>
</html>