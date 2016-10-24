package Servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import Beans.*;
import SQL.SQLForumVieScolaire;

public class ServletForum extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/eleve/forum.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
	
		SQLForumVieScolaire sql = new SQLForumVieScolaire();
		List<Semestre> listeSemestre = new ArrayList<Semestre>();
		listeSemestre = sql.getSemestresByIdEnseigne(1);
		request.setAttribute("listeSemestre", listeSemestre);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 String idModule = request.getParameter("idModule");
		 String idForum = request.getParameter("idForum");
		 
		 ObjectMapper mapper = new ObjectMapper();
		 List<Sujet> listeSujets =  new ArrayList<Sujet>();
		 
		 SQLForumVieScolaire sql = new SQLForumVieScolaire();
		 listeSujets = sql.getSujetsByIdModuleAndIdForum(Integer.parseInt(idModule), Integer.parseInt(idForum));
		 sql.disconnect();
		 
		 String string = mapper.writeValueAsString(listeSujets);
		 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(string);
		 
	 }
	 
}
