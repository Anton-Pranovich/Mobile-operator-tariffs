<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Tariff</title>
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
			<a href="/admin/catalog">&#8592; back</a>
		</div>
		<div class="form-content">
			<div class="form-item">
				<h3 class="form-heading">Update tariff</h3>
				<p class="form-subheading">All fields are required</p>
			</div>
			<form:form modelAttribute="tariff"
				action="/admin/update/${tariff.id}" method="post">
				<div class="form-item">
					<form:label path="name">
						tariff name
						<form:input class="form-control" type="text" path="name"
							name="name" />
					</form:label>
					<form:errors path="name" class="form-error" />
				</div>
				<div class="form-item">
					<form:label path="operator">
						operator name
						<form:input class="form-control" type="text" path="operator"
							name="operator" />
					</form:label>
					<form:errors path="operator" cssClass="red" />
				</div>
				<div class="form-item">
					<form:label path="subscriptionFee">
						subscription fee
						<form:input class="form-control" type="text"
							path="subscriptionFee" name="subscriptionFee" />
					</form:label>
					<form:errors path="subscriptionFee" cssClass="red" />
				</div>
				<div class="form-item">
					<form:label path="callCost">
					call cost
						<form:input class="form-control" type="text" path="callCost"
							name="callCost" />
					</form:label>
					<form:errors path="callCost" cssClass="red" />
				</div>
				<div class="form-item">
					<form:label path="smsCost">
					sms cost
						<form:input class="form-control" type="text" path="smsCost"
							name="smsCost" />
					</form:label>
					<form:errors path="smsCost" cssClass="red" />
				</div>
				<div class="form-item">
					<form:label path="numberOfMegabytes">
						number of megabytes
						<form:input class="form-control" type="text"
							path="numberOfMegabytes" name="numberOfMegabytes" />
					</form:label>
					<form:errors path="numberOfMegabytes" cssClass="red" />
				</div>
				<div class="form-item">
					<form:label path="description">
						description
						<form:input class="form-control" type="text" path="description"
							name="description" />
					</form:label>
					<form:errors path="description" cssClass="red" />
				</div>
				<div class="form-item">
					<form:label path="">
						<input class="btn btn-dark" type="submit" value="Update" />
					</form:label>
				</div>
			</form:form>

		</div>
	</main>
	<jsp:include page='footer.jsp'>
		<jsp:param name="footer" value="" />
	</jsp:include>
</body>
</html>