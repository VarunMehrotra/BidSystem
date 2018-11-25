<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
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
			<li class="nav-item active"><a class="nav-link"
				href="index.html" target="_blank">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="profile-info.html" target="_blank">Profile Info</a></li>
			<li class="nav-item"><a class="nav-link"
				href="order-summary.html" target="_blank">Orders Summary</a></li>
			<li class="nav-item"><a class="nav-link" href="post-item.html"
				target="_blank">Post Item</a></li>
			<li class="nav-item"><a class="nav-link" href="contact-us.html"
				target="_blank">Contact Us</a></li>
		</ul>
	</div>
	</nav> </header>
	<br />
	<br />
	<br />
	<br />
	<div class="col-md-7 order-md-1">
		<br /> <br />
		<h3 class="mb-3" align="center">Post Item</h3>
		<form class="needs-validation" name="PostItem" action="PostItem"
			method="post" novalidate>

			<div class="mb-3">
				<label for="item">Item Title</label> <input type="text"
					class="form-control" name="item" placeholder="Wall Clock" required>
				<div class="invalid-feedback">Please enter item title.</div>
			</div>

			<div class="mb-3">
				<label for="description">Item Description</label>
				<textarea class="form-control" name="description" rows="5" cols="70"
					placeholder="" required></textarea>
				<div class="invalid-feedback">Please enter item description.</div>
			</div>

			<div class="mb-3">
				<label for="price">Initial Bidding Price</label> <input type="text"
					class="form-control" name="price" placeholder="$20" required>
				<div class="invalid-feedback">Please enter item
					initial/minimum bidding price.</div>
			</div>

			<div class="row">
				<div class="col-md-3 mb-3">
					<label for="available-date">Date</label> <input type="date"
						class="form-control" name="available-date"
						placeholder="10/20/2018" required>
					<div class="invalid-feedback">Please enter date.</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="available-time">Time</label> <input type="time"
						class="form-control" name="available-time" placeholder="10:00 PM"
						required>
					<div class="invalid-feedback">Please enter time.</div>
				</div>
			</div>

			<div class="mb-3">
				<label for="file-upload">Upload Item Photo</label> <input
					type="file" class="form-control" name="file-upload" placeholder=""
					required>
				<div class="invalid-feedback">Please upload item photo.</div>
			</div>
			<hr class="mb-4">
			<br />
			<button class="btn btn-primary btn-lg" type="reset">Reset</button>
			<button class="btn btn-primary btn-lg" type="submit">Submit</button>
		</form>
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