package com.groupeisi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.Interfaces.IStudentLocal;
import com.groupeisi.entities.Student;


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/Students")
public class ListOfStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @EJB
      private IStudentLocal student_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
		request.setAttribute("students", student_dao.list(s));
		request.getRequestDispatcher("views/students/listeStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stut
		
		doGet(request, response);
	}

}
