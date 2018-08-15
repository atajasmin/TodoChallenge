package com.yasemin.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yasemin.model.Note;
import com.yasemin.repo.NoteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class NoteServiceTest {

	@Mock
	private NoteRepository noteRepository;
	
	@InjectMocks
	private NoteServiceImpl noteService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	public void noteGetNoteList(){
		List<Note> noteList = new ArrayList<Note>();
		noteList.add(new Note((long)1,"Çarşamba Spor"));
		noteList.add(new Note((long)2,"salı eğitim"));
		when(noteRepository.findAll()).thenReturn(noteList);
		
		List<Note> result= noteService.getNoteList();
		assertEquals(2, result.size());
	}
	
	
	
	
	
}
