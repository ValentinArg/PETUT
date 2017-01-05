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
import SQL.SQLMoncompte;


public class ServletMoncompte extends HttpServlet{
	
	private String VUE = "/WEB-INF/jsp/restreint/moncompte.jsp";
	
public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		HttpSession session = request.getSession();
		
		String id_Utilisateur = (String) session.getAttribute("identifiant");
		SQLMoncompte sql = new SQLMoncompte();
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		listeUtilisateurs = sql.getUtilisateurByIdUtilisateur(id_Utilisateur);
		request.setAttribute("listeUtilisateurs", listeUtilisateurs);
		sql.disconnect();
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}

}
