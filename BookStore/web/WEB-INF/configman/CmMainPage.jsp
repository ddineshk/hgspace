<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuration Management</title>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/raphael.js"></script>
<script type="text/javascript" src="../js/jquery.enumerable.js"></script>
<script type="text/javascript" src="../js/jquery.tufte-graph.js"></script>
<link rel="stylesheet" href="../css/tufte-graph.css" type="text/css"
	media="screen" charset="utf-8" />

</head>
<body>
	<% 
	   session = request.getSession(false);
	   if(session.getAttribute("user")==null ){
		   response.sendRedirect("configmanLogin.action");
	   }
	%>
	<jsp:include page="cmheader.jsp" />
	
</body>
</html>