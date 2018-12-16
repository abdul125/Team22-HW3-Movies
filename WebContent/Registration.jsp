<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Bootstrap core CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<form class="form-signin" action="Registration" method="Post" onSubmit="return Validate()">
			<h2 class="form-signin-heading">Register to login</h2>
			 <input
				type="text" name="userName" class="form-control"
				placeholder="username" required autofocus>
			<input
				type="password" name="password" id="password" class="form-control"
				placeholder="Password" required/>
				
				<input
				type="password" name="password" id="confirmPassword" class="form-control"
				placeholder="Confirm Password" required/>
				
				<!-- personal Info  -->
				<input
				type="email" name="email" class="form-control"
				placeholder="email" required />
				
				<input
				type="text" name="firstName" class="form-control"
				placeholder="First Name" required />
				
				<input
				type="text" name="lastName" class="form-control"
				placeholder="Last Name" required />
				
				<input
				type="text" name="address" class="form-control"
				placeholder="Address" required />
				
				<input
				type="text" name="city" class="form-control"
				placeholder="City" required />
				
				<input
				type="text" name="state" class="form-control"
				placeholder="State" required />
				

				<input
				type="text" name="postalCode" class="form-control"
				placeholder="postalCode" required />
				
				<input
				type="text" name="phoneNumber" class="form-control"
				placeholder="phone Number" required />
				
				<input
				type="text" name="birthday" class="form-control"
				placeholder="Birthday" required />

			<button class="btn btn-lg btn-primary btn-block" name="registerButton" type="submit">Register</button>
		</form>


	</div>

	<!-- Java scripts files -->
	    <script src="https://getbootstrap.com/docs/3.3/assets/js/ie10-viewport-bug-workaround.js"></script>
	
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.bundle.min.js"
		integrity="sha384-VspmFJ2uqRrKr3en+IG0cIq1Cl/v/PHneDw6SQZYgrcr8ZZmZoQ3zhuGfMnSR/F2"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
		integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
		crossorigin="anonymous"></script>
		<script src="js/main.js"></script>
	<!-- End Java script files -->
</body>
</html>
