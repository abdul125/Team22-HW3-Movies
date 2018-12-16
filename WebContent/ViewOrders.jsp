<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<title>View Order</title>

<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Custom styles -->
</head>

<body>

<%@ include file="BootStrapHeader.html" %>

<jsp:useBean id="Orders" class="model.Orders" scope="page">
	<jsp:setProperty name="Orders" property="ordersList" value="${AllOrders}"/>
</jsp:useBean>

<div class="container" >

  <h2 style="margin-top:90px;">Here is your list of order</h2>
  <table class="table table-bordered table-striped sortable">
    <thead>
   		<tr>
	        <th>Order Number</th>
	        <th>Order Total</th>
	        <th>Order Date</th>
	        <th>Billing Address</th>
	        <th>Details</th>
   		</tr>   
    </thead>

    <tbody>
    	<c:forEach items="<%=Orders.getOrdersList()%>" var="o">
    		<tr>
		        <th>Order Number: ${o.getId()}</th>
		        <th>Order Total: $ ${o.getTotalCost()}</th>
		        <th>Order Date: ${o.getOrderDate()}</th>
		        <th>Billing Address: ${o.getBillingAddress()}</th>
		        <td><a href="ManageOrder?orderID=${o.getId()}" class="btn btn-primary" role="button">View</a></td>
      		</tr>
    	</c:forEach> 
    </tbody>
  </table>
</div>

	<!-- Java scripts files -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!-- End Java script files -->
</body>
</html>
