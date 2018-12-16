<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Customer Manage Order</title>
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

	<jsp:useBean id="OrdItems" class="model.OrderItemDetailsList" scope="page">
		<jsp:setProperty name="OrdItems" property="items" value="${ManOrd.getItems()}"/>
	</jsp:useBean>

	<c:set var="totalPrice" value="0" scope="page"/>
	<c:set var="count" value="1" scope="page"/>
	
	<div class="container">
		<%@ include file="BootStrapHeader.html" %>

		  <table class="table"><tr>
		  	  <th> Order Number </th>
		      <th>Movie Name</th>
		      <th>Ticket Quantity</th>
		      <th>Theatre Name</th>
		      <th>Show Time </th>
		      <th>Total Price</th>
		      <td></td>
		    </tr>
			  <c:forEach items="<%=OrdItems.getItems()%>" var="i">
			  	<tr>
			  	<td>${i.getId()}</td>
			      <td>${i.getMovieName()} </td>
			      <td>${i.getTicketQuantity()} </td>
			      <td>${i.getTheatreName()} </td>
			      <td>${i.getShowTime()}</td>
			      <td><span>$</span>${i.getPrice()}</td>
			      <td><a href="CancelOrder?orderID=${i.getId()}&item=<c:out value="${count}"></c:out>" class="btn btn-danger">Cancel</a></td>    
			    </tr>
			    <c:set var="totalPrice" value="${i.gettotalPrice()}" scope="page"/>
			    <c:set var="count" value="${count +1}" scope="page"/>
			  </c:forEach>   
		  </table>

		<div class="order-details">
			<p>Order Total: <c:out value="${totalPrice}"></c:out></p>
		</div>
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