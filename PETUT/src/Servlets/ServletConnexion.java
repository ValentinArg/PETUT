package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Forms.FormConnexion;
import SQL.SQLConnexion;

public class ServletConnexion extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/connexion.jsp";
	private String REDIRECT = "/PE2I/restreint/accueil";
	private String CHAMP_SOUVENIR = "souvenir";
	private String COOKIE_SOUVENIR = "souvenir";
	private int COOKIE_MAX_AGE = 60 * 60 * 24 * 365;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		
		String seSouvenir = getCookieValue( request, COOKIE_SOUVENIR );
		if(seSouvenir != null && seSouvenir.equals("oui")){
			response.sendRedirect(REDIRECT);
		}else{
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		}
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
    	FormConnexion form = new FormConnexion();

        try {
			String identifiant = form.connexionUtilisateur(request);
			HttpSession session = request.getSession();
			session.setAttribute("identifiant", identifiant );
			if ( request.getParameter( CHAMP_SOUVENIR ) != null ) {
				String seSouvenir="oui";
				setCookie( response, COOKIE_SOUVENIR, seSouvenir, COOKIE_MAX_AGE );
			} else {
		        /* Demande de suppression du cookie du navigateur */
		        setCookie( response, COOKIE_SOUVENIR, "", 0 );
		    }
        	response.sendRedirect(REDIRECT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute( "traitement", form );
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	}
	

    /**
     * Méthode utilitaire gérant la récupération de la valeur d'un cookie donné
     * depuis la requête HTTP.
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
     * Méthode utilitaire gérant la création d'un cookie et son ajout à la
     * réponse HTTP.
     */
    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {
        Cookie cookie = new Cookie( nom, valeur );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }
	
}
