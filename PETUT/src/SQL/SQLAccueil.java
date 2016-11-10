package SQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Semestre;
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
	            System.out.println( "erreur dans la cr�ation du statement" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat( this.getStatement()
	                    .executeQuery( "SELECT f.nom, s.numero, s.nom "
	                    		+ "FROM SUJET AS S, FORUMMODULE AS FM, FORUM AS F "
	                    		+ "WHERE S.ID_FORUM = FM.ID_FORUM "
	                    		+ "AND FM.ID_FORUM = F.ID_FORUM "
	                    		+ "AND F.ID_ENSEIGNE = " + idEnseigne + ";" ) );
	        } catch ( SQLException e ) {
	            System.out.println( "erreur dans l'execution de la requete SQL" );
	            e.printStackTrace();
	        }
	        try {
	            while ( this.getResultat().next() ) {
	                Sujet s = new Sujet( this.getResultat().getString( 1 ),
	                        this.getResultat().getInt( 2 ), this.getResultat().getString( 3 ));
	                listeSujets.add( s );
	            }
	        } catch ( SQLException e ) {
	            System.out.println( "erreur dans la recup�ration des donn�es" );
	            e.printStackTrace();
	        }
	        return listeSujets;
	}
}
