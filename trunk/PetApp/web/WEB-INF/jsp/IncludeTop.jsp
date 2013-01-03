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
<link rel="stylesheet" href="css/menuanim.css"/>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/easing.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
</head>
<body bgcolor="white">
	<table style="width: 100%; border: 0; background-image: url('images/bkg-topbar.gif'); background-color: #aaa;">
		<tr>
			<td><a href="<c:url value="/index.do"/>"> <img border="0" src="images/logo-topbar1.gif" /></a></td>
			<td align="right" valign="bottom">
				<table>
					<tr align="center">
						<td>
						<c:if test="${empty accountForm.account}">
							<font color="white">Guest</font><img border="0" src="images/separator.gif" />
						</c:if>
						<c:if test="${!empty accountForm.account}">
							<font color="white"><c:out value="${accountForm.account.firstname}"></c:out></font>
							<img border="0" src="images/separator.gif" />
						</c:if></td>
						<td><a href="<c:url value="/viewCart.do"/>"><img border="0" name="img_cart" src="images/cart.gif" /></a>
							<img border="0" src="images/separator.gif" />
						</td>
						<td>
						<c:if test="${empty accountForm.account}">
							<a href="<c:url value="/signonForm.do"/>"><img border="0" name="img_signin" src="images/sign-in.gif" /></a>
						</c:if>
						<c:if test="${!empty accountForm.account}">
							<a href="<c:url value="/signon.do?signoff=true"/>"><img border="0" name="img_signout" src="images/sign-out.gif" /></a>
							<img border="0" src="images/separator.gif" />
							<a href="<c:url value="/editAccountForm.do"/>"><img border="0" name="img_myaccount" src="images/my_account.gif" /></a>
						</c:if><img border="0" src="images/separator.gif" />
						</td>
						<td><a href="<c:url value="/help.do"/>" target="new"><img border="0" name="img_help" src="images/help.gif" /></a></td>
					</tr>
					<tr>
						<td colspan="4" align="right"> 
							<form action="<c:url value="/searchProducts.do"/>" method="post">
								<input type="hidden" name="search" value="true" />
								<input name="keyword" size="14" /> <input style="border: 0;" src="images/search.gif" type="image" name="search" />
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table><tr><td>
	<div align="center" style="border: 1;position:relative;height: 130px;">
		<ul>
			<li class="green">
				<p>FISH</p>
				<p class="subtext">
					<a href="<c:url value="/viewCategory.do?categoryName=FISH"/>">
						<img border="0" src="images/fish_menu.gif"/>
					</a>
				</p>
			</li>
			<li class="yellow">
				<p>DOGS</p>
				<p class="subtext">
					<a href="<c:url value="/viewCategory.do?categoryName=DOGS"/>">
						<img border="0" src="images/dog_menu.gif" />
					</a>
				</p>
			</li>
			<li class="red">
				<p>REPTILES</p>
				<p class="subtext">
					<a href="<c:url value="/viewCategory.do?categoryName=REPTILES"/>">
						<img border="0" src="images/reptile_menu.gif" />
					</a>
				</p>
			</li>
			<li class="blue">
				<p>CATS</p>
				<p class="subtext">
					<a href="<c:url value="/viewCategory.do?categoryName=CATS"/>">
						<img border="0" src="images/cat_menu.gif" />
					</a>
				</p>
			</li>
			<li class="purple">
				<p>BIRDS</p>
				<p class="subtext">
					<a href="<c:url value="/viewCategory.do?categoryName=BIRDS"/>">
						<img border="0" src="images/bird_menu.gif" />
					</a>
				</p>
			</li>
		</ul>
	</div></td></tr>
	</table>