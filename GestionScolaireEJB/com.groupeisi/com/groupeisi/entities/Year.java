package com.groupeisi.entities;
import java.io.Serializable;

import javax.persistence.*;
@Entity
public class Year implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length=80)
	private String name;
	@ManyToOne
	@JoinColumn(name = "Inscription_ID")
	private Inscription  inscription;
	/*
	 * Constructor
	 */
	public Year(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Year() {
		// TODO Auto-generated constructor stub
	}
	
	public Year(int id, String name, Inscription inscription) {
		super();
		this.id = id;
		this.name = name;
		this.inscription = inscription;
	}
	/*
	 * Getters & setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
