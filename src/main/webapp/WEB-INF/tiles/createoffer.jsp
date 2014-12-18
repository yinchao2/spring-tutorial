<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
	<form:hidden path="id" name="id" />
	<table border="0" class="formtable">
		<tr>
			<td class="label">Your offer:</td>
			<td>
				<form:textarea path="text" name="text" rows="10" cols="10" class="control" ></form:textarea>
				<br/>
				<form:errors path="text" cssClass="error"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Save offer" class="control" /></td>
		</tr>
		<c:if test="${offer.id != 0}">
			<tr>
				<td></td>
				<td><input type="submit" name=delete value="Delete offer" class="control" /></td>
			</tr>
		</c:if>
		
	</table>
</form:form>