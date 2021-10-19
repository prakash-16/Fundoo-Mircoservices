package com.bridgelabz.fundoouser.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoouser.dto.UserDTO;
import com.bridgelabz.fundoouser.dto.loginDTO;
import com.bridgelabz.fundoouser.dto.updateDTO;
import com.bridgelabz.fundoouser.response.Response;
import com.bridgelabz.fundoouser.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody UserDTO user) {
		Response res = new Response(null, "User registered succuessfully !", service.registerUser(user));
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Response> loginUser(@RequestBody loginDTO login) {
		Response res = new Response(null, "user Login Succesfully !", service.loginUser(login));
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@GetMapping("/details/all/users")
	public ResponseEntity<Response> displayAllUser() {
		Response res = new Response(null, "Displayed all user", service.givingUser());
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@GetMapping("/forgot/password/{email}")
	public ResponseEntity<Response> forgotPasword(@PathVariable String email) {
		service.forgotPassword(email);
		Response res = new Response(null, "Mail sent to user", email);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@PutMapping("reset/password")
	public ResponseEntity<Response> resetPasword(@PathVariable String newPassword, @RequestHeader String token) {
		service.resetPassword(newPassword, token);
		Response res = new Response(null, "Mail sent to user", newPassword);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

	@PutMapping("update/password")
	public ResponseEntity<Response> updatePassword(@RequestHeader String token, @RequestBody updateDTO update) {
		service.updatePassword(token, update);
		Response res = new Response(null, "Mail sent to user", update);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}

}
