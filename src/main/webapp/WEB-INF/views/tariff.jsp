<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>Personal product page for mobile tariff by ID  ${tariff.id}</div>
		<p>tariff name is ${tariff.name}</p>
		<p>tariff operator is ${tariff.operator}</p>
		<p>tariff subscription fee is ${tariff.subscriptionFee}</p>
		<p>tariff call cost is ${tariff.callCost}</p>
		<p>tariff sms cost is ${tariff.smsCost}</p>
		<p>tariff number of megabytes is ${tariff.numberOfMegabytes}</p>
		<p>tariff description is ${tariff.description}</p>

	<a href="catalog">Back</a>
</body>
</html>