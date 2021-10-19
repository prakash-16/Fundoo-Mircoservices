package com.bridgelabz.fundoouser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class loginDTO {
	private String emailId;
	private String password;
}
