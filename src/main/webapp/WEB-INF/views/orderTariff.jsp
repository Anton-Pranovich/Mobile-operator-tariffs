<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Order</title>
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
	<div class="content-header">
			<sec:authorize access="hasRole('ADMIN')">
			<a href="/admin/catalog">&#8592; back</a>
		</sec:authorize>
		<sec:authorize access="!hasRole('ADMIN')">
			<a href="/catalog">&#8592; back</a>
		</sec:authorize>
		</div>
			<div class="form-content">
							<div class="form-item">
								<h3 class="form-heading">
									<spring:message code="label.headingOrder"></spring:message>
								</h3>
								<p class="form-subheading">
									<spring:message code="label.requirements"></spring:message>
								</p>
							</div>
	<form:form modelAttribute="order" action="/orderTariff"
			method="post">
			<div class="form-item">
				<form:label path="name">
					<spring:message code="label.name" />
					<form:input class="form-control" type="text" path="name"
						name="name" />
				</form:label>
			<form:errors path="name" class="form-error" />
			</div>
		 		<div class="form-item">
				<form:label path="operator">
					<spring:message code="label.operator" />
					<form:input class="form-control" type="text" path="operator"
						name="operator" />
				</form:label>
				<form:errors path="operator" cssClass="red" />
			</div>
			
			
		
			<div class="form-item">
				<form:label path="firstName">
					<spring:message code="label.firstName" />
					<form:input class="form-control" type="text" path="firstName"
						name="firstName" />
				</form:label>
				<form:errors path="firstName" cssClass="red" />
			</div>
			
				
		 	<div class="form-item">
				<form:label path="lastName">
					<spring:message code="label.lastName" />
					<form:input class="form-control" type="text" path="lastName"
						name="lastName" />
				</form:label>
				<form:errors path="lastName" cssClass="red" />
			</div>
			<div class="form-item">
				<form:label path="phoneNumber">
					<spring:message code="label.phoneNumber" />
					<form:input class="form-control" type="text" path="phoneNumber"
						name="phoneNumber" />
				</form:label>
				<form:errors path="phoneNumber" cssClass="red" />
			</div>
			<div class="form-item">
				<form:label path="">
					<spring:message code="label.order" var="labelOrder"></spring:message>
					<input class="btn btn-dark" type="submit" value="${labelOrder}" />
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