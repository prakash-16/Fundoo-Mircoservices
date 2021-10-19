package com.bridgelabz.fundoouser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UserDTO {
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String contactNumber;
}
