<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<body>
	<div align="left">
		<h1 align="center">Welcome to JLC BookStore</h1>
	</div>
	<div align="right">
		<c:import url="mymenu.jsp" />
	</div>
	<div align="center">
		<br />
		<h2>
			<a href='<c:url value="viewBooks"/>'> View Books</a>

			<sec:authorize access="hasRole('ADMIN') or hasRole('STOREKEEPER')">
				<br />
				<br />
				<a href='<c:url value="addBook"/>'> Add Book</a>
				<br />
				<br />
				<a href='<c:url value="editBook"/>'> Edit Book</a>
			</sec:authorize>

			<sec:authorize access="hasRole('ADMIN')">
				<br />
				<br />
				<a href='<c:url value="deleteBook"/>'> Delete Book</a>
			</sec:authorize>


			<sec:authorize access="hasRole('CUSTOMER')">
				<br />
				<br />
				<a href='<c:url value="placeOrder"/>'> Place Order</a>
			</sec:authorize>

		</h2>
	</div>
</body>
</html>