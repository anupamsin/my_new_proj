package com.cybage.jpql_project.custom_exception;

public class DataNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7236077307537734756L;

	public DataNotFoundException(String message) {
        super(message);
    }
}
