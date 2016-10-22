package Servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ServletForum extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/eleve/forum.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 String idModule = request.getParameter("idModule");
		 String idForum = request.getParameter("idForum");
		 
		 
		 HashMap<String,String> mapper = new HashMap<String,String>();
		 mapper.put("idModule", idModule);
		 mapper.put("idForum", idForum);

		 

		 //Object to JSON in String
		 String json = new Gson().toJson(mapper);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
		
	 }
	
	
	
	
}
