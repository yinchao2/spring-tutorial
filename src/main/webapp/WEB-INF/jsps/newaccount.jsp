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

<form:form method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
	<table border="0" class="formtable">
		<tr>
			<td class="label">Username:</td>
			<td>
				<form:input type="text" name="username" path="username" class="control" />
				<br/>
				<form:errors path="username" cssClass="error"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td class="label">E-mail:</td>
			<td>
				<form:input type="email" path="email" name="email" class="control" />
				<br/>
				<form:errors path="email" cssClass="error"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td class="label">Password:</td>
			<td>
				<form:input type="password" path="password" name="password" class="control" />
				<br/>
				<form:errors path="password" cssClass="error"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td class="label">Confirm password:</td>
			<td>
				<form:input type="password" path="password" name="confirmpass" class="control" />
			</td>
		</tr>
		
		
		<tr>
			<td></td>
			<td><input type="submit" value="Register" class="control" /></td>
		</tr>
		
		
	</table>
</form:form>
</body>
</html>