<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
	<%
        String message = (String)request.getAttribute("message");
    %>
    <h1>Welcome <%= message %></h1><br/><hr>
	<h3>
		<bean:message key="label.common.title" />
	</h3>
	<html:messages id="err_name" property="common.file.err">
		<div style="color: red">
			<bean:write name="err_name" />
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.ext">
		<div style="color: red">
			<bean:write name="err_name" />
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.size">
		<div style="color: red">
			<bean:write name="err_name" />
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.invalid">
		<div style="color: red">
			<bean:write name="err_name"/>
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.execption">
		<div style="color: red">
			<bean:write name="err_name"/>
		</div>
	</html:messages>
	<html:form action="/Upload" method="post" enctype="multipart/form-data">
		<br/>
		<bean:message key="label.common.file.label" /> : 
		<html:file property="formFile" size="50" />
		<br/>
		<br/>
		<html:submit>
			<bean:message key="label.common.button.submit" />
		</html:submit>
	</html:form>
</body>
</html>