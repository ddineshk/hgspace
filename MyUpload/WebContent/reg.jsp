<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="css/menuanim.css"/>
<title><bean:message key="jsp.user.reg.title"/></title>
</head>
<body>
<h1>
<bean:message key="jsp.user.reg.title"/>
</h1>
	<html:form action="UsersRegAction.do" method="post">
		<table>
			<tr>
				<td><bean:message key="jsp.user.reg.name" /></td>
				<td><html:text property="users_Name" />
					<font color="red">
						<html:errors property="nameerr" />
					</font>
				</td>
			</tr>
			<tr>
				<td><bean:message key="jsp.user.reg.pwd" /></td>
				<td><html:password property="users_Pwd" />
					<font color="red">
						<html:errors property="pwderr" />
					</font>
				</td>
			</tr>
			<tr>
				<td><bean:message key="jsp.user.reg.pwd1" /></td>
				<td><html:password property="users_Pwd1" />
					<font color="red">
						<html:errors property="pwd1err" />
						<html:errors property="pwd2err" />
					</font>
				</td>
			</tr>
			<tr>
				<td><bean:message key="jsp.user.reg.gender" /></td>
				<td><html:radio value="M" property="users_Gender" /> <bean:message key="jsp.user.reg.gender.b" /> 
					<html:radio value="F" property="users_Gender" /> <bean:message key="jsp.user.reg.gender.g" />
					<font color="red">
						<html:errors property="gendererr" />
					</font>
				</td>
			</tr>
			<tr>
				<td><bean:message key="jsp.user.reg.phone" /></td>
				<td><html:text property="users_Phone" />
					<font color="red">
						<html:errors property="phoneerr" />
					</font>
				</td>
			</tr>
			<tr>
				<td><bean:message key="jsp.user.reg.dept" /></td>
				<td><html:select property="users_Dept">
						<html:option value="">Select One option</html:option>
						<html:option value="student">Student</html:option>
						<html:option value="employee">Employee</html:option>
						<html:option value="researcher">Researcher</html:option>
						<html:option value="anonymous">Anonymous</html:option>
					</html:select>
					<font color=red>
						<html:errors property="depterr"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>
					<bean:message key="jsp.user.reg.count" />
				</td>
				<td><html:select property="users_Count">
						<c:forEach var="item" begin="1" end="10">
							<html:option value="${item}">${item}</html:option>
						</c:forEach>
					</html:select>
					<font color="red">
						<html:errors property="counterr" />
					</font>
				</td>
			</tr>
			<tr>
				<td><bean:message key="jsp.user.reg.adds" /></td>
				<td><html:text property="users_Adds" style="height: 50px;" />
					<font color="red">
						<html:errors property="addserr" />
					</font>
				</td>
			</tr>
			<tr>
				<td><html:submit>
						<bean:message key="jsp.user.reg.regbut" />
					</html:submit></td>
				<td><html:reset>
						<bean:message key="jsp.user.reg.regre" />
					</html:reset>
				</td>
			</tr>
		</table>
	</html:form>

</body>
</html>