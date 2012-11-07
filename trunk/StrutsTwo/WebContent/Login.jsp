<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h3>Login Application</h3>
<s:actionerror/>
<s:form action="login.action" method="post">
	<table>
	<tr><td><s:textfield name="userName" key="label.userName" size="20" /></td></tr>
	<tr><td><s:password name="passWord" key="label.passWord" size="20" /></td></tr>
	<tr><td><img src="Captcha.jpg" border="0"></td></tr>
	<tr><td><s:textfield label="Code" name="j_captcha_response" size="20" maxlength="10"/></td></tr>
	<tr><td><s:submit method="execute" key="label.login" align="center" /></td></tr>
	</table>
    
</s:form> 
</body>
</html>