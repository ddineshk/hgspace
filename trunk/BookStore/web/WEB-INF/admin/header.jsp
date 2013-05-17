<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/books.css" />
<link rel="stylesheet" type="text/css" href="../css/displaytag.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
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

