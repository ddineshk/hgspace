<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
	<h3>Customer Form</h3>

	<s:form action="customer.action" method="post" validate="true">
		<s:textfield name="name" key="name" size="20" />
		<s:textfield name="age" key="age" size="20" />
		<s:textfield name="email" key="email" size="20" />
		<s:textfield name="telephone" key="telephone" size="20" />
		<s:submit method="addCustomer" key="label.add.customer" align="center" />
	</s:form>
</body>
</html>