package com.booking.application.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    	if(ex instanceof ConstraintViolationException) {
    		return handleExceptionInternal(ex, "Constraint Violation Exception", new HttpHeaders(), HttpStatus.CONFLICT, request);
    	} else {
    		return handleExceptionInternal(ex, "", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	}
    }
    
}