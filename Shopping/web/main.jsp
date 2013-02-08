<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
 <link rel="stylesheet" href="css/jquery-ui.css" />
<script src="js/jquery-1.9.0.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>

 <script>
$(function() {
$( "#tabs" ).tabs();
});
</script>
</head>
<body>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Home</a><img alt="Home"
				src="images/home-icon.png" /></li>
			<li><a href="#tabs-2">Customers</a></li>
			<li><a href="#tabs-3">Products</a></li>
		</ul>
		<div id="tabs-1">
			<p>.</p>
		</div>
		<div id="tabs-2">
			<p>.</p>
		</div>
		<div id="tabs-3">
			<p>.</p>

		</div>
	</div>

</body>
</html>