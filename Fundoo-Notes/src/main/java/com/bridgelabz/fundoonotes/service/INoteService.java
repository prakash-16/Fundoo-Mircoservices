package com.bridgelabz.fundoonotes.service;

public interface INoteService {
	NoteEntity getNotes(String token, long id);

	NoteEntity createNote(NoteDTO details, String token);

	List<NoteEntity> viewNotes(String token);

	String deleteNote(String token, long id);
}
