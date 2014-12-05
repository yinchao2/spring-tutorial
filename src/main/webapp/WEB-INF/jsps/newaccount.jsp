<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<title>create offers</title>
</head>
<body>
<h2>Create New User Account: </h2>

<form:form method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
	<table border="0" class="formtable">
		<tr>
			<td class="label">Username:</td>
			<td>
				<form:input type="text" name="username" path="username" class="control" />
				<br/>
				<div class="error"><form:errors path="username"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">E-mail:</td>
			<td>
				<form:input type="email" path="email" name="email" class="control" />
				<br/>
				<div class="error"><form:errors path="email" cssClass="error"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Password:</td>
			<td>
				<form:password path="password" name="password" class="control" />
				<br/>
				<div class="error"><form:errors path="password" cssClass="error"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Confirm password:</td>
			<td>
				<input type="password" name="confirmPassword" class="control" />
			</td>
		</tr>
		
		
		<tr>
			<td></td>
			<td><input type="submit" value="Create Account" class="control" /></td>
		</tr>
		
		
	</table>
</form:form>
</body>
</html>