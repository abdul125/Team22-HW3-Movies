<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Search Result</title>

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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
<script>

	function updateCart() {		
		var tickets = $("#ticketQuantity").val();
		var price = parseInt('${showing.pricePerSeat}') * tickets;
		//alert(price);

		$.post("UpdateShoppingCart", {
			ID : '${showing.movieID}',
			tickets : tickets,
			price: price,
			showingID: '${showing.getId()}', 
			name: '${showing.movieName}',
			theatre: '${showing.theatreName}',
			time: '${showing.showTime}',
			Add: 'True' 
		}, function(data, status) {
			//alert("callback was called " + data);
			if (data == 0) {
				$("#response").text("Failed: Could not add item to cart");
				$("#cartResponse").fadeIn();
			} else if (data == 1) {
				$("#response").text("Your item has been successfully added to the cart.");
				$("#cartResponse").fadeIn();
				$("#showingDetails").fadeOut();
			}
		});
	}
	
	function addReview() {
		var newRating = $("#newRating").val();
		var newReview = $("#newReview").val().trim();
		
		//alert(newRating+" Out of 5 "+ "Your Revewi:"+newReview );

		$.post("CustomerReview", {
			ID : '${showing.movieID}',
			rating : newRating,
			userReview : newReview
			
		}, function(data, status) {
			//alert("callback was called " + data);
			if (data == 0) {
				alert("Error: Unable to add review; make sure you rate the movie and add your opinion");
			} else if (data == 1) {
				$("#reviewTable").load("MovieDetailsAndSelection?movie=${showing.movieName} #reviewTable");
				$("#newRating").val("");
				$("#newReview").val("");
			}
		});
	}
	
	
	// a function
	function showShowingDetails(){
		$("#showingDetails").fadeIn();
		$("#cartResponse").fadeOut();
	}
	
	function ContinueShopping(){
		window.location = "CustomerHomePage";
	}
	
	function checkout(){
		window.location= "ViewAndCheckoutShoppingCart.jsp";
	}
	
</script>
</head>

<body>
<div id="BootStrapHeader">
	<%@ include file="BootStrapHeader.html"%>
</div>
	
	<div class="container">		

		<button class="btn btn-default" onclick="window.history.back();">Back</button>
		<a href="CustomerHomePage" class="btn btn-primary">Home</a>
		
		 <br/><br/>
		 <div id="cartResponse" style=display:none;>
		 	<div id="response"></div>
		 	<input type="button" class="btn btn-primary" value="Checkout" onClick="checkout()"/>
		 	<input type="button" class="btn btn-primary" value="Continue Shopping" onClick="ContinueShopping()"/>
		 	<input type="button" class="btn btn-primary" value="Add additional tickets to same showing" onClick="showShowingDetails()"/>
		 </div>
		 
		<div id="showingDetails" class="product-details row">
			<div class="col-sm-4 col-md-5">
				<img src="<c:url value="${showing.posterThumbNail}"/>" />
			</div>
			<div class="col-sm-8 col-md-5">
				<p>
					<strong>Movie Name: </strong>
					<c:out value="${showing.movieName}"></c:out>
				</p>
				<p>
					<strong>Rating: </strong>
					<c:out value="${showing.rating}"></c:out>
				</p>
				<p>
					<strong>Show Time: </strong>
					<c:out value="${showing.showTime}"></c:out>
				</p>
				<p>
					<strong>Price: </strong>$
					<c:out value="${showing.pricePerSeat}"></c:out>
				</p>
				<p><strong>Ticket Quantity:</strong> <select name="ticketQuantity"
					id="ticketQuantity">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				</p>
				<p>
					<strong>Available seats: </strong>
					<c:out value="${showing.numberAvailableSeats}"></c:out>
				</p>
				<h4>Description:</h4>
				<p>
					<c:out value="${showing.description}"></c:out>
				</p>
				<div class="col-sm-4 col-md-5">					
					<input type="button" class="btn btn-primary" value="Add to Cart" onClick="updateCart()"/>
				</div>
								
			</div>

		</div>

		<br /> <br />
		<div class="customer-review">			
		<!-- Customer Can Comment in the Same page -->
		<!-- <form method=post action="CustomerReview?ID=<'%='movieID'%'>" id="AddReview" > -->
	
		<h3>Add a Review</h3>
		<div style="padding:27px 0px 30px;">
		<form>
			<div class="form-group">
				<label for="newRating">Rate this movie? </label>
				<select name="rating" id="newRating">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				</select>
				<strong>out of 5</strong>
				<!--  <input class="form-control" id="rateingArea" name=rating /> -->
				 
			</div>
			<div class="form-group">
				<label for="reviewArea">Review:</label>
				<textarea class="form-control" id="newReview" name=userReview
					rows="2" cols="6"></textarea>
			</div>
			<input type="button" onclick ="addReview()" class="btn btn-primary" value=submit name=submitReview/>

		</form>
	</div>
	<h3> Reviews</h3>
			<div class="col-sm-8 col-md-7">
			</div>
			<br />
			<br />
			<table class="table" id=reviewTable>
				<c:forEach items="${reviews}" var="r">
					<tr>
						<td>
							<h4>${r.userName}</h4>
							<p><c:out value="${r.review}" escapeXml="true"/></p>
							<p>${r.rating} out 5</p>
							<p>${r.reviewDate}</p>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
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