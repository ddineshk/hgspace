<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DNash Systems</title>
</head>
<body>
	<center>
		<font size="+1">DNash System's Portal</font>
	</center>
	<br>
	<hr width="100%" noshade="noshade" />

	<bean:write name="helloWorldForm" property="message" />
	<br />
	<br /> &#149; <html:link href="languageselect.jsp">Language select</html:link>
	<br /> &#149; <html:link forward="search">Search an Employee</html:link>
	<br /> &#149; <html:link href="reg.do?method=load">Register Employee</html:link>
	<br /> &#149; <html:link href="EditUserAction.do?EditUser=EditUser">Edit User</html:link>
	<br /> &#149; <html:link href="DeleteUserAction.do?DeleteUser=DeleteUser">Delete User</html:link>
	<br />
</body>
</html>