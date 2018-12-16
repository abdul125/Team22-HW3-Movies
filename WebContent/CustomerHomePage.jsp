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

<title>Customer Home Page</title>
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

	<main role="main" class="container">
	<div class="starter-template ">
		<h1>Search for movies</h1>
		<br />
		<form class="form-inline align-items-center"
			style="margin-left: 160px;" method=post action=CustomerHomePage>

			<label for="availableMovies" class="control-label col-sm-2">Theatre Locations: </label> 
			<select class="form-control" name="movieSelection" id="availableMovies">
				<c:forEach items="${theatres}" var="current">
					<option value="${current.id}">${current.name}</option>
				</c:forEach>				
			</select>
			<div class="form-group" style="margin-left: 1%;">
				<input type="text" class="form-control col-xs-2"
					placeholder="search" name="search"  />
			</div>
			<button type="submit" class="btn btn-default" style="margin-left: 1%;">Search</button>
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
