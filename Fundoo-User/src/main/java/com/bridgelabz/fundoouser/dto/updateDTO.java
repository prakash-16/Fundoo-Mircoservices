package com.bridgelabz.fundoouser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class updateDTO {
	private String oldPassword;
	private String newPassword;

}
