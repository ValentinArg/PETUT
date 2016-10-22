package SQL;

import java.sql.*;

public abstract class SQL {

	private static String url = "jdbc:mysql://localhost:3306/Musculation";
	private static String utilisateur = "root";
	private static String motDePasse = "admin";
	protected static Connection connexion;
	private static Statement statement = null;
	private static ResultSet resultat;
	
	public SQL(){
		this.connect();
	}
	  
	private void connect() {
		  /* Chargement du driver JDBC pour MySQL */
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		  } catch ( ClassNotFoundException e ) {
		      /* G�rer les �ventuelles erreurs ici. */
		  }
		  /* Connexion � la base de donn�es */
		  try {
		      connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
		      System.out.println("connexion r�ussi");
		  } catch ( SQLException e ) {
		     System.out.println("exeption dans la methode connect : " + e);
		  } 
	 }
	
	 public void disconnect(){
		  try {
	            /* Fermeture de la connexion */
	            connexion.close();
	        } catch ( SQLException ignore ) {
	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
	        }
	  }

	public static Statement getStatement() {
		return statement;
	}

	public static void setStatement(Statement statement) {
		SQL.statement = statement;
	}

	public static ResultSet getResultat() {
		return resultat;
	}

	public static void setResultat(ResultSet resultat) {
		SQL.resultat = resultat;
	}

	public static Connection getConnexion() {
		return connexion;
	}

	public static void setConnexion(Connection connexion) {
		SQL.connexion = connexion;
	}
	
}