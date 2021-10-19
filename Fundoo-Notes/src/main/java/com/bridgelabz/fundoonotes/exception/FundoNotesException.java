package com.bridgelabz.fundoonotes.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundoNotesException extends RuntimeException {
	private String statusCode;
	private String message;
}
