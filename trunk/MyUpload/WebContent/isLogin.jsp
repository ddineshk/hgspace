<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.getSession().setAttribute("url",request.getRequestURI());
%>
<c:if test="${empty sessionScope.user}">
<jsp:forward page="login.jsp"/>
</c:if>

