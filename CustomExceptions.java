package main;
//Custom Exceptions
public class CustomExceptions {

}

class InvalidCustomerException extends Exception {
	String message = "Invalid Customer Login";
	
	public String getMessage() {
		return message;
	}
	
}

class InvalidEmployeeException extends Exception {
	String message = "Invalid Employee Login";
	
	public String getMessage() {
		return message;
	}
}

class ProductNotFoundException extends Exception {
	String message = "Product not found";
	
	public String getMessage() {
		return message;
	}
}
