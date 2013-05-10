<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Order Information</title>
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
	<br>
	<br>
	<br>
	<h3>Order Information</h3>
	<table border="1" style="width: 938px; height: 30px;">
		<tbody>
			<tr>
				<th style="width: 699px;">Book Name</th>
				<th style="margin-left: -3px;">Price</th>
				<th>Amount</th>
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
	<h3>Recipient Information </h3>
	<table width="60%" border="1">
		<tbody>
			<tr>
				<th>Real Name</th>
				<th>Phone</th>
				<th>Mobile</th>
				<th>Address</th>
				<th>Email</th>
			</tr>
			<tr>
				<td><s:property value="#session.singleOrders.user.userRealName" /></td>
				<td><s:property value="#session.singleOrders.user.phone" /></td>
				<td><s:property value="#session.singleOrders.user.mobilePhone" /></td>
				<td><s:property value="#session.singleOrders.user.address" /></td>
				<td><s:property value="#session.singleOrders.user.email" /></td>
			</tr>
		</tbody>
	</table>
</body>
</html>