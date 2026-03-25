package com.solar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	 @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {

	        ErrorResponse error = new ErrorResponse(
	                ex.getMessage(),
	                HttpStatus.BAD_REQUEST.value()
	        );

	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
	 
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGlobal(Exception ex) {

	        ErrorResponse error = new ErrorResponse(
	                "Something went wrong. Please contact admin.",
	                HttpStatus.INTERNAL_SERVER_ERROR.value()
	        );

	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
