<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Access</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<header> <nav
		class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="login.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
			</li>
		</ul>
	</div>
	</nav> </header>
	<br />
	<br />
	<br />
	<br />
	<div class="col-md-8 order-md-1">
		<h3 align="center">Admin Functionality</h3>
		<form name="adminForm" method="post" action="AdminServlet">

			<br />
			<br />
			<h5>Please select the date and time below :-</h5>
			<br />
				<div class="col-md-3 mb-3">
					<label for="available-date">Date</label> 
					<input type="text"
						class="form-control" name="available-date" id="available-date"
						placeholder="2018-09-04" required>
					<div class="invalid-feedback">Please enter date.</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="start-time">Start Time</label>
					<input type="text" class="form-control" id="start-time" name="start-time" placeholder="08:00:00" required>
				</div>
				<div class="col-md-3 mb-3">
					<label for="end-time">End Time</label>
					<input type="text" class="form-control" id="end-time" name="end-time" placeholder="18:00:00" required>
				</div>

			<hr class="mb-4">
			<br />
			<button class="btn btn-primary btn-lg" type="reset">Reset</button>
			<button class="btn btn-primary btn-lg" type="submit">Send</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>