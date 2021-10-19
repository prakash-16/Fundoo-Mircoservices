package com.bridgelabz.fundoonotes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
	
	@Autowired
	INoteService service;
	
	@PostMapping("/add/note")
	public ResponseEntity<Response> addNote(@RequestBody NoteDTO noteDto, @RequestHeader String token){
		service.createNote(noteDto, token);
		Response res = new Response("Note added successfully", noteDto);
		return new ResponseEntity<Response>(res,HttpStatus.OK);
	}
	
	@PostMapping("/view/note")
	public ResponseEntity<Response> viewNote(@PathVariable String token){
		List<NoteEntity> note = service.viewNotes(token);
		Response res = new Response("Displaying all notes", note);
		return new ResponseEntity<Response>(res,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/note")
	public ResponseEntity<Response> deleteNote(@RequestParam long noteId, @RequestHeader String token){
		String message = service.deleteNote(token, noteId);
		Response res = new Response("Note deleted successfully", message);
		return new ResponseEntity<Response>(res,HttpStatus.OK);
	}
