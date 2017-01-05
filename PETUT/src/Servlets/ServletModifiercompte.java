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
import SQL.SQLMoncompte;

public class ServletModifiercompte extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/restreint/modifiercompte.jsp";
	private String REDIRECT = "/PE2I/restreint/moncompte";

	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		
		String id_Utilisateur = (String) session.getAttribute("identifiant");
		SQLMoncompte sql1 = new SQLMoncompte();
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		listeUtilisateurs = sql1.getUtilisateurByIdUtilisateur(id_Utilisateur);
		request.setAttribute("listeUtilisateurs", listeUtilisateurs);
		sql1.disconnect();
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	      
		HttpSession session = request.getSession();
		String id_Utilisateur = (String) session.getAttribute("identifiant");
		SQLModifiercompte sql2 = new SQLModifiercompte();
		sql2.setModificationByIdUtilisateur(id_Utilisateur, request);
		sql2.disconnect();
		
		response.sendRedirect(REDIRECT);
}
}
