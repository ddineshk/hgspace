<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Success: Upload User Image</title>
	</head>
	<body>
    	<h2>Struts2 File Upload Example</h2>
    	User Image: <s:property value="userImage"/>
    	<br/>
    	Content Type: <s:property value="userImageContentType"/>
    	<br/>
    	File Name: <s:property value="userImageFileName"/>
    	<br/>
    	Uploaded Image:
    	<br/>
    	<img src="<s:property value="userImageFileName"/>"/>
</body>
</html>