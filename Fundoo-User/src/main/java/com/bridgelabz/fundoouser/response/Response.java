package com.bridgelabz.fundoouser.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Response {
	private String statusCode;
	private String message;
	private Object data;
}
