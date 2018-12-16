<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Confirmation</title>
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
	<%@ include file="BootStrapHeader.html"%>

	<%
		String alert = "";
		String success = request.getParameter("success");
		boolean check = false;
		if (!success.isEmpty()){
			check = Boolean.parseBoolean(success);
		}
		
		if (check){
			alert = "Your Review was successfully added";

		} else {
			alert = "Your Review Failed to add a review , Please try again ";
			
		

		}
	%>
	
	<div class="container">
	<button class="btn btn-default" onclick="window.history.back();">Back</button>
	<a href="CustomerHomePage" class="btn btn-primary">Home</a>
	
	<br/><br/>
	
		<%=alert%>
	</div>
</body>
</html>