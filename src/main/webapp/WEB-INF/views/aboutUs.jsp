<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<main class="main">
		<div class="col-md-8 mx-auto">
			<h2 class="pb-3 mb-4 font-italic border-bottom">About us</h2>
			
			<h3>Media contacts</h3>
			<p>
				For media enquiries about Mobile operator financial or corporate
				matters, please contact us at <strong> <a
					href="mailto:mediarelations@test.com" target="_blank"
					rel="noreferrer noopener">mediarelations@test.com </a>
				</strong>.
			</p>
			<p>We monitor our emails seven days a week, and one of the team
				will be back in contact with you as soon as possible – typically
				within an hour.</p>
			<p>
				If your enquiry relates to Mobile operator’s operating company in
				the United Kingdom, please contact the Mobile operator UK Media
				Relations team via email at <strong> <a
					href="mailto:ukmediarelations@test.com" target="_blank"
					rel="noreferrer noopener">ukmediarelations@test.com </a>
				</strong>.
			</p>

			<h3>Customers</h3>
			<p>We are unable to respond to individual customer account
				queries as we do not have access to customer service systems. If you
				have a customer service question, you can find advice and support by
				visiting your local Mobile operator website.</p>
			<p>
				In the United Kingdom, you can dial 191 from your Mobile tariff mobile
				phone or 0333 3040 191 from any other phone. Alternatively, visit <a
					href="#" target="_blank"
					rel="noreferrer noopener"><strong>http://support.mobile-operator.co.uk</strong></a>
				for the full list of online support options.
			</p>
		</div>
	</main>
	<jsp:include page='footer.jsp'>
		<jsp:param name="footer" value="" />
	</jsp:include>
</body>
</html>