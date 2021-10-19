package com.bridgelabz.fundoouser.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoouser.dto.UserDTO;
import com.bridgelabz.fundoouser.dto.loginDTO;
import com.bridgelabz.fundoouser.dto.updateDTO;
import com.bridgelabz.fundoouser.entity.UserEntity;
import com.bridgelabz.fundoouser.entity.repository.UserRepository;
import com.bridgelabz.fundoouser.exception.FundooException;
import com.bridgelabz.fundoouser.utils.EmailService;
import com.bridgelabz.fundoouser.utils.TokenService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	TokenService tokenService;

	@Autowired
	EmailService service;

	@Override
	public UserEntity registerUser(UserDTO user) {
		if (checkEmail(user.getEmailId()) != null) {
			throw new FundooException("404", "User has already registered");
		}
		UserEntity userEnt = new UserEntity();
		BeanUtils.copyProperties(user, userEnt);
		userEnt.setEmailPresentInDb(false);
		userEnt.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity savedUser =  userRepo.save(userEnt);
		String token = tokenService.createToken(savedUser.getId(), new Date (System.currentTimeMillis()+( 180 * 1000)));
		boolean isEmailSent = service.sendMail(user.getEmailId(), "tweetprakash16@gmail.com", "Email Verification Link", "http://localhost:8080/user/verify-email/"+token);
		if(!isEmailSent) {
			throw new FundooException("104","email not sent");
		}
		return userEnt;
	}

	@Override
	public String loginUser(loginDTO login) {
		UserEntity user = checkEmail(login.getEmailId());
		if (user == null) {
			throw new FundooException("204", "User is not found");
		}
		if (!(user.getEmailId().equals(login.getEmailId())
				&& passwordEncoder.matches(login.getPassword(), user.getPassword()))) {
			throw new FundooException("304", "Invalid username or password");
		}
		return tokenService.createToken(user.getId());
	}

	public UserEntity checkEmail(String emailId) {
		UserEntity user = userRepo.findByEmailId(emailId);
		return user;
	}
	
	@Override
	public List<UserEntity> givingUser() {
		return userRepo.findAll();
	}
	
	@Override
	public void verifyEmail(String token) {
		long userId = tokenService.decodeToken(token);
		UserEntity user = userRepo.findById(userId).orElseThrow( () -> new FundooException("104", "user is not verified"));
		user.setEmailVerified(true);
		userRepo.save(user);
	}
	
	@Override
	public void forgotPassword(String email) {
		UserEntity user = userRepo.findByEmailId(email);
		if(user == null){
			throw new FundooException("404", "User not found");
		}
		String token = tokenService.createToken(user.getId(), new Date(System.currentTimeMillis() + (120*1000)));
		Boolean mailSent = service.sendMail(user.getEmailId(), "tweetprakash16@gmail.com", "Reset password link", token);
		if(!mailSent) {
			throw new FundooException("104", "Mail didn't sent to the user");
		}
	}
	
	@Override
	public void resetPassword(String newPassword, String token) {
		long userId = tokenService.decodeToken(token);
		UserEntity user = userRepo.findById(userId).orElseThrow( () -> new FundooException("304", "user is not found to reset password"));
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepo.save(user);
	}
	
	@Override
	public void updatePassword(String token, updateDTO details) {
		long userId = tokenService.decodeToken(token);
		UserEntity user = userRepo.findById(userId).orElseThrow( () -> new FundooException("104", "user is not found to update password"));
		if(!(passwordEncoder.matches(details.getOldPassword(), user.getPassword()))) {
			throw new FundooException("105", "Entered old password is incorrect");
		}
		user.setPassword(passwordEncoder.encode(details.getNewPassword()));
		userRepo.save(user);
		
	}

}
