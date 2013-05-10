<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Confirm the Order</title>
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
	<table border="1" style="width: 938px; height: 30px;">
		<tbody>
			<tr>
				<th style="width: 699px;">Book Titles</th>
				<th style="margin-left: -3px;">Unit Price</th>
				<th>Quantity</th>
			</tr>
			<s:iterator value="#session.selectbooks" status="listbook">
				<tr>
					<td><s:property value="bookName" /></td>
					<td><s:property value="price" /></td>
					<td><s:property value="bookAmount" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	Total Amount:
	<s:property value="#session.totalPrice" />
	<h3>Recipient Information</h3>
	<p></p>
	<table width="60%" border="1">
		<tbody>
			<tr>
				<th>Name of the Sender</th>
				<th>Home Phone</th>
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
	<s:a href="processOrder.action">Back to Order Edit</s:a>
	<s:a href="addOrder.action">Confirm Checkout</s:a>
</body>
</html>