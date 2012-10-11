<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html:html>
<head>
<link rel="stylesheet" href="css/menuanim.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.js" ></script>
<script type="text/javascript" src="js/login.js" ></script>
<title>
<bean:message key="jsp.user.login.title"/>
</title>
</head>
<body onload="clearAll();">
<h1>
<bean:message key="jsp.user.login.title"/>
</h1>
<html:form action="UsersLoginAction.do" method="post">
<table>
	<%
	String value = (String)request.getSession().getAttribute("loginsuccess");
	if(value!=null && value.equals("false")){ 
	%>
	<tr><td colspan="3">Login Failed</td></tr>
	<% 
	}
	%>
    <tr>
      <td><bean:message key="jsp.user.login.username"/></td>
      <td><html:text property="users_Name"/></td>
      <td><font color="red"><html:errors property="nameerr"/></font></td>
    </tr>
    <tr>
      <td><bean:message key="jsp.user.login.userpwd"/></td>
      <td><html:password property="users_Pwd"/></td>
      <td><font color="red"><html:errors property="pwderr"/></font></td>
    </tr>
    <tr>
      <td colspan="3">
        <html:submit property="Submit"><bean:message key="jsp.user.login.loginbut"/></html:submit>
        <html:reset><bean:message key="jsp.user.login.rebut"/></html:reset>
        &nbsp;New User? <html:link href="#" onclick="openReg();"><bean:message key="jsp.user.login.reg"/></html:link> here
      </td>
    </tr>
  </table>
</html:form>
</body>
</html:html>
