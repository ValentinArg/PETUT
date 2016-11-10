package SQL;

import java.sql.SQLException;


public class SQLConnexion extends SQL{
	
	

	public SQLConnexion() {
		super();
	}

	public boolean validerId(String id_Utilisateur) throws SQLException {
		
			int resultat=1;
	        try {
	            this.setStatement( this.getConnexion().createStatement() );
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans la cr�ation du statement" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat(this.getStatement().executeQuery( "SELECT COUNT(*) FROM Utilisateur WHERE id_Utilisateur = '" + id_Utilisateur + "';" ));
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans l'execution de la requete SQL" );
	            e.printStackTrace();
	        }
	        try{
	        	this.getResultat().next();
	        	resultat = this.getResultat().getInt(1);
	        } catch (SQLException e){
	        	System.out.println( "erreur dans la recup�ration des donn�es" );
	            e.printStackTrace();
	        }
	        return resultat == 1;
	}

	public boolean validerMotPasse(String id_Utilisateur, String motDePasse) throws SQLException {
			String resultat="";
			try {
	            this.setStatement( this.getConnexion().createStatement() );
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans la cr�ation du statement" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat(this.getStatement().executeQuery( "SELECT motdepasse FROM Utilisateur WHERE id_Utilisateur = '" + id_Utilisateur + "';" ));       
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans l'execution de la requete SQL" );
	            e.printStackTrace();
	        }
	        try{
	        	this.getResultat().next();
	        	resultat = this.getResultat().getString("motDePasse");
	        } catch (SQLException e){
	        	System.out.println( "erreur dans la recup�ration des donn�es" );
	            e.printStackTrace();
	        }
	        return resultat.equals(motDePasse);

	}

}
