<%@ include file="IncludeTop.jsp"%>

<table style="background-color: #6468e7; border: 0;">
	<tr>
		<td bgcolor="#FFFF88">
			<a href="<c:url value="/viewCategory.do"><c:param name="categoryName" value="${categoryName}"/></c:url>">
				<b><font color="BLACK" size="2">&lt;&lt; <c:out value="${product.productName}" /></font></b>
			</a>
		</td>
	</tr>
</table>

<p align="center">
	<b><font size="4"><c:out value="${product.productName}" /></font></b>
	<html:form action="/addItemToCart.do" method="post">
		<div align="center">
			<table style="background-color: #6468e7; border: 0; vertical-align: middle;">
				<tr bgcolor="#CCCCCC">
					<td><b>Item Name</b></td>
					<td><b>Product Number</b></td>
					<td><b>Description</b></td>
					<td><b>List Price</b></td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${itemList.pageList}">
				<tr bgcolor="#FFFF88">
					<td>
						<b><a href="<c:url value="/viewItem.do"><c:param name="itemName" value="${item.itemName}"/></c:url>">
								<c:out value="${item.itemName}" />
							</a>
						</b>
					</td>
					<td><c:out value="${product.productNumber}" /></td>
					<td><c:out value="${item.attr1}" /> <c:out value="${item.attr2}" /> 
						<c:out value="${item.attr3}" /> <c:out value="${item.attr4}" /> 
						<c:out value="${item.attr5}" /> <c:out value="${product.productName}" />
					</td>
					<td><fmt:formatNumber value="${item.listPrice}" pattern="Rs #,##0.00" /></td>
					<td valign="bottom">
						<html:link paramId="workingItemName" paramName="item" paramProperty="itemName" page="/addItemToCart.do" transaction="true">
							<img border="0" src="images/button_add_to_cart.gif" />
						</html:link>
					</td>
				</tr>
				</c:forEach>
				<c:if test="${!itemList.firstPage || !itemList.lastPage}">
				<tr>
					<td><c:if test="${!itemList.firstPage}">
							<a href="?page=previous"><font color="white"><B>&lt;&lt;Prev</B></font></a>
						</c:if>
						<c:if test="${!itemList.lastPage}">
							<a href="?page=next"><font color="white"><B>Next&gt;&gt;</B></font></a>
						</c:if>
					</td>
				</tr>
				</c:if>
			</table>
		</div>
	</html:form>
	<%@ include file="IncludeBottom.jsp"%></p>

