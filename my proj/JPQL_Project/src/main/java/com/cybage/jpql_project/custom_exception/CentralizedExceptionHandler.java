package com.cybage.jpql_project.custom_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CentralizedExceptionHandler {

	@ExceptionHandler({ DataNotFoundException.class })
	public ResponseEntity<String> handleNoDataException(DataNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}