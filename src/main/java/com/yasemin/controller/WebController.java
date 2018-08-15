package com.yasemin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.yasemin.model.Note;
import com.yasemin.repo.NoteRepository;
import com.yasemin.service.NoteService;

@Controller
public class WebController {
	

	@Autowired
	NoteService noteService;
	
	@RequestMapping(value = {"/home","/"}, method = RequestMethod.GET)
	public String inde(Model model) {
		model.addAttribute("noteList", noteService.getNoteList());
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String indet(Model model) {
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMusteriNot(HttpServletRequest request
			,@RequestParam("definition") String definition
			) {
		noteService.saveNote(new Note(definition));
		return "redirect:/home";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editTeamPage(Model model
							  ,@PathVariable("id") Long id) {
		model.addAttribute("note", noteService.findNoteById(id));
		
		return  "edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String edditingMusteri(@PathVariable Long id
			, Note note) {
	
		Note nt = noteService.findNoteById(id);
		nt.setDefinition(note.getDefinition());
		noteService.saveNote(nt);
		
		return "redirect:/home/";
	} 
	
	@RequestMapping(value = "/noteDelete/{id}", method = RequestMethod.GET)
	public String deleteAjandaNotlar(@PathVariable("id") Long id) {
	  
	    noteService.removeNote(id);
		return "redirect:/home/";
	}
}
