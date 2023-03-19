package com.groupeisi.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Courses implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length=80)
	private String name;
	@Column(nullable = false,length=80)
	private String program;
	@ManyToOne
	@JoinColumn(name ="Inscription_ID")
	private Inscription inscription;
	/*
	 * Constructor
	 */
	public Courses(int id, String name, String program) {
		super();
		this.id = id;
		this.name = name;
		this.program = program;
	}
	public Courses() {
		
	}
	
	public Courses(int id, String name, String program, Inscription inscription) {
		super();
		this.id = id;
		this.name = name;
		this.program = program;
		this.inscription = inscription;
	}
	/**
	 * Getters & Setters
	 * @return id
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return	name
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return program
	 */
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	/**
	 * @return the inscription
	 */
	public Inscription getInscription() {
		return inscription;
	}
	/**
	 * @param inscription the inscription to set
	 */
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	
}
