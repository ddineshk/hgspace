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
<link rel="stylesheet" type="text/css" href="css/menuanim.css"/>
<link rel="stylesheet" type="text/css" href="css/jquerycssmenu.css" />
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="js/easing.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<script src="js/jquerycssmenu.js" type="text/javascript" ></script>
<script type="text/javascript">
	var can, ctx,addAngle, addScale,step, steps = 50, delay = 20;
	var txt = '';
	function drawMyText(canvas,str){
		txt=str;
		can = document.getElementById(canvas);
		ctx = can.getContext("2d");
		addAngle = Math.PI * 2 / steps;
        addScale = 1 / steps;
        step = 0;
        ctx.fillStyle = "blue";
        ctx.font = "13pt Helvetica";
        ctx.textAlign = "center";
        ctx.textBaseline = "middle";
		spinText();
	}
    function spinText() {
        step++;
        ctx.clearRect(0,0, can.width, can.height);
        ctx.save();
        ctx.translate(can.width / 2, can.height / 2);
        ctx.scale(addScale * step, addScale * step);
        ctx.rotate(addAngle * step);
        ctx.strokeText(txt, 0, 0);
        ctx.restore();
        if (step < steps){
            setTimeout('spinText()', delay);
        }
    }
    function stickyFooter(){
	    jQuery("#stickyFooter").css({position: "absolute",top:($(window).scrollTop()+$(window).height()-$("#stickyFooter").height())+"px"});
    }
     
    jQuery(function(){
        stickyFooter();
        jQuery(window)
            .scroll(stickyFooter)
            .resize(stickyFooter);
    });
</script>
</head>
<body bgcolor="white" topmargin="0" style="padding:0px; margin:0px;" 
	<%-- <c:if test="${empty accountForm.account}"> onload="drawMyText('user','Guest');"</c:if>
	<c:if test="${!empty accountForm.account}"> onload="drawMyText('user','${accountForm.account.firstname}');"</c:if> --%>>
	<table style="width: 100%;/* background-color: #27B600; */" class="banner">
		<tr>
			<td><a href="<c:url value="/index.do"/>">Home<%-- <img border="0" src="images/logo-topbar1.gif" /> --%></a></td>
			<td align="right">
				<table border="1">
					<tr>
						<td>
						<c:if test="${empty accountForm.account}">
							<%-- <canvas id="user" width="100" height="15"></canvas> --%>
							<img border="0" src="images/guest.png" />
							<%-- <img border="0" src="images/separator.gif" /> --%>
						</c:if>
						<c:if test="${!empty accountForm.account}">
							<a href="<c:url value="/editAccountForm.do"/>">
							${accountForm.account.firstname}
							<%-- <canvas id="user" width="110" height="15"></canvas> --%></a>
						</c:if><img border="0" src="images/separator.gif" />
						</td>
						<td style="vertical-align:bottom; display: table-cell;"><a href="<c:url value="/viewCart.do"/>"><img border="0" align="bottom" name="img_cart" src="images/cart.gif"/></a>
							<img border="0" src="images/separator.gif" />
						</td>
						<td>
						<c:if test="${empty accountForm.account}">
							<a href="<c:url value="/signonForm.do"/>" class="btm">Signin</a>
						</c:if>
						<c:if test="${!empty accountForm.account}">
							<a href="<c:url value="/signon.do?signoff=true"/>" class="btm">Signout</a>
						</c:if><img border="0" src="images/separator.gif" />
						</td>
						<td><a href="<c:url value="/help.do"/>" target="new"><img border="0" name="img_help" src="images/help.gif" /></a></td>
					</tr>
					<tr>
						<td colspan="4" align="right"> 
							<form action="<c:url value="/searchProducts.do"/>" method="post">
								<input type="hidden" name="search" value="true" />
								<input name="keyword" size="14" /> <input src="images/search.gif" type="image" name="search" />
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<%-- <table>
		<tr>
			<td>
				<div align="center" style="position:relative;height: 130px;">
					<ul id="menu">
						<li class="drop">
							<p>FISH</p>
							<p class="subtext">
								<a href="<c:url value="/viewCategory.do?categoryName=FISH"/>">
									<img border="0" src="images/fish_menu.gif"/>
								</a>
							</p>
						</li>
						<li class="drop">
							<p>DOGS</p>
							<p class="subtext">
								<a href="<c:url value="/viewCategory.do?categoryName=DOGS"/>">
									<img border="0" src="images/dog_menu.gif" />
								</a>
							</p>
						</li>
						<li class="drop">
							<p>REPTILES</p>
							<p class="subtext">
								<a href="<c:url value="/viewCategory.do?categoryName=REPTILES"/>">
									<img border="0" src="images/reptile_menu.gif" />
								</a>
							</p>
						</li>
						<li class="drop">
							<p>CATS</p>
							<p class="subtext">
								<a href="<c:url value="/viewCategory.do?categoryName=CATS"/>">
									<img border="0" src="images/cat_menu.gif" />
								</a>
							</p>
						</li>
						<li class="drop">
							<p>BIRDS</p>
							<p class="subtext">
								<a href="<c:url value="/viewCategory.do?categoryName=BIRDS"/>">
									<img border="0" src="images/bird_menu.gif" />
								</a>
							</p>
						</li>
					</ul>
				</div>
			</td>
		</tr>
	</table> --%>
<div id="myjquerymenu" class="jquerycssmenu">
<ul>
<li><a href="<c:url value="/index.do"/>">Home</a></li>

<li><a href="#">Categories</a>
  <ul>
  <c:forEach items="${allList}" var="myLs">
	<a href="<c:url value="/viewCategory.do?categoryName=${myLs.key}"/>">${myLs.key}</a>
  </c:forEach>
  </ul>
</li>
<li><a href="#">Contact Us</a></li>
</ul>
<br style="clear: left" />
</div>