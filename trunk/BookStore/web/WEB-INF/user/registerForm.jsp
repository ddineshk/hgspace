<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<link rel="stylesheet" type="text/css" href="../css/books.css"/>
<title>Registration User</title>
</head>
<body style="background: url('../images/graph.png');background-repeat: repeat;">
	<h3 align="center">Registration Form</h3>
	<a href="/BookStore/index.jsp">Home</a>
	<br>
	<br>
	<center>
		<s:form action="registerAction">
			<s:textfield name="user.name" label="User Name"></s:textfield>
			<s:textfield name="user.userRealName" label="Real Name"></s:textfield>
			<s:password name="user.password" label="Password"></s:password>
			<s:textfield name="user.address" label="Address"></s:textfield>
			<s:textfield name="user.email" label="Email"></s:textfield>
			<s:textfield name="user.phone" label="Phone "></s:textfield>
			<s:textfield name="user.mobilePhone" label="Mobile"></s:textfield>
			<s:submit value="Submit"></s:submit>
		</s:form>
	</center>
</body>
</html>