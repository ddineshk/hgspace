<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="shortcut icon" href="../images/favicon.ico">
<link rel="stylesheet" type="text/css" href="../css/displaytag.css" />
<link rel="stylesheet" type="text/css" href="../css/books.css"/>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<%@ page import="com.model.User" %>
<div id="header">&nbsp;<%if(session.getAttribute("user")!=null){User user = (User)session.getAttribute("user");%>
	<h5 align="right" style="color: white;">
	Hello <%=user.getUserRealName()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</h5><%}%>
<h2 style="text-align: center;">Spring Book Store</h2>
<br/>
</div>
<div id="menu">
	<ul>
		<li><s:a href="UserMainPage.action">Main Page</s:a></li>
		<li><s:a href="userViewBooks.action">Browse Books</s:a></li>
		<li><s:a href="userQueryAllOrder.action">View Order History</s:a></li>
		<li><s:a href="updateUserInfo.action">Update User Information</s:a></li>
		<li><s:a href="userLogout.action">Logout</s:a></li>
	</ul>
</div>