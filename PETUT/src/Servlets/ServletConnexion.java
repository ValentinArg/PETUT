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
		
		HttpSession session = request.getSession();
		String seSouvenir = (String) session.getAttribute("souvenir");
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
				session.setAttribute("souvenir", seSouvenir);
			} else {
		        /* Demande de suppression du cookie du navigateur */
		        session.removeAttribute("souvenir");
		    }
        	response.sendRedirect(REDIRECT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute( "traitement", form );
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	}	
}
