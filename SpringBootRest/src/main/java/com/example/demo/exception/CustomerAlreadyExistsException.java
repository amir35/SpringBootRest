package com.example.demo.exception;

// Step 3: Creating custom exception
// that can be thrown when
// user tries to add a customer
// that already exists
public class CustomerAlreadyExistsException extends RuntimeException {
	
	private String message;

	public CustomerAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

	public CustomerAlreadyExistsException() {
	}
	
	

}
