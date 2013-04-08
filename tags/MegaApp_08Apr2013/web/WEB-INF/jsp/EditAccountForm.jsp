<%@ include file="IncludeTop.jsp"%>

<html:form styleId="workingAccountForm" method="post" action="/editAccount.do">
	<html:hidden name="workingAccountForm" property="validate" value="editAccount" />
	<html:hidden name="workingAccountForm" property="account.username" />
	<div align="center">
		<table style="background-color: #dddddd; border: 1;" >
			<tr>
				<td><h3><font color="darkgreen">User Information</font></h3>
					<table style="background-color: #FFFF88; border: 0;">
						<tr bgcolor="#FFFF88">
							<td>User Name:</td>
							<td><c:out value="${workingAccountForm.account.username}" />
							</td>
						</tr>
						<tr bgcolor="#FFFF88">
							<td>New password:</td>
							<td><html:password name="workingAccountForm" property="account.password" /></td>
						</tr>
						<tr bgcolor="#FFFF88">
							<td>Repeat password:</td>
							<td><html:password name="workingAccountForm" property="repeatedPassword" /></td>
						</tr>
					</table>
					<%@ include file="IncludeAccountFields.jsp"%>
				</td>
			</tr>
		</table>
	</div>
	<br/>
	<center>
		<input type="image" src="images/button_submit.gif" style="border: 0;" name="submit" value="Save Account Information" />
	</center>
</html:form>
<center>
	<b><a href="<c:url value="/listOrders.do"/>">My Orders</a></b>
</center>
<%@ include file="IncludeBottom.jsp"%>
