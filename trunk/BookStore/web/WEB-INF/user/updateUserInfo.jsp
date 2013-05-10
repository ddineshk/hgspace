<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Update User Information</title>
</head>
<body>
	<% 
   session = request.getSession(false);
   if(session.getAttribute("user")==null ){
	   response.sendRedirect("userLogin.action");
   }

%>
	<jsp:include page="header.jsp" />
	<h3>User Information</h3>
	<s:form action="updateUserInfoForm">
		<s:textfield name="userRealName" label="Real Name" value="%{#session.user.userRealName}" />
		<s:textfield name="address" label="Address" value="%{#session.user.address}" />
		<s:textfield name="email" label="Email" value="%{#session.user.email}" />
		<s:textfield name="phone" label="Phone" value="%{#session.user.phone}" />
		<s:textfield name="mobilePhone" label="Mobile" value="%{#session.user.mobilePhone}" />
		<s:submit value="Submit" />
	</s:form>
</body>
</html>