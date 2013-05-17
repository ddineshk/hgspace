<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%@ taglib uri="http://displaytag.sf.net" prefix="display"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>View All Users</title>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#delete").on("click",function() {
		var ids = [];
		$('input[type=checkbox]').each(function () {
			var $this = $(this);
			if($this.is(":checked")){
				ids.push($this.attr("id"));
			}
		});
		alert(ids);
		
		
		$.ajax({
			 url: "delUsers",
			     type: "POST",
			     data: "data="+ids,
			     error: function(XMLHttpRequest, textStatus, errorThrown){
			         alert('Error ' + textStatus);
			         alert(errorThrown);
			         alert(XMLHttpRequest.responseText);
			     },
			     success: function(data){
			    	 alert(data);
			         alert('SUCCESS');

			        }

			 }); 
		
	});
});

</script>
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
	<%-- <display:table id="users" name="${users}" pagesize="5" export="true" requestURI="adminViewUsers">
		<display:column property="id" title="Id" sortable="true"/>
		<display:column property="name" title="User Id" sortable="true"/>
		<display:column property="userRealName" title="User Name" sortable="true"/>
		<display:column property="password" title="Password" sortable="true"/>
		<display:column property="address" title="Address" sortable="true"/>
		<display:column property="phone" title="Phone" sortable="true"/>
		<display:column property="mobilePhone" title="Mobile" sortable="true"/>
		<display:column property="email" title="Email" sortable="true"/>
		<display:column value="<input type='checkbox' id='check${users.id}' />" title="Delete"/>
	</display:table> --%>
	<button id="delete" >Delete</button>
</body>
</html>