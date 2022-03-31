<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Catalog</title>
<style type="text/css">
  .transparent {
  /*   opacity: 0.70; */ 
   }
</style>
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
	<div class="pt-2">
		<sec:authorize access="hasRole('ADMIN')">
			<a href="/admin/start">&#8592; back</a>
		</sec:authorize>
		<sec:authorize access="!hasRole('ADMIN')">
			<a href="start">&#8592; back</a>
		</sec:authorize>
		</div>
		<div class="col-md-10 mx-auto my-5">
		<h1 class="my-md-3">Catalog</h1>
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>

					<th scope="col">Name</th>
					<th scope="col">Mobile operator</th>
					<th scope="col">Subscription fee</th>
					<th scope="col">call Cost</th>
					<th scope="col">sms Cost</th>
					<th scope="col">number Of Megabytes</th>
					<th scope="col">description</th>
					<sec:authorize access="hasRole('ADMIN')">
						<th scope="col">edit tariff</th>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tariffCatalog}" var="tariff">
					<tr>
						<sec:authorize access="hasRole('ADMIN')">
							<td><a
								href="/admin/${tariff.id}?name=${tariff.name}&operator=${tariff.operator}&subscriptionFee=${tariff.subscriptionFee}&callCost=${tariff.callCost}&smsCost=${tariff.smsCost}&numberOfMegabytes=${tariff.numberOfMegabytes}&description=${tariff.description}">
									<c:out value="${tariff.name}" />
							</a></td>
						</sec:authorize>
						<sec:authorize access="!hasRole('ADMIN')">
							<td><a
								href="/${tariff.id}?name=${tariff.name}&operator=${tariff.operator}&subscriptionFee=${tariff.subscriptionFee}&callCost=${tariff.callCost}&smsCost=${tariff.smsCost}&numberOfMegabytes=${tariff.numberOfMegabytes}&description=${tariff.description}"><c:out
										value="${tariff.name}" /></a></td>
						</sec:authorize>
						<td><c:out value="${tariff.operator}" /></td>
						<td><c:out value=" ${tariff.subscriptionFee}" /></td>
						<td><c:out value=" ${tariff.callCost}" /></td>
						<td><c:out value=" ${tariff.smsCost}" /></td>
						<td><c:out value=" ${tariff.numberOfMegabytes}" /></td>
						<td><c:out value=" ${tariff.description}" /></td>
						<sec:authorize access="hasRole('ADMIN')">
							<td>
								<button type="button" class="btn btn-primary mb-2"
									onclick="window.location.href = 'updateTariff/${tariff.id}?id=${tariff.id}&name=${tariff.name}&operator=${tariff.operator}&subscriptionFee=${tariff.subscriptionFee}&callCost=${tariff.callCost}&smsCost=${tariff.smsCost}&numberOfMegabytes=${tariff.numberOfMegabytes}&description=${tariff.description}'">Update</button>
								<button type="button" class="btn btn-primary mb-2"
									onclick="window.location.href = 'tariff/delete?id=${tariff.id}'">Delete</button>
							</td>
						</sec:authorize>
					</tr>
				</c:forEach>
					<c:if test="${fn:length(tariffCatalog) == 0}">
					<h2 style="color: red">&#128532; There is no such tariff in the catalog</h2>
				</c:if>
			</tbody>
		</table>
		<div><img class="w-100 " style="opacity: 0.70" src="https://justarrived.by/media/cache/blog_big/uploads/App/Entity/Blog/abdd5d918045c7851d1fec4a0be62ec5277ca71d.jpeg"></div>
		</div>
	</main>

	<jsp:include page='footer.jsp'>
		<jsp:param name="footer" value="" />
	</jsp:include>
</body>

</html>
