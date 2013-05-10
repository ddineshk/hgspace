<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Order Details</title>
</head>
<body>
	<% 
	   session = request.getSession(false);
	   if(session.getAttribute("user")==null ){
		   response.sendRedirect("userLogin.action");
	   }
	%>
	<jsp:include page="header.jsp" />
	<h3>Order Information</h3>
	<table style="width: 938px; height: 30px;">
		<tbody>
			<tr>
				<th style="width: 699px;">Book Titles</th>
				<th style="margin-left: -3px;">Unit Price</th>
				<th>Quantity</th>
			</tr>
			<s:iterator value="#session.orderBooks" status="listbook">
				<tr>
					<td><s:property value="book.bookName" /></td>
					<td><s:property value="book.price" /></td>
					<td><s:property value="book.bookAmount" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	Total Amount:
	<s:property value="totalPrice" />
	<h3>Recipient Information</h3>
	<table width="60%" border="1">
		<tbody>
			<tr>
				<th>User Name</th>
				<th>Phone Number</th>
				<th>Mobile</th>
				<th>Home Address</th>
				<th>Email</th>
			</tr>
			<tr>
				<td><s:property value="#session.user.userRealName" /></td>
				<td><s:property value="#session.user.phone" /></td>
				<td><s:property value="#session.user.mobilePhone" /></td>
				<td><s:property value="#session.user.address" /></td>
				<td><s:property value="#session.user.email" /></td>
			</tr>
		</tbody>
	</table>
</body>
</html>