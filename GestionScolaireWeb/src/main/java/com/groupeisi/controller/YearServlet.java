package com.groupeisi.controller;

import java.io.IOException;
//import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.Interfaces.IYearLocal;
import com.groupeisi.entities.Year;

/**
 * Servlet implementation class YearServlet
 */
@WebServlet("/Years")
public class YearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
      private IYearLocal year_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Year y=new Year();
		request.setAttribute("years", year_dao.list(y));
		RequestDispatcher r=request.getRequestDispatcher("year.jsp");
		r.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Year y=new Year();
		String name=request.getParameter("name");
		y.setName(name);
		request.setAttribute("years", year_dao.add(y));
		response.sendRedirect("Years");
	}
	
}
