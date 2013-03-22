<%@ include file="IncludeTop.jsp"%>

<center>
	<font size="4"><b>My Orders</b></font>
</center>
<div align="center">
<table style="background-color: #6468e7;border: 0;">
	<tr bgcolor="#CCCCCC">
		<td><b>Order ID</b></td>
		<td><b>Date</b></td>
		<td><b>Total Price</b></td>
	</tr>
	<c:forEach var="order" items="${orderList}">
		<tr bgcolor="#FFFF88">
			<td><b><a
					href="<c:url value="/viewOrder.do">
                      <c:param name="id" value="${order.id}"/>
                    </c:url>">
						<font color="BLACK"><c:out value="${order.id}" /></font>
				</a></b></td>
			<td><fmt:formatDate value="${order.orderDate}"
					pattern="yyyy/MM/dd hh:mm:ss" /></td>
			<td><fmt:formatNumber value="${order.totalPrice}"
					pattern="र #,##0.00" /></td>
		</tr>
	</c:forEach>
</table>
</div>
<%@ include file="IncludeBottom.jsp"%>
