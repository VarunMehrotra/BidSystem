<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bid Page</title>
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
	<div>
		<h3 align="center">Bid Information</h3>
		<br />
		<br />
		<form action="PostBidServlet" method="post">
			<div class="row col-md-12">
				<div class="column col-md-4">				
				<label for="itemTitle"><b>Item Title</b></label> 
				<input type="text"
					name="text_itemTitle"  id="text_itemTitle" required> 
				</div>
					<br /> 

				<div class="column col-md-4">

					<img
					 name="text_imageFile" id="text_imageFile" style="width:400" height="200" src="Not Available"> 
				</div>
					<br /> 
				<div class="column col-md-4">
					<label
					for="bidValue"><b>Bid Value</b></label> 

					<input type="text"
					 name="text_bidValue" id="text_bidValue" required> 
				</div>
				</div>
					<br /> 

					<br /> 
					<br />
				<div>
					<button type="reset" class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Submit Bid</button>
				</div>
		</form>
	</div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script>
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var data = xhr.responseText;
				var jsonArray = eval ("(" + data + ")");
				var jsonObject = jsonArray[0];
								
				document.getElementById("text_itemTitle").value = jsonObject.itemTitle;
				document.getElementById("text_imageFile").value = jsonObject.file;
				document.getElementById("text_bidValue").value = jsonObject.biddingPrice;
			}
		}
		xhr.open('GET', 'FetchBidServlet', true);
		xhr.send(null);
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>