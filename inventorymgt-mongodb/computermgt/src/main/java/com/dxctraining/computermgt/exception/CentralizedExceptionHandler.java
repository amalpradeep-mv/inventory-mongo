package com.dxctraining.computermgt.exception;

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
	  
	    @ExceptionHandler(ComputerNotFoundException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleComputerNotFoundException(ComputerNotFoundException e){
	        System.out.println("inside handleInvalidArgument");
	        String msg=e.getMessage();
	        return msg;
	    }
}
