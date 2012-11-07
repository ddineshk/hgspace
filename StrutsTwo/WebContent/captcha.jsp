<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Captcha Validation</title>
<style>
.errorMessage {
	color: red;
	font-size: 0.8em;
}

.label {
	color: #000000;
}
</style>
</head>
<body>
<s:form action="doCaptcha" method="POST">
	<s:actionerror /> 
	<img src="Captcha.jpg" border="0">
	<s:textfield label="Code" name="j_captcha_response" size="20" maxlength="10"/>
	<s:submit value="Verify" align="center" />
</s:form>
</body>
</html>