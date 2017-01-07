package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;
import SQL.SQLModifiercompte;
import SQL.SQLInfoUtilisateur;

public class ServletModifiercompte extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/restreint/modifiercompte.jsp";
	private String REDIRECT = "/PE2I/restreint/moncompte";

	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		
		String id_Utilisateur = (String) session.getAttribute("identifiant");
<<<<<<< HEAD
		SQLInfoUtilisateur sql1 = new SQLInfoUtilisateur();
		Utilisateur u = new Utilisateur();
		u = sql1.getUtilisateurByIdUtilisateur(id_Utilisateur);
		request.setAttribute("listeUtilisateur", u);
		sql1.disconnect();
=======
		SQLInfoUtilisateur sql = new SQLInfoUtilisateur();
		Utilisateur utilisateur = sql.getUtilisateurByIdUtilisateur(id_Utilisateur);
		request.setAttribute("utilisateur", utilisateur);
		sql.disconnect();
>>>>>>> refs/remotes/origin/master
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	      
		HttpSession session = request.getSession();
		String id_Utilisateur = (String) session.getAttribute("identifiant");
		SQLModifiercompte sql = new SQLModifiercompte();
		sql.setModificationByIdUtilisateur(id_Utilisateur, request);
		sql.disconnect();
		
		response.sendRedirect(REDIRECT);
}
}
