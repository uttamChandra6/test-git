package com.newgen.exception;

/**
 * exception to raise when user is not authorized for operations in core.
 * i.e. no records found in user master table.
 * 
 * @author navjot.singh
 *
 */
public class UserNotAuthorizedException extends RuntimeException
{

	public UserNotAuthorizedException(String message) {
		super(message);
	}
	
}
