<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<ul style="list-style:none;line-height:28px;">

	<li><spring:url value="/index" var="homeUrl" htmlEscape="true" />
		<a href="${homeUrl}">Home</a>
	</li>

	<li><spring:url value="/viewPerson" var="personListUrl" htmlEscape="true" />
		<a href="${personListUrl}">Person List</a>
	</li>
	<li><spring:url value="/distance" var="distanceUrl" htmlEscape="true"/>
		<a href="${distanceUrl}">Distance</a>
	</li>

</ul>
