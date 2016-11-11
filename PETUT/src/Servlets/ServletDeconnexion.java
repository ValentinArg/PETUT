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
	   private static final String COOKIE_SOUVENIR = "souvenir";

	   public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        /* R�cup�ration et destruction de la session en cours */
	        HttpSession session = request.getSession();
	        String seSouvenir = getCookieValue( request, COOKIE_SOUVENIR );
			if(seSouvenir != null && seSouvenir.equals("oui")){
				setCookie( response, COOKIE_SOUVENIR, "", 0 );
			}
	        session.invalidate();

	        /* Redirection vers la page de connexion ! */
	        response.sendRedirect( URL_REDIRECTION );
	   }
	   
	   /**
	     * M�thode utilitaire g�rant la r�cup�ration de la valeur d'un cookie donn�
	     * depuis la requ�te HTTP.
	     */
	    private static String getCookieValue( HttpServletRequest request, String nom ) {
	        Cookie[] cookies = request.getCookies();
	        if ( cookies != null ) {
	            for ( Cookie cookie : cookies ) {
	                if ( cookie != null && nom.equals( cookie.getName() ) ) {
	                    return cookie.getValue();
	                }
	            }
	        }
	        return null;
	    }
	    
	    /*
	     * M�thode utilitaire g�rant la cr�ation d'un cookie et son ajout � la
	     * r�ponse HTTP.
	     */
	    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {
	        Cookie cookie = new Cookie( nom, valeur );
	        cookie.setMaxAge( maxAge );
	        response.addCookie( cookie );
	    }
}

