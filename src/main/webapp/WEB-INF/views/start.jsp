<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
	

	
	<main class="main">
		<div
			class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
			<div class="col-md-8 mx-auto my-5 banner-text">
				<h2 class="display-3 font-weight-weight my-4">If we can
					connect, we can create a better future.</h2>
				<a class="btn btn-info btn-lg" href="#">Contact us</a>
			</div>
			<div class="box-shadow d-none d-md-block">
				<img alt="image"
					src="https://images.prismic.io/korus-connect%2Fe206adad-744c-4362-bd28-f88ebf38beda_asset+14.svg?auto=format%2Ccompress&amp;fit=max&amp;q=50">
			</div>
		</div>

		<div class="col-md-10 px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
			<h2 class="display-4">Best Tariff</h2>
			<p class="lead">Quickly build an effective pricing table for your
				potential customers with this Bootstrap example. It's built with
				default Bootstrap components and utilities with little
				customization.</p>
		</div>

		<div class="container col-md-4">
			<div class="card-deck mb-3 text-center">
				<div class="card mb-4 box-shadow">
					<div class="card-header">
						<h4 class="my-0 font-weight-normal">Pro</h4>
					</div>
					<div class="card-body">
						<h1 class="card-title pricing-card-title">
							$15 <small class="text-muted">/ mo</small>
						</h1>
						<ul class="list-unstyled mt-3 mb-4">
							<li>20 users included</li>
							<li>10 GB of storage</li>
							<li>Priority email support</li>
							<li>Help center access</li>
						</ul>
						<button type="button" class="btn btn-lg btn-block btn-primary">Get
							started</button>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page='footer.jsp'>
		<jsp:param name="footer" value="" />
	</jsp:include>

</body>

</html>