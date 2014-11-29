<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<title>create offers</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/docreate">
	<table border="0" class="formtable">
		<tr>
			<td class="label">Name:</td>
			<td><input type="text" name="name" class="control" /></td>
		</tr>
		
		<tr>
			<td class="label">E-mail:</td>
			<td><input type="email" name="email" class="control" /></td>
		</tr>
		
		<tr>
			<td class="label">Your offer:</td>
			<td>
				<textarea name="text" rows="10" cols="10" class="control" ></textarea>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Create offer" class="control" /></td>
		</tr>
		
		
	</table>
</form>
</body>
</html>