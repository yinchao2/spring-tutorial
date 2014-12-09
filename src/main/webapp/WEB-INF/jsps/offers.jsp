<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Current Offers</title>
</head>
<body>

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


</body>
</html>