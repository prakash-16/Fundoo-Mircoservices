package com.bridgelabz.fundoouser.service;

import java.util.List;

import com.bridgelabz.fundoouser.dto.UserDTO;
import com.bridgelabz.fundoouser.dto.loginDTO;
import com.bridgelabz.fundoouser.dto.updateDTO;
import com.bridgelabz.fundoouser.entity.UserEntity;

public interface IUserService {
	
	UserEntity registerUser(UserDTO user);

	String loginUser(loginDTO login);

	void verifyEmail(String token);

	void forgotPassword(String email);

	void resetPassword(String newPassword, String token);

	void updatePassword(String token, updateDTO details);

	List<UserEntity> givingUser(); 

}
