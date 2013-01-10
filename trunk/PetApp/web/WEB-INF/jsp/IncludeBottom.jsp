<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="stickyFooter" style="text-align:center;width:100%;" align="center">
	<p align="center">
		<font color="green"> Running on &nbsp; </font>
		<c:out value="${pageContext.servletContext.serverInfo}" />
	</p>
</div>
</body>
</html>