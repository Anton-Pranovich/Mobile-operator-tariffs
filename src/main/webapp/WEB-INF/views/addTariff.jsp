<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
			<%@ page session="false" %>
				<!DOCTYPE html>
				<html>
				<head>
					<meta charset="UTF-8">
					<meta name="viewport" content="width=device-width, initial-scale=1">
					<title>
						<spring:message code="label.title" />
					</title>
					<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
					<link href="../../../../resources/css/addTariff.css" rel="stylesheet" type="text/css">
					<link href="../../../../resources/css/page.css" rel="stylesheet" type="text/css">
					<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
					<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
					<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
				</head>

				<body>
					<jsp:include page='header.jsp'>
						<jsp:param name="header" value="" />
					</jsp:include>

					<main>
						<div class="content-header">
							<a href="start">&#8592; <spring:message code="label.back"></spring:message></a>

							<div class="languages">
								<a href="${pageContext.request.contextPath}/admin/addTariff?lang=en">Tariff
									(English)</a> &nbsp;|&nbsp; <a
									href="${pageContext.request.contextPath}/admin/addTariff?lang=ru">Тариф
									(Russian)</a>
							</div>
						</div>

						<div class="form-content">
							<div class="form-item">
								<h3 class="form-heading">
									<spring:message code="label.heading"></spring:message>
								</h3>
								<p class="form-subheading">
									<spring:message code="label.requirements"></spring:message>
								</p>
							</div>

							<form:form modelAttribute="tariff" action="" method="post">
								<div class="form-item">
									<form:label path="name">
										<spring:message code="label.name" />
										<form:input class="form-control" type="text" path="name" name="name" />
									</form:label>
									<form:errors path="name" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="operator">
										<spring:message code="label.operator" />
										<form:input class="form-control" type="text" path="operator" name="operator" />
									</form:label>
									<form:errors path="operator" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="subscriptionFee">
										<spring:message code="label.subscriptionFee" />
										<form:input class="form-control" type="text" path="subscriptionFee"
											name="subscriptionFee" />
									</form:label>
									<form:errors path="subscriptionFee" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="callCost">
										<spring:message code="label.callCost" />
										<form:input class="form-control" type="text" path="callCost" name="callCost" />
									</form:label>
									<form:errors path="callCost" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="smsCost">
										<spring:message code="label.smsCost" />
										<form:input class="form-control" type="text" path="smsCost" name="smsCost" />
									</form:label>
									<form:errors path="smsCost" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="numberOfMegabytes">
										<spring:message code="label.numberOfMegabytes" />
										<form:input class="form-control" type="text" path="numberOfMegabytes"
											name="numberOfMegabytes" />
									</form:label>
									<form:errors path="numberOfMegabytes" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="description">
										<spring:message code="label.description" />
										<form:input class="form-control" type="text" path="description"
											name="description" />
									</form:label>
									<form:errors path="description" class="form-error" />
								</div>
								<div class="form-item">
									<form:label path="">
										<spring:message code="label.submit" var="labelSubmit"></spring:message>
										<input class="btn btn-dark" type="submit" value="${labelSubmit}" />
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