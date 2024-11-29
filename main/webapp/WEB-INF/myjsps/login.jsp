<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
input, table {
	font-size: 25px;
	margin: 10px;
}
</style>
</head>

<body>
	<div align="left">
		<h1 align="center">Welcome to JLC BookStore</h1>
	</div>
	<hr />
	<div align="center">
		<h2 align="center">
			<c:if test="${param.error != null}">
				<font color="red" size=5> Invalid username and password. </font>
			</c:if>

			<c:if test="${param.logout != null}">
				<font color="red" size=5>You have logged out successfully.</font>
			</c:if>
		</h2>
	</div>

	<div align="center">
		<form name='loginForm' action="/login" method='POST'>
			<table>
				<tr>
					<td align="center" colspan="2">
						<h2>User Login Form</h2>
					</td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" /> <input
						type="submit" value="LOGIN"></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<h2>
			<b> <a href='<c:url value="showRegister"/>'> New User
					Register Here </a>
			</b>
		</h2>
	</div>
</body>
</html>