package com.bridgelabz.fundoonotes.entity;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UserEntity {
	
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	
	@CreationTimestamp
	private LocalDateTime userCreated;
	@UpdateTimestamp
	private LocalDateTime userUpdated;
	
	@OneToMany(targetEntity = NoteEntity.class)
	@JoinColumn(name = "user_id")
	private List<NoteEntity> notes;

}
