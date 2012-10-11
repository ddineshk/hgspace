<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tags/booktype.tld" prefix="b" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br/><br/><br/><br/><br/>
<div><h2>
Book List
</h2></div>
<div>
	<form name="form1" method="GET" action="BooksPageAction.do">
		<!-- search: <select name="search">
			<option value="1">opt1</option>
			<option value="2">opt2</option>
			<option value="3">opt3</option>
		</select> --> Type: <select name="bookTypeId">
			<b:bookstype>option</b:bookstype>
		</select> search:<input type="text" name="seachstr" /><input
			onclick="Search()" type="button" value="Search" />
	</form>
</div>
<table border="1">
<tr>
<td>Book Id</td><td>Book Name</td><td>Book Publication</td> <td>Book Type</td><td>Count</td> <td>&nbsp;</td>
</tr>
<c:forEach var="books" items="${requestScope.list}">
<tr>
<td>${books.books_Id}</td> <td>${books.books_Name}</td> <td>${books.books_Company}</td> <td><b:bookstype>${books.bookType_Id}</b:bookstype></td> <td>${books.books_Count}</td> <td><a onclick="javascript:window.open('BookCarAction.do?books_Id=${books.books_Id}')" href="#">Borrow</a></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="javascript:BooksPage('${requestScope.page-1<=0?1:requestScope.page-1}','${requestScope.seach}','${requestScope.bookTypeId}','${requestScope.seachstr}')"></a></td><td><a href="javascript:BooksPage('${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}','${requestScope.seach}','${requestScope.bookTypeId}','${requestScope.seachstr}')"></a></td><td>${requestScope.page}/${requestScope.pagecount}</td>
</tr>
</table>

