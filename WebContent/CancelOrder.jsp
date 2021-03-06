<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Cancel Order</title>

<!-- Bootstrap core CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles -->
<style>
body {
	padding-top: 5rem;
}

.starter-template {
	padding: 3rem 1.5rem;
	text-align: center;
}
</style>
</head>

<body>
	<%@ include file="BootStrapHeader.html" %>


	<div class="container">
		<h2>Order Number: ${CanOrd.getId()}</h2>

		<table class="table">
			<tr>
				<td>
					<h3>Movie Name: ${CanOrd.getMovieName() }</h3>
					<p>Ticket quantity: ${CanOrd.getTicketQuantity()}</p>
					<p>Price: ${CanOrd.getPrice()}</p>
					<p>Theatre Name: ${CanOrd.getTheatreName()}</p>
					<p>Show Time: ${CanOrd.getShowTime()}</p>
				</td>

				<td>
				<a href="CancelOrderTransaction?orderID=${CanOrd.getId()}&item=${OrderItem}" class="btn btn-primary" role="button">Confirm Cancellation</a>
				<a href="ManageOrder?orderID=${CanOrd.getId()}" class="btn btn-primary" role="button">Discard Cancellation</a>
				</td>
			</tr>
		</table>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
		integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
		crossorigin="anonymous"></script>
</body>
</html>