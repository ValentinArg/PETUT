package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletDeconnexion extends HttpServlet {
	   public static final String URL_REDIRECTION = "/PE2I/connexion";

	   public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        /* Récupération et destruction de la session en cours */
	        HttpSession session = request.getSession();
	        
	        session.invalidate();

	        /* Redirection vers la page de connexion ! */
	        response.sendRedirect( URL_REDIRECTION );
	   }
}

