<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/datectrl.tld" prefix="date" %>
<center>
<h1>
Lend List
</h1>
<table border="1">
<tr>
<th>-</th> <th>-</th> <th>-</th> <th>-</th> <th>-</th>
</tr>
<c:forEach var="booklend" items="${requestScope.list}">
<tr>
<td>${booklend.books_Id}</td> <td><b:booksname>${booklend.books_Id}</b:booksname></td> <td><script type="text/javascript" >printTime('${booklend.bookLend_StarTime}')</script></td> <td><script type="text/javascript" >printTime('${booklend.bookLend_EndTime}')</script></td> <td><date:datejian>${booklend.bookLend_EndTime}</date:datejian></td>
</tr>
</c:forEach>
</table>
</center>
