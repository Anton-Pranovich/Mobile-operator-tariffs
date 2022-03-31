<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tariff</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="../../../../resources/css/addTariff.css" rel="stylesheet"
	type="text/css">
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
	<div class="pt-2">
		<sec:authorize access="hasRole('ADMIN')">
			<a href="/admin/catalog">&#8592; back</a>
		</sec:authorize>
		<sec:authorize access="!hasRole('ADMIN')">
			<a href="catalog">&#8592; back</a>
		</sec:authorize>
		</div>
		<h2 class="display-4 my-md-3 text-center">Personal product page
			for mobile tariff</h2>
		<div class="col-md-10 mx-auto my-5">

			<table class="table">
				<tbody>
					<tr>
						<th scope="row">tariff name</th>
						<td>${tariff.name}</td>
					</tr>
					<tr>
						<th scope="row">tariff operator</th>
						<td>${tariff.operator}</td>
					</tr>
					<tr>
						<th scope="row">tariff subscription</th>
						<td>${tariff.subscriptionFee}</td>
					</tr>
					<tr>
						<th scope="row">call cost</th>
						<td>${tariff.callCost}</td>
					</tr>
					<tr>
						<th scope="row">sms cost</th>
						<td>${tariff.smsCost}</td>
					</tr>
					<tr>
						<th scope="row">tariff number of megabytes</th>
						<td>${tariff.numberOfMegabytes}</td>
					</tr>
					<tr>
						<th scope="row">tariff description</th>
						<td>${tariff.description}</td>
					</tr>
				</tbody>
			</table>
			<a
				href="orderTariff/${tariff.id}?name=${tariff.name}&operator=${tariff.operator}">Order
				Tariff</a>
		</div>
	</main>

	<jsp:include page='footer.jsp'>
		<jsp:param name="footer" value="" />
	</jsp:include>
</body>

</html>