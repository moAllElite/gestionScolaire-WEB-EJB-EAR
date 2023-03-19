package com.groupeisi.controller;



import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class YearActionsServlet
 */
@WebServlet("/")
public class YearActionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private IYearLocal year_dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YearActionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupération du chemin absolue 
		//Returns the part of this request's URL that calls the servlet. This path starts with a "/" character and includeseither the 
		String action=request.getServletPath();
		switch (action) {
		case "/Edit_year":
			try {
				editForm(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/Update_year":
			try {
				updateForm(request, response);
				response.sendRedirect("Years");
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/Delete_year":
			try {
				deleteForm(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				listForm(request, response);
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
	protected void editForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException,SQLException{
		int id=Integer.parseInt(request.getParameter("id"));
		Year year=new Year();
		year.setId(id);
		year.setName(request.getParameter("name"));
		request.setAttribute("year", year_dao.getYear(id));
		RequestDispatcher r=request.getRequestDispatcher("actionsYear.jsp");
		r.forward(request, response);
		
	}
	protected void updateForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException,SQLException{
		int id=Integer.parseInt(request.getParameter("id"));
		Year y=new Year();
		String name=request.getParameter("name");
		y.setId(id);
		y.setName(name);
		request.setAttribute("years", year_dao.update(y));
		response.sendRedirect("Years");
	}
	protected void listForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException,SQLException{
		Year y=new Year();
		request.setAttribute("years", year_dao.list(y));
		RequestDispatcher r=request.getRequestDispatcher("year.jsp");
		r.forward(request, response);
	}
	protected void deleteForm(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException,SQLException{
		int id=Integer.parseInt(request.getParameter("id"));
		Year y=new Year();
		request.setAttribute("years", year_dao.delete(id, y));
		response.sendRedirect("Years");
	}
	

}
