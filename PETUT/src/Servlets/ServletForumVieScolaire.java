package Servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import Beans.*;
import OutilsJava.GestionnaireDate;
import SQL.SQLForumVieScolaire;
import SQL.SQLInfoUtilisateur;

public class ServletForumVieScolaire extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/restreint/forum.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		SQLForumVieScolaire sql = new SQLForumVieScolaire();
		List<Semestre> listeSemestre = new ArrayList<Semestre>();
		List<Forum> listeForum = new ArrayList<Forum>();
		listeSemestre = sql.getSemestresByIdEnseigne(1);
		listeForum = sql.getForumByIdEnseigne(1);
		request.setAttribute("listeForum", listeForum);
		request.setAttribute("listeSemestre", listeSemestre);
		sql.disconnect();
		
		HttpSession session = request.getSession();
		String id_Utilisateur = (String) session.getAttribute("identifiant");
		SQLInfoUtilisateur sql2 = new SQLInfoUtilisateur();
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		listeUtilisateur = sql2.getUtilisateurByIdUtilisateur(id_Utilisateur);
		request.setAttribute("listeUtilisateur", listeUtilisateur);
		sql2.disconnect();
		
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
			 SujetDocument sd = new SujetDocument();
			 sd = sql.getSujetsDocumentByidSujet(idSujet);
			 sql.disconnect();
			 List<Object> listeObjet = new ArrayList<Object>();
			 listeObjet.add(sd);
			 listeObjet.add(listeTopics);
			 ObjectMapper mapper3 = new ObjectMapper();
			 String string3 = mapper3.writeValueAsString(listeObjet);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(string3);
		 }
		 else if(request.getParameter("idTopic")!=null){
			 int idTopic = Integer.parseInt(request.getParameter("idTopic"));
			 SQLForumVieScolaire sql = new SQLForumVieScolaire();
			 Commentaire c = sql.getCommentairePrincipalByIdTopic(idTopic);
			 sql.disconnect();
			 ObjectMapper mapper2 = new ObjectMapper();
			 String string4 = mapper2.writeValueAsString(c);
			 response.setContentType("application/json");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(string4);
		 }
		 
		 
	 }
	 
}
