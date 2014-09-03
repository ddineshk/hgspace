<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<html:errors/>
<html:form action="/register" method="post">
	<h1>Register</h1>
	<table>
	<tr><td>First Name </td><td><html:text property="firstName" styleId="firstName"/></td></tr>
	<tr><td>Last Name </td><td><html:text property="lastName" styleId="lastName"/></td></tr>
	<tr><td>User Name </td><td><html:text property="userName" styleId="userName"/></td></tr>
	<tr><td>Password </td><td><html:password property="password" styleId="password"/></td></tr>
	<tr><td>Re-Enter Password </td><td><html:password property="rePass" styleId="rePass"/></td></tr>
	<tr><td>Email</td><td><html:text property="email" styleId="email"/></td></tr>
	<tr><td>Enter Captcha Image</td><td><img src="Captcha.jpg" border="0"></td></tr>
	<tr><td>&nbsp;</td><td><input type="text" name="j_captcha_response" size="20" maxlength="10"/></td></tr>
	<tr><td colspan="2"><button>Register</button></td></tr>
	</table>
	
</html:form>
</body>
</html>