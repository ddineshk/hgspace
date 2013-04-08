<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty accountForm.account.username}">
	<c:if test="${accountForm.account.displayBanner}">
		<div align="center">asdasasd
			<table style="background-image: url('images/bkg-topbar.gif'); width: 100%;">
				<tr>
					<td align="center"><c:out value="${accountForm.bannerName}" escapeXml="false" />&nbsp;</td>
				</tr>
			</table>
		</div>
	</c:if>
</c:if>
