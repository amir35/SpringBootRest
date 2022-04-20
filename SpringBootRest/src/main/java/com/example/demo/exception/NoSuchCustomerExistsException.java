//Step 3: Creating custom exception
//that can be thrown when
//user tries to update/delete a
//customer that doesn't exists
package com.example.demo.exception;

public class NoSuchCustomerExistsException extends RuntimeException {

	private String message;

	public NoSuchCustomerExistsException() {}

	public NoSuchCustomerExistsException(String msg)
	{
		super(msg);
		this.message = msg;
	}
}
