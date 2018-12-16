function Validate() {
	var password = document.getElementById("newPass").value;
	var confirmPassword = document.getElementById("confirmNewPass").value;
    if (password != confirmPassword) {
        alert("Confirm Password and New Password do not match.");
        return false;
    }
    return true;
}