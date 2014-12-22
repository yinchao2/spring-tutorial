<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>You are admin!</h2>

<table class="offers">
	<tr>
		<th>Username</th>
		<th>Email</th>
		<th>Authority</th>
		<th>Enabled</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.username}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.authority}" /></td>
			<td><c:out value="${user.enabled}" /></td>
		</tr>
	</c:forEach>
</table>
