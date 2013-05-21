<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"
	import="com.model.Book,com.service.BookServiceImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Update Book Information</title>
</head>
<body>
<%session = request.getSession(false);if(session.getAttribute("AdminName")==null){response.sendRedirect("adminLogin.action");}%>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>Update Book Information</h3>
	<s:form action="updateBookInfoForm" method="POST" enctype="multipart/form-data">
		<s:textfield name="bookNumber" label="Book Number" value="%{#session.book.bookNumber}" />
		<s:textfield name="isbn" label=" ISBN" value="%{#session.book.isbn}" />
		<s:textfield name="bookName" label="Book Name" value="%{#session.book.bookName}" />
		<s:textfield name="author" label="Author" value="%{#session.book.author}" />
		<s:textfield name="bookPress" label="Book Press" value="%{#session.book.bookPress}" />
		<s:textfield name="language" label="Language" value="%{#session.book.language}" />
		<s:textfield name="price" label="Price" value="%{#session.book.price}" />
		<s:textfield name="pages" label="Pages" value="%{#session.book.pages}" />
		<s:textarea name="bookDiscription" label="Description" value="%{#session.book.bookDiscription}" />
		<s:file name="bookImageFile" label="Image File" />
		<s:textfield name="bookAmount" label="Amount" value="%{#session.book.bookAmount}" />
		<s:textfield name="bookSales" label="Sales" value="%{#session.book.bookSales}" />
		<s:submit value="Submit" />
	</s:form>
</body>
</html>