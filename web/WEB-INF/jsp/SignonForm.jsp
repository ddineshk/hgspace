<%@ include file="IncludeTop.jsp"%>

<c:if test="${!empty message}">
	<b><font color="RED"><c:url value="${message}" /></font></b>
</c:if>
<form action="<c:url value="/signon.do"/>" method="POST">
	<c:if test="${!empty signonForwardAction}">
		<input type="hidden" name="forwardAction" value="<c:url value="${signonForwardAction}"/>" />
	</c:if>
	<div align="center">
		<table style="border: 0;">
			<tr>
				<td colspan="2">Please enter your user name and password. <br />&nbsp;</td>
			</tr>
			<tr>
				<td>User name:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="image" style="border: 0;" src="images/button_submit.gif" name="update" /></td>
			</tr>
		</table>
	</div>
</form>

<center>
	<a href="<c:url value="/newAccountForm.do"/>"> <img border="0"
		src="images/button_register_now.gif" />
	</a>
</center>

<%@ include file="IncludeBottom.jsp"%>

