<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<link rel="stylesheet" type="text/css" href="../css/books.css" />
<title>Administrator Login</title>
</head>
<body style="background: url('../images/graph.png');background-repeat: repeat;">
	<h3 align="center">Administrator Login</h3>
	<a href="/BookStore/index.jsp">Home</a>
	<br>
	<br>
	<br>
	<center>
		<s:form action="adminLoginAction">
			<s:textfield name="name" label="User Name" />
			<s:password name="password" label="Password" />
			<s:submit value="Submit" />
		</s:form>
	</center>
</body>
</html>