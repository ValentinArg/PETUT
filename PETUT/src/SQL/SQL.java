package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public abstract class SQL {

    private static String       url         = "jdbc:mysql://localhost:3306/pe2idatabase";
    private static String       utilisateur = "root";
    private static String       motDePasse  = "admin";
    protected static Connection connexion;
    private static Statement    statement   = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet    resultat;

    public SQL() {
        this.connect();
    }

    /**
     * Connecte l'instance � la base de donn�es
     */
    private void connect() {
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            System.out.println( "Exception dans la methode connect (nom de la base de donn�es) : " + e );
        }
        /* Connexion � la base de donn�es */
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
            System.out.println( "Connexion r�ussie" );
        } catch ( SQLException e ) {
            System.out.println( "Exception dans la methode connect : " + e );
        }
    }

    /**
     * Deconnecte l'instance de la base de donn�es
     */
    public void disconnect() {
        try {
            /* Fermeture de la connexion */
            connexion.close();
            System.out.println( "D�connexion r�ussie" );
        } catch ( SQLException e ) {
            System.out.println( "Exception dans la methode disconnect : " + e );
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement( Statement statement ) {
        SQL.statement = statement;
    }
    
    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public static void setPreparedStatement( PreparedStatement preparedStatement ) {
        SQL.preparedStatement = preparedStatement;
    }

    public static ResultSet getResultat() {
        return resultat;
    }

    public static void setResultat( ResultSet resultat ) {
        SQL.resultat = resultat;
    }

    public static Connection getConnexion() {
        return connexion;
    }

    public static void setConnexion( Connection connexion ) {
        SQL.connexion = connexion;
    }

}
