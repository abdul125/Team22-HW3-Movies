<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Transaction.js"></script>

	<%@ include file="BootStrapHeader.html" %>

	<jsp:useBean id="ShoppingCart" class="model.ShoppingCart" scope="page">
		<jsp:setProperty name="ShoppingCart" property="items" value="${SC.getItems()}"/>
	</jsp:useBean>

	<c:set var="subtotal" value="0" scope="page"/>

	<script type="text/javascript">
			var cart = new Array();
			<c:forEach items="${SC.items}" var="item">
			    cartItem = new Object();
			    cartItem.movieID = '<c:out value="${item.movieID}"></c:out>';
			    cartItem.ticketQuantity = '<c:out value="${item.ticketQuantity}"></c:out>';
			    cartItem.movieName = '<c:out value="${item.movieName}"></c:out>';
			    cartItem.theatreName = '<c:out value="${item.theatreName}"></c:out>';
			    cartItem.showTime = '<c:out value="${item.showTime}"></c:out>';;
			    cartItem.showingId = '<c:out value="${item.showingId}"></c:out>';
			    cartItem.price = '<c:out value="${item.price}"></c:out>';;
			    cart.push(cartItem);
			</c:forEach>
		
			var jsonCart = JSON.stringify(cart);
			$(function(){
				$('#ShoppingCart').text(jsonCart);
			});
	</script>
	<body>
		<div id="ValidOrder" style=display:none;> 
			<div class="alert alert-success">
  			<strong>Success!</strong> Your Order was successfully processed 	
		</div>
			<input type="button" class="btn btn-primary" onClick="window.print()" value="Print Transaction"/>	
			<!-- <div id="processingOrder">Processing....</div>	 -->
		</div>
		
		<div id="InvalidOrder" style=display:none;>
			<div class="alert alert-warning">
  		 		Your Order was NOT processed. Please try again later.	
			</div>						
		</div>
	
		<div id="form" class="container">
		<h2>Your Transaction</h2>

		<table class="table">
			<c:forEach items="<%=ShoppingCart.getItems()%>" var="sc">
			<tr>
				<td><strong>Movie Name:</strong> ${sc.getMovieName()}</td>
				<td><strong>Quantity:</strong> ${sc.getTicketQuantity()}</td>
				<td><strong>Total Price:</strong> <span>$</span>${sc.getPrice()}</td>
				<td><strong>Theatre Name:</strong> ${sc.getTheatreName()}</td>
			</tr>
			<c:set var="subtotal" value="${subtotal + sc.getPrice()}" scope="page"/>
			</c:forEach>
			<tr>
				<td colspan="4"><h3>Subtotal: $<c:out value="${subtotal}"></c:out></h3></td>
			</tr>
		</table>
		
		<div id="PaymentInfo">
		
		<h3>Payment Information</h3>

		<div style="max-width: 30em;">
				
			<div class="form-group">
				Card Holder Name: <input type="text" class="form-control" name="cardHolderName"	placeholder="Card Holder">
				<div class="validate" style=display:none;>Please enter Card Holder Name</div>
			</div>

			<div class="form-group">
				<select class="form-control" name="cardType">
					<option value="visa">Visa</option>
					<option value="master">Master</option>
					<option value="discover">Discover</option>
				</select>
			</div>

			<div class="form-group">
				Card Number: <input type="text" class="form-control" name="cardNumber" placeholder="Card Number"/>
				<div id="cardNumberValidation" class="danger" style=display:none;>Please enter card number</div>
			</div>

			<div class="form-group">
				Security Code: <input type="text" class="form-control" name="securityCode" placeholder="Security Code" maxlength="3">
				<div class="validate" style=display:none;>Please enter Security Code</div>
			</div>

			<div class="form-group">
				Card Expiration: <input type="Date" class="form-control" name="expiration" placeholder="Card Expiration yyyy-MM-dd">
				<div class="validate" style=display:none;>Please enter card Expiration</div>
			</div>

			<div class="form-group">
				Billing Address: <input type="text" class="form-control" name="billingAddress" placeholder="Billing Address">
				<div class="validate" style=display:none;>Please enter billing address</div>
			</div>

			<div class="form-group">
				Shipping Address: <input type="text" class="form-control" name="shippingAddress" placeholder="Shipping Address">
				<div class="validate" style=display:none;>Please enter shipping address</div>
			</div>

			<input id="submitOrder" type="button" class="btn btn-primary" value="Confirm Payment" onClick="parent.scrollTo(0, 0); return true"/><br>
						
			<br>
		</div>

		<a href="ViewAndCheckoutShoppingCart.jsp" class="btn btn-danger" >Cancel Payment</a>
		</div>
	</div>
	<br /></br/>
	<div id="SB" style=display:none;><c:out value="${subtotal}"></c:out></div>
	<div id="userID" style=display:none;>${userBean.getId()}</div>
	<div id="ShoppingCart" style=display:none;>${SC.getItems()}</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
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
