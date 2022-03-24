<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="by.itstep.pronovich.dao.impl.TariffDaoImpl"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
  <jsp:include page='header.jsp'>
    <jsp:param name="header" value=""/>
</jsp:include>
<li><a href="addTariff">Add tariffs</a></li>
<li><form action="/logout" method="POST">
  <sec:csrfInput/>
  <input type="submit" value="Logout">
  </form>
  </li>

<main class="main">
  <h3>Navbar Forms</h3>
  <p>Use the .navbar-form class to vertically align form elements (same padding as links) inside the navbar.</p>
</main>
<jsp:include page='footer.jsp'>
	<jsp:param name="footer" value="" />
</jsp:include>
</body>
</html>