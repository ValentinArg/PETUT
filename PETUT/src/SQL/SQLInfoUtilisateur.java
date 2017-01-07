package SQL;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import Beans.Utilisateur;



public class SQLInfoUtilisateur extends SQL{

	public SQLInfoUtilisateur() {
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
                    .executeQuery( "SELECT u.id_Utilisateur, u.Nom, u.Prenom, u.DateNaissance, u.Adresse, u.Code_Postal, u.Ville, u.Telephone, u.Adresse_Mail, g.Libelle, s.Numero "
                    		+ "FROM Utilisateur AS u, Groupe AS g, Semestre AS s "
                    		+ "WHERE u.id_Groupe = g.id_Groupe "
                    		+ "AND g.id_Semestre = s.id_Semestre "
                    		+ "AND id_Utilisateur = '"+ id_Utilisateur +"';" ));
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        
        try {
            while ( this.getResultat().next() ) {
            	Date myDate = this.getResultat().getDate( 4 );
            	String newDate = new SimpleDateFormat("dd/MM/yyyy").format(myDate); //formattage de la date
         
            	Utilisateur u = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
												 this.getResultat().getString( 2 ), //nom
												 this.getResultat().getString(3),   //prenom
												 "nonononnon",							    //mdp
												 newDate, 							//datenaissance
												 this.getResultat().getString( 5 ),	//adresse
												 this.getResultat().getInt( 6 ), 	//codepostal
												 this.getResultat().getString( 7 ),	//ville
												 "n",	//photo
												 this.getResultat().getInt( 8 ),	//telephone
												 this.getResultat().getString( 9 ),//adressemail
												 "etudiant",								//type
												 this.getResultat().getString( 10 ),//groupe
												 this.getResultat().getInt( 11 )); 	//semestre
                listeUtilisateurs.add( u );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeUtilisateurs;
	}
	
	public List<Utilisateur> getUtilisateurByNom( String nom ) {
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
        	this.setResultat( this.getStatement()
                    .executeQuery( "SELECT u.id_Utilisateur, u.Nom, u.Prenom, u.DateNaissance, u.Adresse, u.Code_Postal, u.Ville, u.Telephone, u.Adresse_Mail, g.Libelle, s.Numero "
                    		+ "FROM Utilisateur AS u, Groupe AS g, Semestre AS s "
                    		+ "WHERE u.id_Groupe = g.id_Groupe "
                    		+ "AND g.id_Semestre = s.id_Semestre "
                    		+ "AND Nom = '"+ nom +"';" ));
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        
        try {
            while ( this.getResultat().next() ) {
            	Date myDate = this.getResultat().getDate( 4 );
            	String newDate = new SimpleDateFormat("dd/MM/yyyy").format(myDate); //formattage de la date
         
            	Utilisateur u = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
            									 this.getResultat().getString( 2 ), //nom
												 this.getResultat().getString(3),   //prenom
												 "nonononon",							    //mdp
												 newDate, 							//datenaissance
												 this.getResultat().getString( 5 ),	//adresse
												 this.getResultat().getInt( 6 ), 	//codepostal
												 this.getResultat().getString( 7 ),	//ville
												 "n",	//photo
												 this.getResultat().getInt( 8 ),	//telephone
												 this.getResultat().getString( 9 ),//adressemail
												 "etudiant",								//type
												 this.getResultat().getString( 10 ),//groupe
												 this.getResultat().getInt( 11 )); 	//semestre
                listeUtilisateurs.add( u );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeUtilisateurs;
	}
}
