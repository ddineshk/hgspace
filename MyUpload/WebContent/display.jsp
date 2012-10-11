<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display the uploaded content</title>
</head>
<body>
	File uploaded to : <%= request.getAttribute("uploadedFilePath") %>
	<br/><br/>
	<a href="upload/<%= request.getAttribute("uploadedFileName") %>">
        Click here to download it</a>
</body>
</html>