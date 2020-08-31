package com.dxctraining.phonemgt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	 

	    @ExceptionHandler(InvalidArgumentException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleInvalidArgument(InvalidArgumentException e){
	        System.out.println("inside handleInvalidArgument");
	        return e.getMessage();
	    }
	    @ExceptionHandler(PhoneNotFoundException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handlePhoneNotFoundException(PhoneNotFoundException e){
	        System.out.println("inside handleInvalidArgument");
	        String msg=e.getMessage();
	        return msg;
	    }
	    
}
