<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Book Details</title>
</head>
<body>
	<%
   session = request.getSession(false);
   if(session.getAttribute("AdminName")==null){
	   response.sendRedirect("adminLogin.action");
   }
%>

	<h2 style="text-align: center;">Spring Book Sore</h2>
	<br>

	<jsp:include page="header.jsp"></jsp:include>

	<h3>Book Details</h3>

	<img align="right" src=<s:property value = "imgPath"/>>
	<table align="center" cellpadding="5" cellspacing="15">
		<tr>
			<td>Book Name</td>
			<td><s:property value="book.bookName" /></td>
		</tr>
		<tr>
			<td>Book Type</td>
			<td><s:property value="book.bookType" /></td>
		</tr>
		<tr>
			<td>Author</td>
			<td><s:property value="book.author" /></td>
		</tr>
		<tr>
			<td>Press</td>
			<td><s:property value="book.bookPress" /></td>
		</tr>
		<tr>
			<td>Publish Date</td>
			<td><s:property value="book.publishDate" /></td>
		</tr>
		<tr>
			<td>Language</td>
			<td><s:property value="book.language" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><s:property value="book.price" /></td>
		</tr>
		<tr>
			<td>Pages</td>
			<td><s:property value="book.pages" /></td>
		</tr>
		<tr>
			<td>Book Description</td>
			<td><s:property value="book.bookDiscription" /></td>
		</tr>
	</table>
</body>
</html>