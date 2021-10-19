package com.bridgelabz.fundoonotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.fundoonotes.response.Response;

public class GlobalExceptionHandler {

	@ExceptionHandler(FundoNotesException.class)
	public ResponseEntity<Response> handleException(FundoNotesException e) {
		Response res = new Response(e.getStatusCode(), e.getMessage(), null);
		return new ResponseEntity<Response>(res, HttpStatus.BAD_REQUEST);
	}

}
