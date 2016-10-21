package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConnexion extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/connexion.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
      
    	
    	/*Forms.Connexion form = new Forms.Connexion();
        try {
			int id = form.connexionUtilisateur(request);
			HttpSession session = request.getSession();
			SQLConnect sql = new SQLConnect();
        	session.setAttribute("idUtilisateur", sql.recupererIdUtilisateur(request.getParameter("connexionEmail")) );
        	response.sendRedirect( "/LesPetitsChefs");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute( "traitement", form );
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );*/
	}
	
	
}
