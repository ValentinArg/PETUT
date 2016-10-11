package Filters;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterPagesEleve implements Filter {
    public void init( FilterConfig config ) throws ServletException {
        // ...
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
	    
    	HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse reponse = (HttpServletResponse) res;
	    HttpSession session = request.getSession();
	    
	    if(session.getAttribute("idUtilisateur") == null){
	    	reponse.sendRedirect( request.getContextPath() + "/connexion" );
	    }
	    else{
	    	chain.doFilter(request, reponse);
	    }
	    
    }

    public void destroy() {
        // ...
    }
}