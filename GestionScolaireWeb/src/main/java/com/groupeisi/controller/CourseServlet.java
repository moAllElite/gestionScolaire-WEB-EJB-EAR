package com.groupeisi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.Interfaces.ICoursesLocal;
import com.groupeisi.entities.Courses;
import com.groupeisi.entities.Inscription;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/Courses")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @EJB
	private ICoursesLocal course_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Courses c=new Courses();
		request.setAttribute("courses", course_dao.list(c));
		RequestDispatcher r=request.getRequestDispatcher("Courses.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Courses c=new Courses();
		//on recupère les valeurs des champs saisis
		String name=request.getParameter("name");
		String program=request.getParameter("program");
		c.setName(name);
		c.setProgram(program);
		//persite in bd
		Inscription i=new Inscription(1,"M1gl");
		c.setInscription(i);
		course_dao.add(c);
		request.setAttribute("courses", course_dao.list(c));
		RequestDispatcher r=request.getRequestDispatcher("Courses.jsp");
		r.forward(request, response);
	}


	
}
