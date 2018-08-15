package com.yasemin.service;

import java.util.List;

import com.yasemin.model.Note;

public interface NoteService {

	public List<Note> getNoteList();
	public void saveNote(Note note);
	public Note findNoteById(Long id);
	public void removeNote(Long id);
}
