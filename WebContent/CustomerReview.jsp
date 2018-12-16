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

<title>Customer Review Page</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
	function ValidateFields() {
		var submit = true;
		
		if ($("#ratingArea").val().length == 0){
			alert("Please rate the movie");
			submit = false;
		} else if (!isNaN($("#rateingArea").val())){
			alert("Please use only integers for rating");
			submit = false;
		} else if ($("#reviewArea").val().length == 0){
			alert("Please fill out a review");
			submit = false;
		}
			
		return submit;
	}
		
</script>
</head>

<body>
	<%@ include file="BootStrapHeader.html"%>


	<%
		String movieID = request.getParameter("ID");
	%>

	<main role="main" class="container">
			      <button class="btn btn-danger" onclick="window.history.back();">  Cancel</button> 
	
	<div class="starter-template ">


<br/>
		<form method=post action="CustomerReview?ID=<%=movieID%>" id="AddReview" >
			<div class="form-group">
				<label for="rateingArea">Rate this movie? </label>
				<select name="rating" id="ratingArea">
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
				<textarea class="form-control" id="reviewArea" name=userReview
					rows="2" cols="6"></textarea>
			</div>
			<input type="submit" class="btn btn-primary" value=submit name=submitReview/>

		</form>

	</div>
	</main>

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