<%@page import="org.apache.commons.lang.WordUtils"%>
<%@page import="com.dinesh.piloting.struts.bean.UserBean"%>
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<jsp:include page="isLogin.jsp"/>
<html>
<head>
<link rel="stylesheet" href="css/menuanim.css"/>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/easing.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>

<title>
Index Page
</title>
</head>
<body>
	<h2>Welcome <%=WordUtils.capitalize(((UserBean)request.getSession().getAttribute("user")).getUsers_Name())%>!</h2>
	<ul>
		<li class="green">
			<p><a href="BooksSearchAction.do" class="menuitem"><bean:message key="jsp.user.index.menu.scanbooks" /></a></p>
			<p class="subtext">The Page to scan books</p>
		</li>
		<li class="yellow">
			<p><a href="LendBookListAction.do" class="menuitem"><bean:message key="jsp.user.index.menu.scanlendbook" /></a></p>
			<p class="subtext">The Page to borrow books</p>
		</li>
		<li class="red">
			<p><a href="UserPunishPageAction.do?page=1" class="menuitem"><bean:message key="jsp.user.index.menu.scanpunish" /></a></p>
			<p class="subtext">Test text</p></li>
		<li class="blue">
			<p><a href="index.jsp?action=4" class="menuitem"><bean:message key="jsp.user.index.menu.chengeinfo" /></a></p>
			<p class="subtext">text testing</p>
		</li>
		<li class="purple">
			<p><a href="OutAction.do" class="menuitem"><bean:message key="jsp.user.index.menu.loginout" /></a></p>
			<p class="subtext">out of misery</p>
		</li>
	</ul>
	<table>
    <tbody>
    <logic:equal parameter="action" value="1">
    	<jsp:include flush="false" page="booklist.jsp"/>
    </logic:equal>
    <logic:equal parameter="action" value="2">
   		<jsp:include flush="false" page="lendlist.jsp"/>
    </logic:equal>
    <logic:equal parameter="action" value="3">
   		<jsp:include flush="false" page="punishlist.jsp"/>
    </logic:equal>
    <logic:equal parameter="action" value="4">
    	<jsp:include flush="false" page="editinfo.jsp"/>
    </logic:equal>
    </tbody>
  </table>
</body>
</html>
