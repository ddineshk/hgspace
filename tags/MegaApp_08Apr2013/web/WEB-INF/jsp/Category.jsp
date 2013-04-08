<%@ include file="IncludeTop.jsp"%>

<p>
<center>
	<h2>
		<c:out value="${category.categoryName}" />
	</h2>
	<table style="background-color: #6468e7; border: 0;">
		<tr bgcolor="#CCCCCC">
			<td><b>Product Number</b></td>
			<td><b>Name</b></td>
		</tr>
		<c:forEach var="product" items="${productList.pageList}">
		<tr bgcolor="#FFFF88">
			<td><b><a href="<c:url value="/viewProduct.do"><c:param name="productNumber" value="${product.productNumber}"/></c:url>">
						<c:out value="${product.productNumber}" />
				</a></b>
			</td>
			<td><c:out value="${product.productName}" /></td>
		</tr>
		</c:forEach>
		<c:if test="${!productList.firstPage || !productList.lastPage}">
		<tr>
			<td>
				<c:if test="${!productList.firstPage}">
				<a href="?page=previous"><font color="white"><B>&lt;&lt;Prev</B></font></a>
				</c:if> 
				<c:if test="${!productList.lastPage}">
					<a href="?page=next"><font color="white"><B>Next&gt;&gt;</B></font></a>
				</c:if>
			</td>
		</tr>
		</c:if>
	</table>
</center>
<br>
<div align="left">
	<table style="background-color: #6468e7; border: 0;">
		<tr>
			<td bgcolor="#FFFF88"><a href="<c:url value="/index.do"/>"><b>
				<font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
			</td>
		</tr>
	</table>
</div>
<%@ include file="IncludeBottom.jsp"%>
