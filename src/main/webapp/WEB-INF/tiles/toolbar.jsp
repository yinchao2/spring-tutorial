<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a href="${pageContext.request.contextPath}/createoffer">
	<c:choose>
		<c:when test="${hasOffer}">
			Edit or delete offer
		</c:when>
		<c:otherwise>
			create new an offer
		</c:otherwise>
	</c:choose>
</a>
&nbsp;
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="<c:url value='/admin'/>">Admin</a>
</sec:authorize>
&nbsp;
<sec:authorize access="isAuthenticated()">
	<a href="<c:url value='/messages'/>">Messages (<span id="numberMessages">0</span>) </a>
</sec:authorize>