<%@ include file="IncludeTop.jsp"%>

<html:form action="/newAccount.do" styleId="workingAccountForm" method="post">
<html:hidden name="workingAccountForm" property="validate" value="newAccount" />
<div align="center">
	<TABLE style="border: 1;background-color: #dddddd;">
		<TR>
			<TD><H3><FONT color=darkgreen>User Information</FONT></H3>
				<TABLE style="background-color: #6468e7;border: 0;">
					<TR bgcolor="#FFFF88">
						<TD>User Name:</TD>
						<TD><html:text name="workingAccountForm" property="account.username" /></TD>
					</TR>
					<TR bgcolor="#FFFF88">
						<TD>New password:</TD>
						<TD><html:password name="workingAccountForm" property="account.password" /></TD>
					</TR>
					<TR bgcolor="#FFFF88">
						<TD>Repeat password:</TD>
						<TD><html:password name="workingAccountForm" property="repeatedPassword" /></TD>
					</TR>
				</TABLE>
				<%@ include file="IncludeAccountFields.jsp"%>
			</TD>
		</TR>
	</TABLE>
</div>
<BR>
<div align="center">
	<input style="border: 0;" type="image" src="images/button_submit.gif" />
</div>

</html:form>

<%@ include file="IncludeBottom.jsp"%>