<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Find Books</title>
</head>
<body><%session = request.getSession(false);if(session.getAttribute("AdminName")==null){response.sendRedirect("adminLogin.action");}%>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>Query Book Form</h3>
	<s:form action="queryByBookName">
		<s:textfield name="bookName" label="Book Name" />
		<s:submit value="Submit" />
	</s:form>
	<s:form action="queryByBookType">
		<s:select list="{'Java','Scala','Groovy','JRuby','Spring framework','Seam framework','Play! framework','Tomcat','WebLogic','JBOSS','WebShpere'}"
			label="Book Type" name="bookType" />
		<s:submit value="Submit" />
	</s:form>
	<display:table id="books" name="books" pagesize="5" export="false" requestURI="viewBooks">
		<display:column property="bookType" title="Book Type" sortable="true" />
		<display:column property="bookName" title="Book Name" sortable="true" paramId="id" paramProperty="id" url="/admin/viewBookDetail.action" />
		<display:column property="author" title="Author" sortable="true" />
		<display:column property="bookPress" title="Press" sortable="true" />
		<display:column property="language" title="Language" sortable="true" />
		<display:column value="delete" title="Delete" sortable="true" paramId="id" paramProperty="id" url="/admin/deleteBookById.action" />
		<display:column value="update" title="Update" sortable="true" paramId="id" paramProperty="id" url="/admin/updateBookInfo.action" />
		<display:setProperty name="paging.banner.placement" value="bottom" />
	</display:table>
</body>
</html>