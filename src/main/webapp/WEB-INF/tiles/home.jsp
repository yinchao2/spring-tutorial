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

<script type="text/javascript">
	
	function updateMessageLink(data) {
		$("#numberMessages").text(data.number);
	}
	
	function onLoad() {
		updatePage();
		window.setInterval(updatePage, 5000);
	}
	
	function updatePage() {
		$.getJSON("<c:url value="/getmessages"/>", updateMessageLink);
	}

	$(document).ready(onLoad);
</script>
