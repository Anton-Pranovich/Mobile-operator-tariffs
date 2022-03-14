<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous" />
	<link href= "resources/tariffCatalog.css"rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<h1>Catalog</h1>
	<table class="table table-bordered">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Name</th>
			<th scope="col">Mobile operator</th>
			<th scope="col">Subscription fee</th>
			<th scope="col">description</th>
		</tr>

		<c:forEach items="${tariffCatalog}" var="tariff">
			<tr>
				<td><a href="/${tariff.id}?name=${tariff.name}&operator=${tariff.operator}&subscriptionFee=${tariff.subscriptionFee}&description=${tariff.description}"><c:out value= "${tariff.id}" > </c:out></a> </td>
				<td><c:out value="${tariff.name}" /></td>
				<td><c:out value="${tariff.operator}" /></td>
				<td><c:out value=" ${tariff.subscriptionFee}" /></td>
				<td><c:out value=" ${tariff.description}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="start">Back</a>
</body>
</html>