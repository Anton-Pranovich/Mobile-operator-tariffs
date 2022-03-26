<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<header>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="#">WebSiteName</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="catalog">Tariff
						Catalog</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">About
						us</a></li>
				<sec:authorize access="hasRole('ADMIN')">
					<li class="nav-item"><a class="nav-link" href="addTariff">Add tariffs</a></li>
					<li class="nav-item">
						<form action="/logout" method="POST">
							<sec:csrfInput />
							<input class="btn btn-light" type="submit" value="Logout">
						</form>
					</li>
				</sec:authorize>
				<sec:authorize access="!hasRole('ADMIN')">
					<li class="nav-item"><a class="btn btn-light" href="/login">Log In</a></li>
				</sec:authorize>
			</ul>
			<form class="form-inline mt-2 mt-md-0" action="/search" method="get"
				name="searchForm">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search" name="search_tariff">
				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</header>