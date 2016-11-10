package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import Beans.Sujet;
import SQL.SQLAccueil;


public class ServletAccueil extends HttpServlet{
	
	private String VUE = "/WEB-INF/jsp/accueil.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		SQLAccueil sql = new SQLAccueil();
		List<Sujet> listeSujets = new ArrayList<Sujet>();
		listeSujets = sql.getSujetsByIdEnseigne(1);
		request.setAttribute("listeSujets", listeSujets);
		sql.disconnect();
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
}
