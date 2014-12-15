<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<td class="label">Name:</td>
			<td>
				<form:input type="text" name="name" path="name" class="control" />
				<br/>
				<div class="error"><form:errors path="name"></form:errors></div>
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