<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Shopping Detail</title>
<script type="text/javascript">

	function updateBookAmount(Id){
		var pattern = /^[1-9][0-9]{0,}$/;
		var bookAmount = document.getElementById("bookAmount"+Id).value;
		if(pattern.test(bookAmount)){
			location.href = "updateBookQuantity.action?Id="+Id+"&bookAmount="+bookAmount;
		}else{
			alert('Quantity cannot be 0 or is invalid');
		}
	}
	
	function checkForEmptyRow(){
		var flag = "false";
		$('input[id^="bookAmount"]').each(function(){
			flag="true";
		});
		if(flag ==="true"){
			window.location.href='processOrder.action';
		}else{
			alert('There are no items in the cart');
		}
	}
</script>
</head>
<body>
	<%session = request.getSession(false);if(session.getAttribute("user")==null){response.sendRedirect("userLogin.action");}%>
	<jsp:include page="header.jsp" />
	<p></p>
	<br>
	<br>
	<table border="1" style="width: 938px; height: 30px;">
		<tbody>
			<tr>
				<th style="width: 699px;">Book Title</th>
				<th style="margin-left: -3px;">Unit Price</th>
				<th>Quantity</th>
				<th>Action</th>
			</tr>

			<s:iterator value="#session.selectbooks" status="listbook">
				<tr>
					<td><s:property value="bookName" /></td>
					<td><s:property value="price" /></td>
					<td><input type="text" id="bookAmount<s:property value="Id"/>" 
						value='<s:property value="bookAmount"/>' maxlength="2" size="2" />
						<input type="button" value="Modify" onclick="updateBookAmount('<s:property value="Id"/>')"></td>

					<td><s:url action="cancelOder.action" var="URLtag">
							<s:param name="Id">
								<s:property value="Id" />
							</s:param>
						</s:url> <s:a href="%{URLtag}">Cancel</s:a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<p>
	<br />
	</p>
	Total Amount:
	<s:property value="#session.totalPrice" />
	<br>
	<br>
	<s:a href="userViewBooks.action">Continue Shopping</s:a>
	<s:a href="javascript:void(0)" onclick="checkForEmptyRow()">Checkout</s:a>
</body>


</html>