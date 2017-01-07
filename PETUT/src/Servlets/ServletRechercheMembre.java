package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import SQL.SQLInfoUtilisateur;

public class ServletRechercheMembre extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/restreint/rechercheMembre.jsp";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		request.setAttribute("resultat", "Entrez un nom");
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		SQLInfoUtilisateur sql = new SQLInfoUtilisateur();
		String nom = (String) request.getParameter("nom");
		Utilisateur utilisateur = sql.getUtilisateurByNom(nom);
		if(utilisateur == null){
			request.setAttribute("resultat", "Le membre "+nom+" n'existe pas");
		}
		request.setAttribute("utilisateur", utilisateur);
		sql.disconnect();
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
}
