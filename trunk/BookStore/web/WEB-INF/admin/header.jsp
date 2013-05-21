<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/books.css" />
<link rel="stylesheet" type="text/css" href="../css/displaytag.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<div id="header">&nbsp;<%if(session.getAttribute("AdminName")!=null){String adminName = (String)session.getAttribute("AdminName");%>
	<h5 align="right" style="color: white;">
		Hello <%=adminName%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</h5><%}%>
	<h2 style="text-align: center;">Spring Book Store</h2>
	<br/>
</div>
<div id="menu">
	<ul>
		<li><s:a href="AdminMainPage.action">Admin Main Page</s:a></li>
		<li><s:a href="addBooksForm.action">Add Books</s:a></li>
		<li><s:a href="addBookTypesForm.action">Add Book type</s:a></li>
		<li><s:a href="viewBooks.action">View Books</s:a></li>
		<li><s:a href="adminViewAllOrder.action">View All Order</s:a></li>
		<li><s:a href="adminViewUsers.action">View All User</s:a></li>
		<li><s:a href="adminlogout.action">Logout</s:a></li>
	</ul>
</div>