<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Order list</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="../../../../resources/css/page.css" rel="stylesheet"
	type="text/css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page='header.jsp'>
		<jsp:param name="header" value="" />
	</jsp:include>
	<main>
		<h1 class="my-md-3">Order list</h1>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Tariff name</th>
					<th scope="col">Mobile operator</th>
					<th scope="col">First name</th>
					<th scope="col">Last name</th>
					<th scope="col">Phone number</th>
				</tr>
			</thead>
					<tbody>

				<c:forEach items="${orderList}" var="order">
					<tr>
						<td><c:out value="${order.name}" /></td>
						<td><c:out value=" ${order.operator}" /></td>
						<td><c:out value=" ${order.firstName}" /></td>
						<td><c:out value=" ${order.lastName}" /></td>
						<td><c:out value=" ${order.phoneNumber}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<sec:authorize access="hasRole('ADMIN')">
			<a href="/admin/start">Back</a>
		</sec:authorize>
	</main>
		<jsp:include page='footer.jsp'>
		<jsp:param name="footer" value="" />
	</jsp:include>
</body>
</html>