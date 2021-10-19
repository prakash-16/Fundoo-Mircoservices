package com.bridgelabz.fundoonotes.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class NoteDTO {

	@NotBlank(message = "Title cannot be blank")
	private String title;
	@NotBlank(message = "Description cannot be blank")
	private String description;
	private String isPinned;
	private Boolean isTrashed;
	private Boolean isArchived;
	private String color;
	private String reminder;
}
