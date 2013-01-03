<%@ include file="IncludeTop.jsp"%>

<table style="width: 100%;">
	<tr>
		<td valign="top" width="20%" align="left">
			<table style="background-color: #6468e7; border: 0;">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="<c:url value="/index.do"/>"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
					</td>
				</tr>
			</table>
		</td>
		<td valign="top" align="center">
			<h2 align="center">Shopping Cart</h2>
			<form action="<c:url value="/updateCartQuantities.do"/>" method="post">
				<div align="center">
					<table style="background-color: #6468e7;border :0;">
						<tr bgcolor="#cccccc">
							<td><b>Item ID</b></td>
							<td><b>Product ID</b></td>
							<td><b>Description</b></td>
							<td><b>In Stock?</b></td>
							<td><b>Quantity</b></td>
							<td><b>List Price</b></td>
							<td><b>Total Cost</b></td>
							<td>&nbsp;</td>
						</tr>

						<c:if test="${cartForm.cart.numberOfItems == 0}">
						<tr bgcolor="#FFFF88">
							<td colspan="8"><b>Your cart is empty.</b></td>
						</tr>
						</c:if>
						<c:forEach var="cartItem" items="${cartForm.cart.cartItemList.pageList}">
						<tr bgcolor="#FFFF88">
							<td><b><a href="<c:url value="/viewItem.do"><c:param name="itemName" value="${cartItem.item.itemName}"/></c:url>">
									<c:out value="${cartItem.item.itemName}" /></a></b>
							</td>
							<td><c:out value="${cartItem.item.product.productNumber}" /></td>
							<td><c:out value="${cartItem.item.attr1}" /> <c:out value="${cartItem.item.attr2}" /> 
								<c:out value="${cartItem.item.attr3}" /> <c:out value="${cartItem.item.attr4}" /> 
								<c:out value="${cartItem.item.attr5}" /> <c:out value="${cartItem.item.product.productName}" />
							</td>
							<td align="center"><c:out value="${cartItem.inStock}" /></td>
							<td align="center">
								<input type="text" size="3" name="<c:out value="${cartItem.item.itemName}"/>" value="<c:out value="${cartItem.quantity}"/>" />
							</td>
							<td align="right"><fmt:formatNumber value="${cartItem.item.listPrice}" pattern="Rs #,##0.00" /></td>
							<td align="right"><fmt:formatNumber value="${cartItem.totalPrice}" pattern="Rs #,##0.00" /></td>
							<td><a href="<c:url value="/removeItemFromCart.do"><c:param name="workingItemName" value="${cartItem.item.itemName}"/></c:url>">
									<img border="0" src="images/button_remove.gif" /></a>
							</td>
						</tr>
						</c:forEach>
						<tr bgcolor="#FFFF88">
							<td colspan="7" align="right"><b>Sub Total: <fmt:formatNumber value="${cartForm.cart.subTotal}" pattern="Rs #,##0.00" /></b><br/>
								<input type="image" style="border: 0;" src="images/button_update_cart.gif" name="update" /></td>
							<td>&nbsp;</td>
						</tr>
					</table>

					<c:if test="${!cartForm.cart.cartItemList.firstPage}">
						<a href="<c:url value="viewCart.do?page=previousCart"/>"><font color="green"><B>&lt;&lt; Prev</B></font></a>
					</c:if>
					<c:if test="${!cartForm.cart.cartItemList.lastPage}">
						<a href="<c:url value="viewCart.do?page=nextCart"/>"><font color="green"><B>Next &gt;&gt;</B></font></a>
					</c:if>
				</div>
			</form> 
			<c:if test="${cartForm.cart.numberOfItems > 0}"><br/>
			<center>
				<a href="<c:url value="/checkout.do"/>"> <img border="0" src="images/button_checkout.gif" /></a>
			</center>
			</c:if>
		</td>
		<td valign="top" width="20%" align="right">
		<c:if test="${!empty accountForm.account.username}">
			<c:if test="${accountForm.account.displayMyList}">
				<%@ include file="IncludeMyList.jsp"%>
			</c:if>
		</c:if></td>
	</tr>
</table>

<%@ include file="IncludeBanner.jsp"%>

<%@ include file="IncludeBottom.jsp"%>
