package com.bridgelabz.fundoonotes.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.config.RestTemplate;
import com.bridgelabz.fundoonotes.entity.UserEntity;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.utils.TokenService;

@Service
public class NoteService implements INoteService {

	@Autowired
	TokenService tokenService;

	@Autowired
	NoteRepository noteRepo;

	@Autowired
	RestTemplate restTemp;

	@Override
	public NoteEntity getNotes(String token, long id) {
		long userId = tokenService.decodeToken(token);
		NoteEntity note = noteRepo.findAll().stream().filter(n -> ((n.getId() == id) && (n.getUserId() == userId))).findAny().get();
		if(note == null) {
			throw new FundoNotesException("404","note not found");
		}
		return note;
	}	
	
	@Override
	public NoteEntity createNote(NoteDTO details, String token) {
		long userId = tokenService.decodeToken(token);
		NoteEntity note = new NoteEntity();
		BeanUtils.copyProperties(details, note);
		note.setId(userId);
		noteRepo.save(note);
		return note;
	}
	
	@Override
	public List<NoteEntity> viewNotes(String token){
		long userId = tokenService.decodeToken(token);
		List<NoteEntity> note = noteRepo.findAll();
		return note;
	}
	
	@Override
	public String deleteNote(String token, long id) {
		NoteEntity note = tokenService.decodeToken(token);
		if(note.getIsTrashed()) {
			noteRepo.delete(note);
			return "Deleted note";
		}
		else {
			return "Move to trash";
		}
	}
	

}
