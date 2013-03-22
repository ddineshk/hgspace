<%@ include file="IncludeTop.jsp"%>
<link rel="stylesheet" href="css/jquery-ui.css"/>
<!-- <script src="js/jquery-1.7.2.js" type="text/javascript"></script> -->
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
    $( "#accordion" ).accordion({
        heightStyle: "fill",
        collapsible: true
    });
    
    $('.items').draggable({
        revert: true,
        proxy: 'clone',
        containment : 'document',
        cursor : 'crosshair'
    });
    
    Number.prototype.formatMoney = function(c, d, t){
    	var n = this, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t, s = n < 0 ? "-" : "", i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", j = (j = i.length) > 3 ? j % 3 : 0;
    	   return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
    	 };
    
    $('.cart').droppable({
    	drop:function(event,ui){
    		$( this ).find( ".emptyRow" ).remove();
    		var rowLen = $('.cart tr').length;
    		
    		$.ajax({
                type: "POST",
                url: "/MegaApp/itemInfo.do",
                data: "itemId=" + ui.draggable.attr('id'),
                success: function(res){
                	if(res.item!=null){
		                  $('<tr id=\"newRow'+rowLen+'\" bgcolor=\"#FFFF88\"></tr>').text('').appendTo($('.cart'));
		                  $('<td></td>').html('<b><a href=\"viewItem.do?itemName='+res.item.itemName+'\">'+res.item.itemName+'</a></b>').appendTo($('#newRow'+rowLen));
		                  $('<td></td>').html(res.item.product.productNumber).appendTo($('#newRow'+rowLen));
		                  $('<td></td>').html(res.item.attr1+' '+res.item.attr2+' '+res.item.attr3+' '+res.item.attr4+' '+res.item.attr5+' '+res.item.product.productName).appendTo($('#newRow'+rowLen));
		                  if(res.isInStock){
		                  	$('<td align=\"center\"></td>').html('true').appendTo($('#newRow'+rowLen));
		                  }else{
		                	  $('<td align=\"center\"></td>').html('false').appendTo($('#newRow'+rowLen));
		                  }
		                  $('<td align=\"center\"></td>').html('<input type=\"text\" size=3 name=\"'+res.item.itemName+'" value=\"1\" />').appendTo($('#newRow'+rowLen));
		                  $('<td align=\"right\"></td>').html('Rs '+(res.item.listPrice).formatMoney(2,'.',',')).appendTo($('#newRow'+rowLen));
		                  var cost = Number(res.item.listPrice) * Number($('input[name="'+res.itemName+'"]').val());
		                  $('<td id=\"totCost'+res.item.itemName+'\" align=\"right\"></td>').html('Rs '+(cost).formatMoney(2,'.',',')).appendTo($('#newRow'+rowLen));
		                  $('<td></td>').html('<a href=\"removeItemFromCart.do?workingItemName='+res.item.itemName+'\"><img border=\"0\" src=\"images/button_remove.gif\"/></a>').appendTo($('#newRow'+rowLen));
		                  $('#subTot').html('Rs '+(res.total).formatMoney(2,'.',','));
                	}else{
                		var qty = $('input[name="'+res.itemName+'"]').val();
                		$('input[name="'+res.itemName+'"]').val(Number(qty)+1);
                		
                		var totalCost = Number(res.listPrice) * (Number(qty)+1);
                		$('#totCost'+res.itemName).html('Rs '+(totalCost).formatMoney(2,'.',','));
                		$('#subTot').html('Rs '+(res.total).formatMoney(2,'.',','));
                	}
                },
                error: function(e){
                    alert('Error: ' + e);
                }
            });
    		
    	}
    });
    
});

</script>
<table style="width: 100%;">
	<tr>
		<td valign="top" width="27%" align="left">
			<table style="background-color: #6468e7; border: 0;">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="<c:url value="/index.do"/>"><b><font color="BLACK" size="2">&lt;&lt; Main Menu</font></b></a>
					</td>
				</tr>
			</table>
			<div id="accordion">
				<c:forEach items="${allList}" var="myLs">
				<h3>${myLs.key}</h3>
				<span>
					<c:forEach var="item" items="${myLs.value}">
					 <div class="items" id="${item.itemName}">${item.itemName} - ${item.product.productName}</div>
					</c:forEach>
				</span>
				</c:forEach>
			</div>
		</td>
		<td valign="top" align="center">
			<h2 align="center">Shopping Cart</h2>
			<form action="<c:url value="/updateCartQuantities.do"/>" method="post" accept-charset="utf-8">
				<div align="center" style="border-color: black;border-style: solid;">
					<table style="background-color: #6468e7;border :0;" class="cart">
						<thead>
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
						</thead>
						<c:if test="${cartForm.cart.numberOfItems == 0}">
						<tr bgcolor="#FFFF88" class="emptyRow">
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
							<td id="totCost${cartItem.item.itemName}" align="right"><fmt:formatNumber value="${cartItem.totalPrice}" pattern="Rs #,##0.00" /></td>
							<td><a href="<c:url value="/removeItemFromCart.do"><c:param name="workingItemName" value="${cartItem.item.itemName}"/></c:url>">
									<img border="0" src="images/button_remove.gif" /></a>
							</td>
						</tr>
						</c:forEach>
						
					</table>
					
					<div align="right">
						<b>Sub Total: <span id="subTot"><fmt:formatNumber value="${cartForm.cart.subTotal}" pattern="Rs #,##0.00" /></span></b><br />
						<input type="image" style="border: 0;" src="images/button_update_cart.gif" name="update" />
					</div>

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
