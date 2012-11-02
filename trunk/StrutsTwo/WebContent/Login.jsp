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
	<s:textfield name="userName" key="label.userName" size="20" />
    <s:password name="passWord" key="label.passWord" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form> 
</body>
</html>