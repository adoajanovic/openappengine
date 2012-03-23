<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
<title>:: nedlowe.co.uk :: <decorator:title /> ::
</title>
</head>
<body>
	<div id="header">
		<a href="http://www.nedlowe.co.uk/">http://www.nedlowe.co.uk/</a>
	</div>
	<div id="main">
		<decorator:body />
	</div>
	<div id="footer">
		<center>
			:: openappengine :: 2011
		</center>
	</div>
</body>
</html>
