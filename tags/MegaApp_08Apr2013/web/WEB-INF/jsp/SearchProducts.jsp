<%@ include file="IncludeTop.jsp"%>
<div align="left">
<table style="background-color: #6468e7;border: 0;">
	<tr>
		<td bgcolor="#FFFF88"><a href="<c:url value="/index.do"/>"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a></td>
	</tr>
</table>
</div>
<div align="center">
	<table style="background-color: #6468e7;border: 0;">
		<c:if test="${!empty productList.pageList}">
		<tr bgcolor="#CCCCCC">
			<td>&nbsp;</td>
			<td><b>Product Number</b></td>
			<td><b>Name</b></td>
		</tr>
		<c:forEach var="product" items="${productList.pageList}">
		<tr bgcolor="#FFFF88">
			<td><a href="<c:url value="/viewProduct.do"><c:param name="productNumber" value="${product.productNumber}"/></c:url>">
					<c:out value="${product.productDesc}" escapeXml="false" />
				</a></td>
			<td><b><a href="<c:url value="/viewProduct.do"><c:param name="productNumber" value="${product.productNumber}"/></c:url>">
						<font color="BLACK"><c:out value="${product.productNumber}" /></font>
				</a></b></td>
			<td><c:out value="${product.productName}" /></td>
		</tr>
		</c:forEach>
		<tr>
		<td>
			<c:if test="${!productList.firstPage}">
				<a href="?page=previous"><font color="white"><B>&lt;&lt;Prev</B></font></a>
			</c:if> <c:if test="${!productList.lastPage}">
				<a href="?page=next"><font color="white"><B>Next&gt;&gt;</B></font></a>
			</c:if>
			</td>
		</tr>
		</c:if>
		<c:if test="${empty productList.pageList}">
		<tr><td>No Result found</td></tr>
		</c:if>
	</table>
</div>
<%@ include file="IncludeBottom.jsp"%>
