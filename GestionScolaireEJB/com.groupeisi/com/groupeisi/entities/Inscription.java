package com.groupeisi.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
public class Inscription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length=80)
	private String details;
	@OneToMany(mappedBy = "inscription")
	private List<Student> students=new ArrayList<Student>();
	@OneToMany(mappedBy = "inscription")
	private List<Year> years=new ArrayList<Year>();
	@OneToMany(mappedBy = "inscription")
	private List<Courses> courses=new ArrayList<Courses>();
	/*
	 * constructor
	 */
	public Inscription(int id, String details) {
		super();
		this.id = id;
		this.details = details;
	}
	public Inscription() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Inscription(int id, String details, List<Student> students, List<Year> years, List<Courses> courses) {
		super();
		this.id = id;
		this.details = details;
		this.students = students;
		this.years = years;
		this.courses = courses;
	}
	/*
	 * Getters & setters
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
	 * @return details
	 */
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the student
	 */
	public List<Student> getStudent() {
		return students;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(List<Student> students) {
		this.students = students;
	}
	/**
	 * @return the years
	 */
	public List<Year> getYears() {
		return years;
	}
	/**
	 * @param years the years to set
	 */
	public void setYears(List<Year> years) {
		this.years = years;
	}
	
}
