<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
	
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/admin.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="login">
		<div class="login">
			<div class="container">
				<div class="col-lg-12 login-box">
					<div class="col-lg-6 left-box"></div>
					<div class="col-lg-6 right-box">
						<h1>LOGIN</h1>
						<div class="form">
							<div class="form-group">
								<label for="username">Your usersname </label> 
								<input type="password"
									id="username"  name="username" class="form-control">
									<sec:csrfInput/>
							</div>

							<div class="form-group">
								<label for="password">Your password</label> <input
									type="password" id="password" name="password" class="form-control">
							</div>

							<div class="login-button">
									<input type="submit" name="submit" />
							</div>
							<div>
							<c:if test="${param.error != null}">
							Username or password incorrect
							</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>