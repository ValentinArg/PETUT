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

public class ServletForumVieScolaire extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/eleve/forum.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		SQLForumVieScolaire sql = new SQLForumVieScolaire();
		List<Semestre> listeSemestre = new ArrayList<Semestre>();
		List<Forum> listeForum = new ArrayList<Forum>();
		listeSemestre = sql.getSemestresByIdEnseigne(1);
		listeForum = sql.getForumByIdEnseigne(1);
		request.setAttribute("listeForum", listeForum);
		request.setAttribute("listeSemestre", listeSemestre);
		sql.disconnect();
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 
		 if(request.getParameter("idSemestre")!= null){
			 //cast de string vers int
			 int idSemestre = Integer.parseInt(request.getParameter("idSemestre"));
			 SQLForumVieScolaire sql = new SQLForumVieScolaire();
			 List<Ue> listeUe =  new ArrayList<Ue>();
			 listeUe = sql.getUesByIdSemestre(idSemestre);
			 ObjectMapper mapper1 = new ObjectMapper();
			 String string1 = mapper1.writeValueAsString(listeUe);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(string1);
			 sql.disconnect();
		 }
		 else if (request.getParameter("idModule")!= null && request.getParameter("idForum")!=null){
			 int idModule = Integer.parseInt(request.getParameter("idModule"));
			 int idForum = Integer.parseInt(request.getParameter("idForum"));
			 SQLForumVieScolaire sql = new SQLForumVieScolaire();
			 List<Sujet> listeSujets = new ArrayList<Sujet>();
			 listeSujets = sql.getSujetsByIdModuleAndIdForum(idModule, idForum);
			 sql.disconnect();
			 ObjectMapper mapper2 = new ObjectMapper();
			 String string2 = mapper2.writeValueAsString(listeSujets);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(string2);
		 }
		 else if(request.getParameter("idSujet")!=null){
			 int idSujet = Integer.parseInt(request.getParameter("idSujet"));
			 SQLForumVieScolaire sql = new SQLForumVieScolaire();
			 List<Topic> listeTopics = new ArrayList<Topic>();
			 listeTopics = sql.getTopicsByIdSujet(idSujet);
			 sql.disconnect();
			 ObjectMapper mapper3 = new ObjectMapper();
			 String string3 = mapper3.writeValueAsString(listeTopics);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(string3);
		 }
	 }
	 
}
