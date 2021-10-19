package com.bridgelabz.fundoonotes.entity;

import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteEnity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	private String isPinned;
	private Boolean isTrashed;
	private Boolean isArchived;
	private String color;
	private String reminder;

	@CreationTimestamp
	private LocalDateTime createdTimeStamp;
	@UpdateTimestamp
	private LocalDateTime updateTimeStamp;

	

}
