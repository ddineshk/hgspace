<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<html:form action="/login" method="post">
<html:errors/><br/>
	<label for="userName">Name     : </label><html:text styleId="userName" property="userName"></html:text><br/>
	<label for="password">Password : </label><html:password styleId="password" property="password"></html:password><br/>
	<button>Submit</button>&nbsp;<a href="register.jsp">Register</a>
</html:form>
</body>
</html>