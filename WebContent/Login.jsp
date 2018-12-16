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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>

<body>
	<div class=container>
		<form class=form-signin action=Login method=GET>
			<h2 class="form-signin-heading">sign in</h2>
			
			   <input type="text" class="form-control" name="userName"
				placeholder="username" required autofocus/> 
				
				<input
				type="password" class="form-control" name="password"
				placeholder="Password" required />

			<!--  Remember ME -->
			<div class="checkbox">
				<label>
            <input type="checkbox" name="rememberMe" value="remember-me"> Remember me
          	</label>
				
			</div>
			<button class="btn btn-lg btn-primary btn-block"
				style="margin-bottom: 30px;" type="submit">Sign in</button>

			<div style="border-top: 1px solid #888; padding-top: 4px; font-size: 85%">
				<span>Don't have an account!</span> <a href="Registration.jsp">Sign
					Up</a>
			</div>
		</form>
	</div>
	<!-- Java scripts files -->
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
	<!-- End Java script files -->
</body>
</html>
