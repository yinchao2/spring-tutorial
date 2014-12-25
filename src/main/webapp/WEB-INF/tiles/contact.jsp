<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form id="details" method="post" commandName="message">

	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
	
	<table border="0" class="formtable">
		<tr>
			<td class="label">Your name:</td>
			<td>
				<form:input type="text" name="name" path="name" class="control" />
				<br/>
				<div class="error"><form:errors path="name"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Your e-mail:</td>
			<td>
				<form:input type="email" name="email" path="email" class="control" />
				<br/>
				<div class="error"><form:errors path="email"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Subject:</td>
			<td>
				<form:input type="text" name="subject" path="subject" class="control" />
				<br/>
				<div class="error"><form:errors path="subject"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td class="label">Content:</td>
			<td>
				<form:textarea name="content" path="content" class="control" />
				<br/>
				<div class="error"><form:errors path="content"></form:errors></div>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Sent Message" class="control" /></td>
		</tr>
	</table>
</form:form>