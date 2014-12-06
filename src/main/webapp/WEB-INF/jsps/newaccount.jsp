<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-2.1.1.min.js"></script>
<title>create offers</title>
<script type="text/javascript">
	function onLoad() {

		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);

		$("#details").submit(canSubmit);
	}
	
	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		
		if(password != confirmpass) {
			alert("Passwords do not match!")
			return false;
		}
		else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
				
				
			}
		}
	}

	$(document).ready(onLoad);
</script>
</head>
<body>
<h2>Create New User Account: </h2>

<form:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
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
				<div class="error"><form:errors path="email"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Password:</td>
			<td>
				<form:password path="password" name="password" id="password" class="control" />
				<br/>
				<div class="error"><form:errors path="password"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Confirm password:</td>
			<td>
				<input type="password" name="confirmpass" id="confirmpass" class="control" />
				<div id="matchpass"></div>
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