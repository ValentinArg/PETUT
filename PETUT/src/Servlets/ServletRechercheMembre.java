package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import SQL.SQLMoncompte;

public class ServletRechercheMembre extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/restreint/rechercheMembre.jsp";
	private String REDIRECT = "/PE2I/restreint/rechercheMembre";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		request.setAttribute("resultat", "entree");
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		SQLMoncompte sql = new SQLMoncompte();
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		String nom = (String) request.getParameter("nom");
		listeUtilisateurs = sql.getUtilisateurByNom(nom);
		if(listeUtilisateurs.get(0)==null){
			request.setAttribute("resultat", "vide");
		}
		request.setAttribute("listeUtilisateurs", listeUtilisateurs);
		sql.disconnect();
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
}
