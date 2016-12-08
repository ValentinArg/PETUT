package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Forum;
import Beans.Semestre;
import SQL.SQLForumVieScolaire;

public class ServletEspaceMembre extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/restreint/espaceMembre.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 
	 }
}
		 