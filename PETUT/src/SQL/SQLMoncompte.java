package SQL;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Groupe;
import Beans.Utilisateur;



public class SQLMoncompte extends SQL{

	public SQLMoncompte() {
		super();
	}
	
	public List<Utilisateur> getUtilisateurByIdUtilisateur( String id_Utilisateur ) {
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat( this.getStatement()
                    .executeQuery( "SELECT * "
                    		+ "FROM Utilisateur "
                    		+ "WHERE id_Utilisateur = '"+ id_Utilisateur +"';" ));
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
                Utilisateur u = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
                        						 this.getResultat().getString( 2 ), //nom
                        						 this.getResultat().getString(3),   //prenom
                        						 this.getResultat().getString( 4 ), //mdp
                        						 this.getResultat().getDate( 5 ), 	//datenaissance
                        						 this.getResultat().getString( 6 ),	//adresse
                        						 this.getResultat().getInt( 7 ), 	//codepostal
                        						 this.getResultat().getString( 8 ),	//ville
                        						 this.getResultat().getString( 9 ),	//photo
                        						 this.getResultat().getInt( 10 ),	//telephone
                        						 this.getResultat().getString( 11 ),//adressemail
                        						 this.getResultat().getString( 12 ),//type
                        						 this.getResultat().getInt( 13 )); 	//idgroupe
                listeUtilisateurs.add( u );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeUtilisateurs;
	}
}
