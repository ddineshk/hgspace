<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html"%>

<html>
<head>
<title>Hibernate Store Demo</title>
<meta content="text/html" http-equiv="Content-Type" />
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<meta http-equiv="expires" content="0">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<link rel="stylesheet" href="../css/menuanim.css"/>
<script src="../js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="../js/easing.js" type="text/javascript"></script>
<script src="../js/index.js" type="text/javascript"></script>
</head>
<body bgcolor="white">
	<table style="width: 100%; border: 0; background-image: url('../images/bkg-topbar.gif'); background-color: #aaa;">
		<tr>
			<td><a href="<c:url value="/shop/index.do"/>"> <img border="0" src="../images/logo-topbar1.gif" /></a></td>
			<td align="right" valign="bottom">
				<table>
					<tr align="center">
						<td>
						<c:if test="${empty accountForm.account}">
							<font color="white">Guest</font><img border="0" src="../images/separator.gif" />
						</c:if>
						<c:if test="${!empty accountForm.account}">
							<font color="white"><c:out value="${accountForm.account.firstname}"></c:out></font>
							<img border="0" src="../images/separator.gif" />
						</c:if></td>
						<td><a href="<c:url value="/shop/viewCart.do"/>"><img border="0" name="img_cart" src="../images/cart.gif" /></a>
							<img border="0" src="../images/separator.gif" />
						</td>
						<td>
						<c:if test="${empty accountForm.account}">
							<a href="<c:url value="/shop/signonForm.do"/>"><img border="0" name="img_signin" src="../images/sign-in.gif" /></a>
						</c:if>
						<c:if test="${!empty accountForm.account}">
							<a href="<c:url value="/shop/signon.do?signoff=true"/>"><img border="0" name="img_signout" src="../images/sign-out.gif" /></a>
							<img border="0" src="../images/separator.gif" />
							<a href="<c:url value="/shop/editAccountForm.do"/>"><img border="0" name="img_myaccount" src="../images/my_account.gif" /></a>
						</c:if><img border="0" src="../images/separator.gif" />
						</td>
						<td><a href="<c:url value="/shop/help.do"/>" target="new"><img border="0" name="img_help" src="../images/help.gif" /></a></td>
					</tr>
					<tr>
						<td colspan="4" align="right"> 
							<form action="<c:url value="/shop/searchProducts.do"/>" method="post">
								<input type="hidden" name="search" value="true" />
								<input name="keyword" size="14" /> <input style="border: 0;" src="../images/search.gif" type="image" name="search" />
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div align="center" style="width: 100%;border: 1;">
		<ul>
			<li class="green">
				<p><a href="<c:url value="/shop/viewCategory.do?categoryName=FISH"/>">FISH</a></p>
				<p class="subtext"><img border="0" src="../images/fish2.gif" /></p>
			</li>
			<li class="yellow">
				<p><a href="<c:url value="/shop/viewCategory.do?categoryName=DOGS"/>">DOGS</a></p>
				<p class="subtext">Dogs</p>
			</li>
			<li class="red">
				<p><a href="<c:url value="/shop/viewCategory.do?categoryName=REPTILES"/>">REPTILES</a></p>
				<p class="subtext">Reptiles</p>
			</li>
			<li class="blue">
				<p><a href="<c:url value="/shop/viewCategory.do?categoryName=CATS"/>">CATS</a></p>
				<p class="subtext">Cats</p>
			</li>
			<li class="purple">
				<p><a href="<c:url value="/shop/viewCategory.do?categoryName=BIRDS"/>">BIRDS</a></p>
				<p class="subtext">Birds</p>
			</li>
		</ul>
	</div>