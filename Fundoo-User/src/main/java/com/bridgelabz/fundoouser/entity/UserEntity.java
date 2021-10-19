package com.bridgelabz.fundoouser.entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, unique = true)
	private String firstName;
	private String lastName;
	@Column(nullable = false, unique = true)
	private String emailId;
	@Column(nullable = false, unique = true)
	private String password;
	private String contactNumber;
	private boolean isEmailPresentInDb;
	private boolean isEmailVerified;
	@CreationTimestamp
	private LocalDateTime createdTimeStamp;
	@UpdateTimestamp
	private LocalDateTime updatedTimeStamp;
	

}
