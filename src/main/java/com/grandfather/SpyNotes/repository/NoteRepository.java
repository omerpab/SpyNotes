package com.grandfather.SpyNotes.repository;

import org.springframework.data.repository.CrudRepository;

import com.grandfather.SpyNotes.model.Note;

public interface NoteRepository 
extends CrudRepository<Note, String>
{
	
}
