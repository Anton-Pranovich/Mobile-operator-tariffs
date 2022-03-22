<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.title" /></title>
<style type="text/css">
.red {
	color: red;
}
</style>
</head>
<body>

<%-- 	<div
		style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		<a href="${pageContext.request.contextPath}/user/updateTariff/${tariff.id}?lang=en">Tariff
			(English)</a> &nbsp;|&nbsp; <a
			href="${pageContext.request.contextPath}/user/updateTariff/${tariff.id}?lang=ru">Тариф
			(Russian)</a>
	</div> --%>

	<form:form modelAttribute="tariff" action="/user/update/${tariff.id}" method="post">
		<p>
			<form:label path="name">
				<spring:message code="label.name" />
				<form:input type="text" path="name" name="name" />
			</form:label>
			<form:errors path="name" cssClass="red" />
		</p>
			<p>
			<form:label path="operator">
				<spring:message code="label.operator" />
				<form:input type="text" path="operator" name="operator" />
			</form:label>
			<form:errors path="operator" cssClass="red" />
		</p>
		<p>
			<form:label path="subscriptionFee">
				<spring:message code="label.subscriptionFee" />
				<form:input type="text" path="subscriptionFee" name="subscriptionFee" />
			</form:label>
			<form:errors path="subscriptionFee" cssClass="red" />
		</p>
			<p>
			<form:label path="callCost">
				<spring:message code="label.callCost" />
				<form:input type="text" path="callCost" name="callCost" />
			</form:label>
			<form:errors path="callCost" cssClass="red" />
		</p>
			<p>
			<form:label path="smsCost">
				<spring:message code="label.smsCost" />
				<form:input type="text" path="smsCost" name="smsCost" />
			</form:label>
			<form:errors path="smsCost" cssClass="red" />
		</p>
			<p>
			<form:label path="numberOfMegabytes">
				<spring:message code="label.numberOfMegabytes" />
				<form:input type="text" path="numberOfMegabytes" name="numberOfMegabytes" />
			</form:label>
			<form:errors path="numberOfMegabytes" cssClass="red" />
		</p>
			<p>
			<form:label path="description">
				<spring:message code="label.description" />
				<form:input type="text" path="description" name="description" />
			</form:label>
			<form:errors path="description" cssClass="red" />
		</p>
		<form:label path="">
			<spring:message code="label.update" var="labelUpdate"></spring:message>
			<input type="submit" value="${labelUpdate}" />
		</form:label>
	</form:form>

		<a href="/user/catalog" >&#8592;	<spring:message code="label.back"></spring:message></a>
	
</body>
</html>