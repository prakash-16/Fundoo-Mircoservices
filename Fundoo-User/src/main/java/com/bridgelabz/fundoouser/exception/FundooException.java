package com.bridgelabz.fundoouser.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundooException extends RuntimeException{

	private String statusCode;
	private String message;

}
