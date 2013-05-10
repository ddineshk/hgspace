<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>New Book Type</title>
</head>
<body>
	<h2 style="text-align: center;">Spring Book Sore</h2>
	<br />

	<%
	   session = request.getSession(false);
	   if(session.getAttribute("AdminName")==null){
		   response.sendRedirect("adminLogin.action");
	   }
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>New Book Type form</h3>
	<s:form action="addBookTypes">
		<s:textfield name="bookType.bookType" label="New Book Type" />
		<s:submit />
		<s:reset></s:reset>
	</s:form>
</body>
</html>