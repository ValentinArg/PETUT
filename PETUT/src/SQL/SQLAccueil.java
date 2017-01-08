package SQL;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Beans.Sujet;


public class SQLAccueil extends SQL{
	
	

	public SQLAccueil() {
		super();
	}

	public List<Sujet> getSujetsByIdEnseigne( int idEnseigne ) {
		List<Sujet> listeSujets = new ArrayList<Sujet>();
		 try {
	            this.setStatement( this.getConnexion().createStatement() );
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans la création du statement getSujetsByIdEnseigne()" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat( this.getStatement()
	                    .executeQuery( "SELECT s.id_Sujet, m.numero, s.nom, s.numero,s.dates, f.nom "
	                    		+ "FROM SUJET AS s, FORUMMODULE AS fm, FORUM AS f, Module AS m "
	                    		+ "WHERE S.ID_FORUM = FM.ID_FORUM "
	                    		+ "AND s.id_Module = m.id_Module "
	                    		+ "AND FM.ID_FORUM = F.ID_FORUM "
	                    		+ "AND F.ID_ENSEIGNE = " + idEnseigne + " "
	                    		+ "ORDER BY s.DateS "
	                    		+ "LIMIT 10;" ) );
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans l'exécution de la requete SQL getSujetsByIdEnseigne()" );
	            e.printStackTrace();
	        }
	        try {
	            while ( this.getResultat().next() ) {
	                Sujet s = new Sujet( this.getResultat().getInt( 1 ),
	                        			 this.getResultat().getString( 2 ), 
	                        			 this.getResultat().getString( 3 ),
	                        			 this.getResultat().getInt(4),
	                        			 new SimpleDateFormat("dd/MM/yyyy").format(this.getResultat().getDate(5)),
	                        			 this.getResultat().getString( 6 ));
	                listeSujets.add( s );
	            }
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans la recupération des données getSujetsByIdEnseigne()" );
	            e.printStackTrace();
	        }
	        return listeSujets;
	}
}
