package com.grandfather.SpyNotes.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grandfather.SpyNotes.model.Note;
import com.grandfather.SpyNotes.repository.NoteRepository;

@Controller
@RequestMapping({"/", "index"})
public class HomeController 
{
	@Resource
	private NoteRepository repository;
		
	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage(Model model, @ModelAttribute(name = "note") Note note, HttpSession session)
	{
		Note createdNote = (Note) session.getAttribute("newNote");
		
		if (createdNote != null)
		{
			model.addAttribute("note", createdNote);
			session.removeAttribute("newNote");
			
			return "createdNote";
		}
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createNote(Model model, @ModelAttribute(name = "note") Note note, HttpSession session)
	{			
		Note newNote;
		
		try 
		{
			newNote = repository.save(note);
			
			session.setAttribute("newNote", newNote);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		return "redirect:/";
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public String showNote(Model model, @RequestParam(name = "id") Long id) 
	{		
		try
		{
			Note note = repository.findById(id).get();

			model.addAttribute("note", note);
			
			repository.deleteById(id);
		}
		catch (Exception e) 
		{			
			return "redirect:/";
		}
		
		return "showNote";
	}
}
