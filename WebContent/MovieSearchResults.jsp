<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

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
  </head>

  <body>
  
<%@ include file="BootStrapHeader.html" %>

<form method="get" action=MovieSearchResults>
	<div class="container">
  <h2>Search results for <span style="color:gray; font-style:italic;"></span></h2>
  <table class="table table-bordered table-striped sortable">
    <thead>
      <tr>
        <th>Thumbnail</th>
        <th>Movie Name</th>
        <th>Name of Theatre Building</th>
        <th>Theatre Number</th>
        <th>Number of available seat</th>
        <th>Showtime of the Movie</th>
        <th>Price</th>
        <th>View Movie Details</th>
      </tr>      	
    </thead>
    <tbody>
    	<c:forEach items="${MSR}" var="m">
	      	<tr>
	      		<td><a><img src="${m.thumbNail}"></a></td>
				<td><c:out value="${m.name}"></c:out></td>
				<td><c:out value="${m.theatreBuildingName}"></c:out></td>
				<td><c:out value="${m.theatreNumber}"></c:out></td>
		       	<td><c:out value="${m.numberSeats}"></c:out></td>
		       	<td><c:out value="${m.showTime}"></c:out></td>
		       	<td>$<c:out value="${m.price}"></c:out></td>
		       	<td><a href="MovieDetailsAndSelection?movie=${m.name}" class="btn btn-primary" role="button">View Details</a></td>
	       	</tr>    	
     	</c:forEach>
    </tbody>
  </table>
</div>
</form>

 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>

</body>
</html>
