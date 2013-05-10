<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Your Order History</title>
</head>
<body>
	<% 
   session = request.getSession(false);
   if(session.getAttribute("user")==null){
	   response.sendRedirect("userLogin.action");
   }

%>
	<jsp:include page="header.jsp" />
	<br>
	<h3>Order History</h3>
	<br>
	<table style="width: 938px; height: 30px;">
		<tbody>
			<tr>
				<th style="width: 342px;">Order Number</th>
				<th style="margin-left: -464px;">Orders</th>
				<th>Total Amount</th>
				<th>Order Status</th>
			</tr>

			<s:iterator value="#session.orders" status="listorders">
				<tr>
					<td><s:url action="userQueryOrderDetail.action" var="URLtag">
							<s:param name="id"><s:property value="id" /></s:param>
						</s:url> <s:a href="%{URLtag}"><s:property value="id" /></s:a></td>
					<td><s:date name="orderTime" /></td>
					<td><s:property value="totalPrice" /></td>
					<td><s:if test='%{isDealed =="0"}'>
							<font style="color: green;">Untreated</font>
							<s:url action="userDeleteUnProcessOrder.action" var="URLtag">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
							</s:url>

							<s:a href="%{URLtag}">Delete Orders</s:a>

						</s:if> <s:else>
							<font style="color: red;">Order is Processed</font>
						</s:else></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>