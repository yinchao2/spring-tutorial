<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<table class="offers">
<tr>
	<th>Name</th>
	<th>Email</th>
	<th>Text</th>
</tr>
<c:forEach var="offer" items="${offers}">
	<tr>
		<td><c:out value="${offer.user.name}" /></td>
		<td><a href="<c:url value='/message?uid=${offer.username}'/>">contact</a></td>
		<td><c:out value="${offer.text}" /></td>
	</tr>
</c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/createoffer">
	<c:choose>
		<c:when test="${hasOffer}">
			Edit or delete offer
		</c:when>
		<c:otherwise>
			create new an offer
		</c:otherwise>
	</c:choose>
</a></p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p><a href="<c:url value='/admin'/>">Admin</a></p>
</sec:authorize>