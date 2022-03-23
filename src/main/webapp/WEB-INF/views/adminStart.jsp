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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="catalog">Tariff Catalog</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
      	<li><a href="addTariff">Add tariffs</a></li>
      <li><form action="/logout" method="POST">
				<sec:csrfInput/>
				<input type="submit" value="Logout">
				</form>
				</li>
    </ul>
    <form class="navbar-form navbar-left" action="/user/search" method="get" name="searchForm">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search_tariff">
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form>
  </div>
</nav>

<div class="container">
  <h3>Navbar Forms</h3>
  <p>Use the .navbar-form class to vertically align form elements (same padding as links) inside the navbar.</p>
</div>
</body>
</html>