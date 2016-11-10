package SQL;

import java.sql.SQLException;


public class SQLConnexion extends SQL{
	
	

	public SQLConnexion() {
		super();
	}

	public boolean validerIdentifiant(String id_Utilisateur) throws SQLException {
		
			int resultat=1;
	        try {
	            this.setStatement( this.getConnexion().createStatement() );
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans la création du statement" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat(this.getStatement().executeQuery( "SELECT COUNT(*) FROM Utilisateur WHERE id_Utilisateur = '" + id_Utilisateur + "';" ));
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans l'exécution de la requete SQL" );
	            e.printStackTrace();
	        }
	        try{
	        	this.getResultat().next();
	        	resultat = this.getResultat().getInt(1);
	        } catch (SQLException e){
	        	System.out.println( "Erreur dans la récupération des données" );
	            e.printStackTrace();
	        }
	        return resultat == 1;
	}

	public boolean validerMotPasse(String id_Utilisateur, String motdepasse) throws SQLException {
			String resultat="";
			try {
	            this.setStatement( this.getConnexion().createStatement() );
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans la création du statement" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat(this.getStatement().executeQuery( "SELECT motdepasse FROM Utilisateur WHERE id_Utilisateur = '" + id_Utilisateur + "';" ));       
	        } catch ( SQLException e ) {
	            System.out.println( "Erreur dans l'exécution de la requete SQL" );
	            e.printStackTrace();
	        }
	        try{
	        	this.getResultat().next();
	        	resultat = this.getResultat().getString("motDePasse");
	        } catch (SQLException e){
	        	System.out.println( "Erreur dans la récupération des données" );
	            e.printStackTrace();
	        }
	        return resultat.equals(motdepasse);

	}

}
