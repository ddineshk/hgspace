<%@ include file="IncludeTop.jsp"%>
<c:if test="${item.quantity > 0}">
	<div align="left">
		<table style="background-color: #6468e7; border: 0;">
		<tr>
			<td bgcolor="#FFFF88">
				<a href="<c:url value="/viewProduct.do"><c:param name="productNumber" value="${product.productNumber}"/></c:url>">
					<b><font color="BLACK" size="2">&lt;&lt; <c:out value="${product.productName}" /></font></b>
					</a>
				</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<table style="background-color: #6468e7; border: 0; width: 60%;">
			<tr bgcolor="#FFFF88">
				<td bgcolor="#FFFFFF"><c:out value="${product.productDesc}" escapeXml="false" /></td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td width="100%" bgcolor="#cccccc"><b><c:out value="${item.itemName}" /></b></td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td><b><font size="4"> <c:out value="${item.attr1}" />
						<c:out value="${item.attr2}" /> <c:out value="${item.attr3}" /> <c:out value="${item.attr4}" /> <c:out value="${item.attr5}" /> 
						<c:out value="${product.productName}" /> </font></b></td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td><font size="3"><i><c:out value="${product.productName}" /></i></font></td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td> 
					<font size="2"><fmt:formatNumber value="${item.quantity}" /> in stock.</font>
				</td>
			</tr>
			<tr bgcolor="#FFFF88">
				<td><fmt:formatNumber value="${item.listPrice}" pattern="Rs #,##0.00" /></td>
			</tr>

			<tr bgcolor="#FFFF88">
				<td><html:link paramId="workingItemName" paramName="item" paramProperty="itemName" page="/addItemToCart.do" transaction="true">
					<img border="0" src="images/button_add_to_cart.gif" />
				</html:link></td>
			</tr>
		</table>
	</div>
</c:if>
<c:if test="${item.quantity <= 0}">
	<div align="center" style="border: 1;height: 50%;" >
		<font color="RED" size="6"><i>Not in stock</i></font>
	</div>
</c:if>
<%@ include file="IncludeBottom.jsp"%>
