package com.groupeisi.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.ejb.EJB;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.Interfaces.IStudentLocal;
import com.groupeisi.entities.Inscription;
import com.groupeisi.entities.Student;

/**
 * Servlet implementation class InscriptionServlet
 */

@WebServlet("/AddStudent")
public class StudentServlet extends HttpServlet {
	 @EJB
	private IStudentLocal student_dao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/students/addStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
		String firstNameText=request.getParameter("firstName").toLowerCase();
		String lastNameText=request.getParameter("lastName").toLowerCase();
		String birthdateText=request.getParameter("birthdate");
		String phoneText=request.getParameter("phone").toString();
		Inscription i=new Inscription(1,"M1gl");
		s.setInscription(i);
		DateFormat  sm = new SimpleDateFormat("yyyy-MM-dd");  
		
		try {  
		    Date date = sm.parse(birthdateText);  
		    s.setBirthdate(date);
		} catch (ParseException e) {
		    e.printStackTrace();  
		}
		s.setFirstName(request.getParameter("firstName"));
		s.setLastName(lastNameText);
		s.setPhone(phoneText);
			//insert in base
		student_dao.add(s);
		request.setAttribute("students", student_dao.list(s));
		request.getRequestDispatcher("listeStudent.jsp").forward(request, response);
			
	}
	

}
