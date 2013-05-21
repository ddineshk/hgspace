<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Browse Books</title>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<% session = request.getSession(false);if(session.getAttribute("user")==null ){response.sendRedirect("userLogin.action");}	%>
</head>
<body>
	
	<jsp:include page="header.jsp" />
	<div style="width: 50%;">
	<s:form action="userQueryByBookName">
		<s:textfield name="bookName" label="Enter Book Name" />
		<s:submit value="Submit" />
	</s:form>
	</div>
	<hr/>
	<div style="width: 40%;">
	<s:form action="userQueryByBookType">
		<s:select name="bookTypeId" label="Please Select the type of Books" list="bookTypes" listKey="id" listValue="bookType" headerKey="-1" headerValue="Please Select"/>
		<s:submit value="Submit" />
	</s:form>
	</div>
	<h3>Books</h3>
	<display:table id="books" name="books" pagesize="5" export="false" requestURI="userViewBooks" style="width:80%;">
		<display:column property="bookType.bookType" title="Book Type" sortable="true"/>
		<display:column property="bookName" title="Book Name" sortable="true" paramId="id" paramProperty="id" url="/user/userViewBooksDetail.action"/>
		<display:column property="author" title="Author" sortable="true"/>
		<display:column property="bookPress" title="Press" sortable="true"/>
		<display:column property="language" title="Language" sortable="true"/>
		<display:setProperty name="paging.banner.placement" value="bottom"/>
	</display:table>
</body>
</html>