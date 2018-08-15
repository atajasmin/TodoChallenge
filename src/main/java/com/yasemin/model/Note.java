package com.yasemin.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public Long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

	@Column(name = "definition")
	private String definition;
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	

	protected  Note() {
	}
	
	public  Note(String definition) {
		this.definition = definition;
	}
	
	public  Note(Long id,String definition) {
		this.id =id;
		this.definition = definition;
	}
	
	@Override
	public String toString() {
		return String.format("Note[id=%d, definition='%s']", id, definition);
	}
}
