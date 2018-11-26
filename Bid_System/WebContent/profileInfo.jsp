<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Information</title>
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
		<li class="nav-item active"><a class="nav-link"
			href="welcome-page.jsp" target="_blank">Home <span
				class="sr-only">(current)</span></a></li>
		<li class="nav-item"><a class="nav-link" href="profileInfo.jsp"
			target="_blank">Profile Info</a></li>
		<li class="nav-item"><a class="nav-link"
			href="order-summary.html" target="_blank">Orders Summary</a></li>
		<li class="nav-item"><a class="nav-link" href="postItem.jsp"
			target="_blank">Post Item</a></li>
		<li class="nav-item"><a class="nav-link" href="contact-us.html"
			target="_blank">Contact Us</a></li>
	</div>
	</nav> </header>
	<br />
	<br />
	<br />
	<br />
	<div class="col-md-8 order-md-1">
		<h3 align="center">Profile Information</h3>

		<form action="FetchProfileServlet" method="get">
			<div class="container" class="mb-3">
				<hr>

				<label for="name"><b>Name</b></label> <input type="text"
					class="form-control" name="name" required> <br /> 
					<label
					for="phone"><b>Phone</b></label> <input type="text"
					class="form-control" name="phone" required> <br /> 
					<label
					for="address"><b>Address</b></label> <input type="text"
					class="form-control" name="address" required> <br /> 
					<label
					for="email"><b>Email</b></label> <input type="text"
					class="form-control" name="email" required> <br /> 
					<label
					for="username"><b>Username</b></label> <input type="text"
					class="form-control" name="username" required> <br />  <br />
				<div class="mb-4">
					<button type="reset" class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Save</button>
				</div>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>