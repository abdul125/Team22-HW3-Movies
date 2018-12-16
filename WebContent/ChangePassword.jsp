<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<!-- Bootstrap core CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles -->
<style>
body {
	padding-top: 5rem;
}


</style>
<script src="js/main.js"></script>
</head>
<body>
<%@ include file="BootStrapHeader.html" %>
<div class="container">

<form method=post action=UpdatePassword onSubmit="return Validate()">
 <div class="form-group">
 <div style="color: #FF0000;">${msg}</div>
    <label for="oldPassword">Current password</label>
    <input type="password" class="form-control" id="oldPassword" name="oldPass" placeholder="current password" required>
  </div>
   <div class="form-group">
    <label for="newPassword">New password</label>
    <input type="password" class="form-control" id="newPassword" name="newPass" placeholder="New password" required>
  </div>
 
   <div class="form-group">
    <label for="cnewPassword">Confirm your new password</label>
    <input type="password" class="form-control" id="cnewPassword" name="confirmNewPass" placeholder="Confirm New password" requireds>
  </div>
  <input type="submit" value="Change Password" class="btn btn-primary" name=btnpass/>

</form>

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