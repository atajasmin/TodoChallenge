package com.yasemin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasemin.model.Note;
import com.yasemin.repo.NoteRepository;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteRepository noteRepo;
	
	@Override
	public List<Note> getNoteList()
	{
		List<Note> noteList = new ArrayList<>();
		for(Note note : noteRepo.findAll())
		{
			Note nt = new Note(note.getId(),note.getDefinition());
			noteList.add(nt);
		}
		return noteList;
	}
	
	@Override
	public void saveNote(Note note) {
		noteRepo.save(note);
	}

	@Override
	public Note findNoteById(Long id)
	{//TODO Optional boş olabilir Handler oluştur
		return noteRepo.findById(id).get();
	}
	
	@Override
	public void removeNote(Long id) {
		 noteRepo.deleteById(id); 
	}
}
