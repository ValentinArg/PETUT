package SQL;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Beans.Utilisateur;



public class SQLInfoUtilisateur extends SQL{

	public SQLInfoUtilisateur() {
		super();
	}
	

	public Utilisateur getUtilisateurByIdUtilisateur( String id_Utilisateur ) {
		Utilisateur utilisateur = null;
		
		try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la création du statement getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        try {
            this.setResultat( this.getStatement()
                    .executeQuery( "SELECT u.id_Utilisateur, u.Nom, u.Prenom, u.DateNaissance, u.Adresse, u.Code_Postal, u.Ville, u.Telephone, u.Adresse_Mail, g.Libelle, s.Numero, u.TypeU "
                    			 + "FROM Utilisateur AS u, Groupe AS g, Semestre AS s "
                    			 + "WHERE u.id_Groupe = g.id_Groupe "
                    			 + "AND g.id_Semestre = s.id_Semestre "
                    			 + "AND id_Utilisateur = '"+ id_Utilisateur +"';" ));
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans l'execution de la requete SQL getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();
        }
        
        try {
        	this.getResultat().next();
            utilisateur = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
            							   this.getResultat().getString( 2 ), //nom
            							   this.getResultat().getString(3),   //prenom
            							   "12345",							//mdp
            							   new SimpleDateFormat("dd/MM/yyyy").format(this.getResultat().getDate(4)), 							//datenaissance
            							   this.getResultat().getString( 5 ),	//adresse
            							   this.getResultat().getInt( 6 ), 	//codepostal
            							   this.getResultat().getString( 7 ),	//ville
            							   " ",								//photo
            							   this.getResultat().getInt( 8 ),	//telephone
            							   this.getResultat().getString( 9 ), //adressemail
            							   this.getResultat().getString(12),//type
            							   this.getResultat().getString( 10 ),//groupe
            							   this.getResultat().getInt( 11 )); 	//semestre

        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la recupération des données getUtilisateurByIdUtilisateur()" );
            e.printStackTrace();

        }   
        return utilisateur;

        
	}
	
	public Utilisateur getUtilisateurByNom( String nom ) {
		Utilisateur utilisateur = null;
		try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la création du statement getUtilisateurByNom()" );
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
            System.out.println( "Erreur dans l'execution de la requete SQL getUtilisateurByNom()" );
            e.printStackTrace();
        }
        
        try {
        	 this.getResultat().next();
             utilisateur = new Utilisateur( this.getResultat().getString( 1 ), //identifiant
             							   this.getResultat().getString( 2 ), //nom
             							   this.getResultat().getString(3),   //prenom
             							   "12345",							//mdp
             							   new SimpleDateFormat("dd/MM/yyyy").format(this.getResultat().getDate(4)), 							//datenaissance
             							   this.getResultat().getString( 5 ),	//adresse
             							   this.getResultat().getInt( 6 ), 	//codepostal
             							   this.getResultat().getString( 7 ),	//ville
             							   " ",								//photo
             							   this.getResultat().getInt( 8 ),	//telephone
             							   this.getResultat().getString( 9 ), //adressemail
             							   " ",								//type
             							   this.getResultat().getString( 10 ),//groupe
             							   this.getResultat().getInt( 11 )); 	//semestre
        } catch ( SQLException e ) {
            System.out.println( "Erreur dans la recupération des données getUtilisateurByNom()" );
            e.printStackTrace();
        }
        return utilisateur;
	}
}
