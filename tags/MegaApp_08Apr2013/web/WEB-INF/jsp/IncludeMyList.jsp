<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty accountForm.myList}">
	<p>&nbsp;</p>
	<div align="right">
		<table style="background-color: #6468e7;border: 0;" >
			<tr bgcolor="#CCCCCC">
				<td><font size="4"><b>Pet Favorites</b></font> <font size="2"><i><br />Shop for more of your <br />favorite pets here.</i></font></td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td><c:forEach var="product" items="${accountForm.myList.pageList}">
						<a href="<c:url value="/viewProduct.do"><c:param name="productNumber" value="${product.productNumber}"/></c:url>">
							<c:out value="${product.productName}" />
						</a>
						<br />
						<font size="2">(<c:out value="${product.productNumber}" />)
						</font>
						<br />
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td><c:if test="${!accountForm.myList.firstPage}">
						<a href="viewCart.do?page=previous"><font color="white"><B>&lt;&lt;Prev</B></font></a>
					</c:if> <c:if test="${!accountForm.myList.lastPage}">
						<a href="viewCart.do?page=next"><font color="white"><B>Next &gt;&gt;</B></font></a>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</c:if>
