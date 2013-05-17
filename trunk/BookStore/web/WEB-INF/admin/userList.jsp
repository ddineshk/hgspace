<%@ taglib uri="/struts-tags" prefix="s"%>
<table border="1">
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
				<th>Delete</th>
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
					<td><input type="checkbox" id='<s:property value = "id"/>' /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>