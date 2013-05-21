<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="css/books.css"/>
	<meta content="text/html; charset=UTF8" http-equiv="content-type">
		<title>index</title>
		<style type="text/css">
		 a {
		 	text-decoration: none;
		 	color: black;
		 }
		 .hdiv{
		 	width: 100px;
		 }
		</style>
		<script type="text/javascript" src="js/jquery-1.9.1.js"></script>	
		<script type="text/javascript">
		$(document).ready(function(){
			$(".hdiv").hover(function() {
				$(this).stop(true, false).animate({ width: "150px" });
			}, function() {
				$(this).stop(true, false).animate({ width: "100px" });
			});
		});
		</script>
	</head>
	<body style="background: url('images/graph.png');background-repeat: repeat;">
		<a href="http://www.springsource.org/">
			<!-- <img style="border: 0px solid; width: 1221px; height: 130px;" src="images/banner4.jpg" alt=""> -->
			<img style="border: 0px solid;" src="images/banner4.jpg" alt=""></a>
		<br/><br/>
		<div>
			<div class="hdiv" style="background: #ccc;"><s:a href="user/userLogin.action">Login</s:a></div>
			<div class="hdiv" style="background: #999;"><s:a href="user/register.action">Register</s:a></div>
			<div class="hdiv" style="background: #666;"><s:a href="admin/adminLogin.action">Admin Login</s:a></div>
		</div>
	</body>
</html>
