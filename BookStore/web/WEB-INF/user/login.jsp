<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/books.css"/>
<meta http-equiv="Content-Type" content="text/html;">
<title>Login</title>
<style type="text/css">
		 a {
		 	text-decoration: none;
		 	color: black;
		 }
		 .hdiv{
		 	height: 30px;
		 	width: 100px;
		 }
</style>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>	
<script type="text/javascript">
$(document).ready(function(){
	$(".hdiv").hover(function() {
		$(this).stop(true, false).animate({ width: "150px" });
		
		if($("#home:has(img)").length > 0){
		}else{
			$('#home').append('<img src="../images/home.gif" style="vertical-align:middle" />');
		}
	}, function() {
		$(this).stop(true, false).animate({ width: "100px" });
		if($("#home:has(img)").length > 0){
			$("img").remove();			
		}
	});
});
</script>
</head>
<body style="background: url('../images/graph.png');background-repeat: repeat;">
	<h3 align="center">User Login</h3>
	<br/>
	<div class="hdiv" style="background: #ccc;"><a href="/BookStore/index.jsp"><span id="home">Home</span></a></div>
	<br>
	<center>
		<s:form action="userLoginAction">
			<s:textfield name="name" label="User Name" />
			<s:password name="password" label="Password" />
			<s:submit value="Submit" />
		</s:form>
	</center>
</body>
</html>