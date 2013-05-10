<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Browse Books</title>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/tagcloud.jquery.js"></script>
<script type="text/javascript">
    var settings = {
    		height: 400, 
    		width: 400,
    		radius: 150,
    		speed: 3,
    		slower: 0.9,
    		timer: 5,
    		fontMultiplier: 15,
    		hoverStyle: { border: 'none', color: '#0b2e6f' },
    		mouseOutStyle: { border: '', color: ''}
    };
    $(document).ready(function(){
        $('#tagcloud').tagoSphere(settings);
    });
</script>

</head>
<body>
	<% 
	   session = request.getSession(false);
	   if(session.getAttribute("user")==null ){
		   response.sendRedirect("userLogin.action");
	   }
	%>
	<jsp:include page="header.jsp" />
	<s:form action="userQueryByBookName">
		<s:textfield name="bookName" label="Enter Book Name" />
		<s:submit value="Submit" />
	</s:form>
	<p></p>
	<s:form action="userQueryByBookType">
		<s:select list="{'Java','Scala','Groovy','JRuby','Spring framework','Seam framework','Play! framework','Tomcat','WebLogic','JBOSS','WebShpere'}"
			label="Please Select the type of Books" name="bookType" headerKey="-1" headerValue="---Please Select---" />
		<s:submit value="Submit" />
	</s:form>

	<h3>Books</h3>

	<display:table id="books" name="books" pagesize="5" export="false" requestURI="userViewBooks" style="border: thin;border-style: groove;">
		<display:column property="bookType" title="Book Type" sortable="true" />
		<display:column property="bookName" title="Book Name" sortable="true" paramId="id" paramProperty="id" url="/user/userViewBooksDetail.action" />
		<display:column property="author" title="Author" sortable="true" />
		<display:column property="bookPress" title="Press" sortable="true" />
		<display:column property="language" title="Language" sortable="true" />
		<display:setProperty name="paging.banner.placement" value="bottom" />
	</display:table>
	<div id="tagcloud">
		<ul>
			<s:iterator value="books">
				<li><a href=""><s:property value="bookName" /></a></li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>