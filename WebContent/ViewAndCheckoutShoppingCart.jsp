<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Search Result</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" rel="stylesheet">

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
<script type="text/javascript">
	function SubmitOrder() {
		window.location = "ConfirmOrder.jsp";
	}
	
	function DeleteShoppingCartItem(itemNum){
		$.ajax({
			type: "POST",
			url: "UpdateShoppingCart",
			data: {
				Delete: true,
				number: itemNum
			},
			async: false,
			success: function(data){
				location.reload();
				//$(".container").load("ViewAndCheckoutShoppingCart.jsp .container");

			},
			failure : function(data){
				alert("Failure");
				return false;
			}
		});
	}
</script>
  </head>
	<%@ include file="BootStrapHeader.html" %>
  <body>
  <jsp:useBean id="ShoppingCart" class="model.ShoppingCart" scope="page">
		<jsp:setProperty name="ShoppingCart" property="items" value="${SC.getItems()}"/>
	</jsp:useBean>
	
	<c:set var="count" value="0" scope="page"/>
		
<div class="container">

<div style="margin-bottom:29px;">
	<a href="CustomerHomePage" class="btn btn-primary">Home</a>
	<button class="btn btn-default" onclick="window.history.back();">Back</button>
	</div>
	
  <h2>Shopping Cart</h2>
  <table class="table"><tr>
      <th> Item #</th>
      <th>Movie Name</th>
      <th>Ticket Quantity</th>
      <th>Theatre Name</th>
      <th>Show Time </th>
      <th>Total Price</th>
      <td></td>
    </tr>
	  <c:forEach items="<%=ShoppingCart.getItems()%>" var="sc">
	  	<tr>
	  	 <td> <c:out value="${count}"></c:out> </td>
	      <td>${sc.getMovieName()} </td>
	      <td>${sc.getTicketQuantity()} </td>
	      <td>${sc.getTheatreName()} </td>
	      <td>${sc.getShowTime()}</td>
	      <td><span>$</span>${sc.getPrice()}</td>
	      <td><a href="javascript:DeleteShoppingCartItem(<c:out value="${count}"></c:out>)" class="btn btn-danger">Delete</a></td>    
	    </tr>
		<c:set var="count" value="${count +1}" scope="page"/>
	  	<c:set var="subtotal" value="${subtotal + sc.getPrice()}" scope="page"/>
	  </c:forEach> 
	  <tr>
		<td colspan="7"><h3>Subtotal: $<c:out value="${subtotal}" ></c:out></h3></td>
		
	  </tr>  
  </table>

  <input type=button class="btn btn-primary" value="Check Out" onClick="SubmitOrder()">

</div>

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