package com.groupeisi.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.Interfaces.IStudentLocal;
import com.groupeisi.entities.Student;

/**
 * Servlet implementation class ActionStudentServlet
 */
@WebServlet("/")
public class ActionStudentServlet extends HttpServlet {
	 @EJB
		private IStudentLocal student_dao;
		private static final long serialVersionUID = 1L;
	          
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		//String name = new File(getServletContext().getRealPath("/")).getName();
			switch (action) {
			case "/Edit": {
				try {
					EditForm(request, response);
					
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "/update":
				try {
					updateForm(request, response);
					
				} catch (IOException |ServletException | SQLException |ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				break;
			case "/delete":
				try {
					deleteForm(request, response);
				} catch (IOException | SQLException |ServletException e) {
					e.printStackTrace();
				}
				break;
			default:
				
				try {
					ListForm(request,response);
				
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void EditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{	
		int id=Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", student_dao.getStudent(id));
		RequestDispatcher rd=request.getRequestDispatcher("views/students/details.jsp");
		rd.forward(request, response);
	}
	
	protected void ListForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		Student s=new Student();
		request.setAttribute("students", student_dao.list(s));
		request.getRequestDispatcher("views/students/listStudent.jsp").forward(request, response);
	}
	
	protected void updateForm(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException ,SQLException, ParseException{
		try {
			Student s=new	Student();
			int id=Integer.parseInt(request.getParameter("id"));
			s.setId(id);
			String firstName=request.getParameter("firstName").toLowerCase();
			s.setFirstName(firstName);
			String lastName=request.getParameter("lastName").toLowerCase();
			s.setLastName(lastName);
			String phone=request.getParameter("phone").toString();
			s.setPhone(phone);
			String birthdate=request.getParameter("birthdate").toString();
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			Date date=sd.parse(birthdate);
			s.setBirthdate(date);
			request.setAttribute("student", student_dao.update(s));
			response.sendRedirect("Students");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	protected void deleteForm(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException,SQLException{
		int id=Integer.parseInt(request.getParameter("id"));
		Student student=new	Student();
		request.setAttribute("student", student_dao.delete(id, student));
		response.sendRedirect("Students");
	}
	protected void listStudent(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException  {
		RequestDispatcher rd=request.getRequestDispatcher("Students");
		rd.forward(request, response);
	}
}
