<%@ include file="IncludeTop.jsp"%>
<table style="border: 0;width: 100%;" >
	<tr>
		<td valign="top" width="20%" align="left">
			<table style="background-color: #6468e7;border : 0;">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="<c:url value="/viewCart.do"/>"><b> <font color="BLACK" size="2">&lt;&lt; Shopping Cart</font></b></a>
					</td>
				</tr>
			</table>
		</td>

		<td valign="top" align="center">
			<h2 align="center">Checkout Summary</h2>

			<table style="background-color: #6468e7;border : 0;">
				<tr bgcolor="#cccccc">
					<td><b>Item ID</b></td>
					<td><b>Product ID</b></td>
					<td><b>Description</b></td>
					<td><b>In Stock?</b></td>
					<td><b>Quantity</b></td>
					<td><b>List Price</b></td>
					<td><b>Total Cost</b></td>
				</tr>

				<c:forEach var="cartItem" items="${cartForm.cart.cartItemList.pageList}">
				<tr bgcolor="#FFFF88">
					<td><b><a href="<c:url value="/viewItem.do"><c:param name="itemName" value="${cartItem.item.itemName}"/></c:url>">
								<c:out value="${cartItem.item.itemName}" />
							</a></b>
					</td>
					<td><c:out value="${cartItem.item.product.productName}" /></td>
					<td><c:out value="${cartItem.item.attr1}" /> <c:out value="${cartItem.item.attr2}" /> <c:out value="${cartItem.item.attr3}" /> 
						<c:out value="${cartItem.item.attr4}" /> <c:out value="${cartItem.item.attr5}" /> <c:out value="${cartItem.item.product.productName}" />
					</td>
					<td align="center"><c:out value="${cartItem.inStock}" /></td>
					<td align="center"><c:out value="${cartItem.quantity}" /></td>
					<td align="right"><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="Rs #,##0.00" /></td>
					<td align="right"><fmt:formatNumber value="${cartItem.totalPrice}" pattern="Rs #,##0.00" /></td>
				</tr>
				</c:forEach>
				<tr bgcolor="#FFFF88">
					<td colspan="7" align="right"><b>Sub Total: <fmt:formatNumber value="${cartForm.cart.subTotal}" pattern="Rs #,##0.00" /></b><br />
					</td>
				</tr>
			</table> 
			<c:if test="${!cartForm.cart.cartItemList.firstPage}">
			<a href="checkout.do?page=previousCart"><font color="green"><B>&lt;&lt;Prev</B></font></a>
			</c:if> 
			<c:if test="${!cartForm.cart.cartItemList.lastPage}">
			<a href="checkout.do?page=nextCart"><font color="green"><B>Next&gt;&gt;</B></font></a>
			</c:if><br/>
			<html:link page="/newOrderForm.do" transaction="true">
				<img border="0" src="images/button_continue.gif" />
			</html:link>
		</td>
		<td valign="top" width="20%" align="right">&nbsp;</td>
	</tr>
</table>

<%@ include file="IncludeBottom.jsp"%>
