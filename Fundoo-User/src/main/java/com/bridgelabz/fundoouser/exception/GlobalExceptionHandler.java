package com.bridgelabz.fundoouser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.fundoouser.response.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(FundooException.class)
	public ResponseEntity<Response> handleFundooException(FundooException e){
		Response res = new Response(e.getStatusCode(), e.getMessage(),null);
		return new ResponseEntity<Response>(res,HttpStatus.BAD_GATEWAY);	
	}
}
