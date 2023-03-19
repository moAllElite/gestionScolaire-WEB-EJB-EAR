package com.groupeisi.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Entity(name = "student")
@Table(name = "student")
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length=80)
	private String firstName;
	@Column(nullable = false,length=80)
	private String	lastName;
	@Column(nullable = false,length=80,columnDefinition = "Date")
	private Date birthdate;
	@Column(nullable = false,length=13)
	private String phone;
	@ManyToOne
	@JoinColumn(name = "INSCRIPTION_ID")
	private Inscription inscription=new Inscription();
	
	/*
	 * contructor
	 */
	public Student(int id, String firstName, String lastName, Date birthdate, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.phone = phone;
	}
	
	
	
	public Student(int id, String firstName, String lastName, Date birthdate, String phone, Inscription inscription) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.phone = phone;
		this.inscription = inscription;
	}



	public Student() {
		// TODO Auto-generated constructor stub
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	
}
