<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1">
				<title>Insert title here</title>
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
				<link href="../../../../resources/css/page.css" rel="stylesheet" type="text/css">
				<link href="../../../../resources/css/login.css" rel="stylesheet" type="text/css">
				<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
				<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
			</head>

			<body>
				<jsp:include page='header.jsp'>
					<jsp:param name="header" value="" />
				</jsp:include>
				<main>
					<form method="POST" action="login">
						<div class="container col-lg-10  mx-auto login-box">
							<div class="inner-login-box"></div>
							<div class="inner-login-box">
								<h1>LOGIN</h1>
								<div class="form">
									<div class="form-group">
										<label for="username">Your usersname </label>
										<input type="password" id="username" name="username" class="login-form-control">
										<sec:csrfInput />
									</div>

									<div class="form-group">
										<label for="password">Your password</label>
										<input type="password" id="password" name="password" class="login-form-control">
									</div>

									<div>
										<input class="login-button"  type="submit" name="submit"  />
									</div>
									<div>
										<c:if test="${param.error != null}">
											Username or password incorrect
										</c:if>
									</div>
								</div>
							</div>
						</div>

					</form>

				</main>

				<jsp:include page='footer.jsp'>
					<jsp:param name="footer" value="" />
				</jsp:include>
			</body>

			</html>