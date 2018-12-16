/**
 * This Javascript handles all of the ajax calls to submit a transaction
 */

// all of this will be done on page load
$(function(){
	// when the submit order button is clicked
	$('#submitOrder').click(function(){
		var validForm = Validate();
		var loggedin = checkIfLoggedIn();
		var bankValid;
		if (validForm && loggedin){	
			bankValid = validateBank();
			if (bankValid){
				$('#ValidOrder').css('color', 'green');
				$('#ValidOrder').fadeIn();
				$('#PaymentInfo').fadeOut();
				var processed = placeOrder();
				if (processed){ 
					//$('#processingOrder').text("Successfully processed your order");
					clearShoppingCart();
				} else {
					$('#processingOrder').text("Your order failed to process. Contact customer service");
				}
			}else{
				$('#InvalidOrder').css('color', 'red');
				$('#InvalidOrder').fadeIn();
			}
		}else if (!loggedin){
			alert("Please log in. Session expired");
			window.location = "Login.jsp";
		}
				
	});
});

function placeOrder(){
	var informationValid = false;
	var object = new Object;
	object.cardNumber = $('[name="cardNumber"]').val();
	object.billingAddress = $('[name="billingAddress"]').val();
	object.shippingAddress = $('[name="shippingAddress"]').val();
	object.ShoppingCart = $('#ShoppingCart').text();
	object.subtotal = $('#SB').text();
	object.userID = $('#userID').text();
	$.ajax({
        type: "Post",
        url: "/Team22-HW3-Banking/PlaceOrder",
        data: JSON.stringify(object),
        contentType: 'application/json',
    	processData: false,
        async: false,
        success: function(data){
        	informationValid = data;
    	},
        failure: function(errMsg) {
            informationValid = false;
        }
  });
	return informationValid;
}

function validateBank(){
	var informationValid = false;
	if ($('#SB').text() != "0"){
		$.ajax({
	        type: "GET",
	        url: "/Team22-HW3-Banking/Bank",
	        data: {
	    		cardHolderName : $('[name="cardHolderName"]').val(),
	    		cardNumber: $('[name="cardNumber"]').val(),
	    		cardType: $('[name="cardType"]').val(),
	    		securityCode: $('[name="securityCode"]').val(),
	    		expiration: $('[name="expiration"]').val(),
	    		subtotal: $('#SB').text()
	    	},
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        async: false,
	        success: function(data){
	        	informationValid = data;
	    	},
	        failure: function(errMsg) {
	            informationValid = false;
	        }
	  });
	}else {
		alert("There is nothing in your current shopping cart");
		informationValid = false;
	}
	
	return informationValid;
}

function Validate(){
	var valid = true;
	// checks if all of the form controls are filled out
	$('.form-control').each(function(i) {
	    if ($(this).val() == null || $(this).val() == undefined || $(this).val() == ''){
	    	$(this).next().css('color', 'red');
	    	$(this).next().fadeIn();
	    	valid = false;
	    } else {
	    	$(this).next().fadeOut();
	    }
	});
	return valid;
}

function checkIfLoggedIn(){
	var isLoggedIn;
	$.ajax({
		type: "POST",
		url: "Login",
		async: false,
		success: function(data){
			isLoggedIn = data;
			return data;
		},
		failure : function(data){
			alert("Failure");
			return false;
		}
	});
	return isLoggedIn;
}

function clearShoppingCart(){
	$.post("UpdateShoppingCart", {clear: true}, function(data, status){
		return data;
	});
}
