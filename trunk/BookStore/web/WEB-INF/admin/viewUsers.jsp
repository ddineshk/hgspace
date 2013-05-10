<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>View All Users</title>
</head>
<body>
	<%
   session = request.getSession(false);
   if(session.getAttribute("AdminName")==null){
	   response.sendRedirect("adminLogin.action");
   }
%>
	<h2 style="text-align: center;">Spring Book Sore</h2>
	<br />
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<h3>User List</h3>

	<p></p>
	<table width="80%" border="1">
		<tbody>
			<tr>
				<th>Id</th>
				<th>User Id</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Mobile</th>
				<th>Email</th>
			</tr>
			<s:iterator value="#session.users" status="listuser">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="userRealName" /></td>
					<td><s:property value="password" /></td>
					<td><s:property value="address" /></td>
					<td><s:property value="phone" /></td>
					<td><s:property value="mobilePhone" /></td>
					<td><s:property value="email" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>