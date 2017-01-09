package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import Beans.Modification;
import Beans.Sujet;
import Beans.Utilisateur;
import SQL.SQLAccueil;
import SQL.SQLInfoUtilisateur;


public class ServletAccueil extends HttpServlet{
	
	private String VUE = "/WEB-INF/jsp/restreint/accueil.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		SQLAccueil sql = new SQLAccueil();
		
		List<Sujet> listeSujets = new ArrayList<Sujet>();
		listeSujets = sql.getSujetsByIdEnseigne(1);
		request.setAttribute("listeSujets", listeSujets);
		
		List<Modification> listeModifications = new ArrayList<Modification>();
		listeModifications = sql.getModifications();
		request.setAttribute("listeModifications", listeModifications);
		
		HttpSession session = request.getSession();
		String id_Utilisateur = (String) session.getAttribute("identifiant");
		SQLInfoUtilisateur sql2 = new SQLInfoUtilisateur();
		Utilisateur utilisateur = sql2.getUtilisateurByIdUtilisateur(id_Utilisateur);
		request.setAttribute("utilisateur", utilisateur);
		
		sql.disconnect();
		sql2.disconnect();
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
}
