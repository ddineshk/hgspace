<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>

<html>
<head><link rel="stylesheet" href="css/menuanim.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lend</title>
</head>
<body>
<c:forEach var="books" items="${sessionScope.cart}">
<form name="form${books.books_Id}" method="post" action="BookLendAction.do">
<table border="1">
<tr>
<td align="center">Book Id</td> <td align="center">Book Title</td><td align="center">Tenure</td> <td align="center">Action</td>
</tr>
<tr>
<td>${books.books_Id}<input type="hidden" name="books_Id" value="${books.books_Id}" /></td> <td><b:booksname>${books.books_Id}</b:booksname></td> <td><select name="lendDay"><option value="30">30</option><option value="7">7</option></select></td> <td><input type="hidden" name="laction" value="" /><input onclick="javascript:document.form${books.books_Id}.laction.value='insert';document.form${books.books_Id}.submit();" type="button" value="Insert"/><input onclick="javascript:document.form${books.books_Id}.laction.value='del';document.form${books.books_Id}.submit();" type="button" value="Delete"/></td>
</tr>
</table>
</form>
</c:forEach>
</body>
<c:if test="${not empty requestScope.lendMsg}">
<script type="" language="javascript">alert('${requestScope.lendMsg}');</script>
</c:if>
</html>