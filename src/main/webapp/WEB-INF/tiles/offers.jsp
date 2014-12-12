<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="offers">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>Text</th>
</tr>
<c:forEach var="offer" items="${offers}">
	<tr>
		<td><c:out value="${offer.id}" /></td>
		<td><c:out value="${offer.name}" /></td>
		<td><c:out value="${offer.email}" /></td>
		<td><c:out value="${offer.text}" /></td>
	</tr>
</c:forEach>
</table>