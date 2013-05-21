<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Administrator Page</title>
<%
	   session = request.getSession(false);
	   if(session.getAttribute("AdminName")==null){
		   response.sendRedirect("adminLogin.action");
	   }
	%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p style="text-align: center;">
		<span style="font-weight: bold;"> Administrator Page</span><br />
	</p>
</body>
</html>