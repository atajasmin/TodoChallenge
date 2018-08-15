package com.yasemin.repo;

import org.springframework.data.repository.CrudRepository;

import com.yasemin.model.Note;


public interface NoteRepository extends CrudRepository<Note,Long>{

}
