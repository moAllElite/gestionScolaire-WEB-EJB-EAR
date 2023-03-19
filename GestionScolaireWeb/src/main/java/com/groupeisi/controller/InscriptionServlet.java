package com.groupeisi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.Interfaces.IInscriptionLocal;
import com.groupeisi.entities.Inscription;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private IInscriptionLocal inscription_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Inscription i=new Inscription();
		request.setAttribute("inscriptions", inscription_dao.list(i));
		request.getRequestDispatcher("Inscritption.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String detail=request.getParameter("details");
		Inscription i=new Inscription();
		i.setDetails(detail);
		inscription_dao.add(i);
		request.setAttribute("inscriptions", inscription_dao.list(i));
		response.sendRedirect("Inscription");
	}

}
