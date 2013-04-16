<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<html:errors/>
<html:form action="/AddEmp">
<br/>
<bean:message key="label.user.username" /> : 
<html:text property="username" size="20"/>
<br/>
<bean:message key="label.user.pwd" /> : 
<html:text property="pwd" size="20"/>
<br/>
<bean:message key="label.user.pwd2" /> : 
<html:text property="pwd2" size="20"/>
<br/>
<bean:message key="label.user.email" /> : 
<html:text property="email" size="20"/>
<br/><br/>
<html:submit>
<bean:message key="label.user.button.submit" />
</html:submit>
</html:form>
</body>
</html>