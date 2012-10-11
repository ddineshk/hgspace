<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/datectrl.tld" prefix="date" %>
<%@ taglib uri="/WEB-INF/tags/username.tld" prefix="u" %>
<center>
<h1>
Punish List
</h1>
<table border="1">
<tr>
<th>-</th> <th>-</th> <th>-</th> <th>-</th> <th>-</th>
</tr>
<c:forEach var="punish" items="${requestScope.list}">
<tr>
<td>${punish.users_Id}</td> <td><u:getname>${punish.users_Id}</u:getname></td> <td><b:booksname>${punish.books_Id}</b:booksname></td> <td>${punish.punish_Day}</td> <td>${punish.punish_Money}</td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="UserPunishPageAction.do?page=${requestScope.page-1<=0?1:requestScope.page-1}">rare</a></td><td><a href="UserPunishPageAction.do?page=${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}">dates</a></td><td>${requestScope.page}/${requestScope.pagecount}sad</td>
</tr>
</table>
</center>

