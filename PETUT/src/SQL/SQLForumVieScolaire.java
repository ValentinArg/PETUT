package SQL;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Beans.*;
import OutilsJava.GestionnaireDate;


public class SQLForumVieScolaire extends SQL {
	
    /**
     * Créer une instance de la class SQLForumVieScolaire et la connecte à la
     * base de données
     */
    public SQLForumVieScolaire() {
        super();
    }

    /**
     * Récupère la liste des semestres d'une enseigne donné
     * 
     * @param idEnseigne
     *            identifiant de l'enseigne
     * @return la liste des semestres en fonction d'une enseigne donné
     */
    public List<Semestre> getSemestresByIdEnseigne( int idEnseigne ) {
        List<Semestre> listeSemestre = new ArrayList<Semestre>();
        try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat( this.getStatement()
                    .executeQuery( "SELECT * FROM SEMESTRE WHERE id_Enseigne = " + idEnseigne + ";" ) );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
                Semestre s = new Semestre( this.getResultat().getInt( "id_Semestre" ),
                        this.getResultat().getInt( "numero" ) );
                listeSemestre.add( s );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeSemestre;
    }

    /**
     * Récupère la liste des Ue en fonction d'un identifiant de semestre
     * 
     * @param idSemestre
     *            identifiant du semestre
     * @return la liste des Ue en fonction d'un identifiant de semestre
     */
    public List<Ue> getUesByIdSemestre( int idSemestre ) {
        List<Ue> listeUe = new ArrayList<Ue>();
        try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat(
                    this.getStatement().executeQuery( "SELECT * FROM Ue WHERE id_Semestre = " + idSemestre + ";" ) );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
                Ue ue = new Ue( this.getResultat().getInt( "id_Ue" ), this.getResultat().getInt( "numero" ),
                        this.getResultat().getString( "libelle" ) );
                listeUe.add( ue );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return this.getModulesByListeUe( listeUe );
    }

    /**
     * Récupère la liste des module d'un Ue donné
     * 
     * @param listeUe
     *            liste des Ue d'un semestre
     * @return la liste des modules d'un Ue donné
     */
    private List<Ue> getModulesByListeUe( List<Ue> listeUe ) {
        for ( int i = 0; i < listeUe.size(); i++ ) {
            List<Module> listeModule = new ArrayList<Module>();
            try {
                this.setStatement( this.getConnexion().createStatement() );
            } catch ( SQLException e ) {
                System.out.println( "erreur dans la création du statement" );
                e.printStackTrace();
            }
            try {
                this.setResultat( this.getStatement()
                        .executeQuery( "SELECT * FROM Module WHERE id_Ue =" + listeUe.get( i ).getId() + ";" ) );
            } catch ( SQLException e ) {
                System.out.println( "erreur dans l'execution de la requete SQL" );
                e.printStackTrace();
            }
            try {
                while ( this.getResultat().next() ) {
                    Module m = new Module( this.getResultat().getInt( "id_Module" ),
                            this.getResultat().getString( "numero" ), this.getResultat().getString( "libelle" ),
                            this.getResultat().getInt( "id_Ue" ) );
                    listeModule.add( m );
                }
            } catch ( SQLException e ) {
                System.out.println( "erreur dans la recupération des données" );
                e.printStackTrace();
            }
            listeUe.get( i ).setL( listeModule );
        }
        return listeUe;
    }

    /**
     * Récupère la liste des Sujets d'un module et d'un nom de forum donné,
     * nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirigé} pour
     * forum.type = vieScolaire
     * @param idModule identifiant du module
     * @param idForum id du forum
     * @return la liste des Sujets d'un module et d'un nom de forum donné,
     *         nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirigé} pour
     *         forum.type = vieScolaire
     */
    public List<Sujet> getSujetsByIdModuleAndIdForum( int idModule, int idForum ) {
    	List<Sujet> listeSujet = new ArrayList<Sujet>();
        try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat( this.getStatement().executeQuery( "SELECT s.id_Sujet, m.numero, s.nom, s.numero, s.dates, f.nom "
													    		+ "FROM SUJET AS s, FORUMMODULE AS fm, FORUM AS f, Module AS m "
													    		+ "WHERE s.ID_FORUM = fm.ID_FORUM "
													    		+ "AND s.id_Module = m.id_Module "
													    		+ "AND fm.ID_FORUM = f.ID_FORUM "
													    		+ "AND fm.id_Module = " + idModule + " "
													    		+ "AND fm.id_Forum = " + idForum +" "
													    	    + "ORDER BY s.numero;" ));
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
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
                listeSujet.add( s );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeSujet;
    }
    
    /**
     * Récupère les documents d'un sujet donnée (sujet,correction et element à importer)
     * @param idSujet
     * @return la liste des documents d'un sujet passé en paramètre
     */
    public SujetDocument getSujetsDocumentByidSujet(int idSujet){
    	SujetDocument listeDocuments = new SujetDocument();
    	try {
    		this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
        	this.setResultat( this.getStatement()
            .executeQuery( "SELECT * FROM Document WHERE id_Sujet ="+idSujet+";"));
        } catch ( SQLException e ) {
        	System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
            	Document d = new Document(this.getResultat().getInt("id_Document"),this.getResultat().getString("nom"),this.getResultat().getString("lien"),this.getResultat().getString("DateD"));
                Outils.decouperListDocumentSujet(d, listeDocuments);
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
    	return listeDocuments;
    }
    

    /**
     * Récupère la liste des forums de la vie scolaire des étudiants d'une
     * enseigne donnée (forum.type = "vieScolaire" in BDD)
     * 
     * @return la liste des forums de la vie scolaire des étudiants d'une
     *         enseigne donnée
     */
    public List<Forum> getForumByIdEnseigne( int idEnseigne ) {
        List<Forum> listeForum = new ArrayList<Forum>();
        try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat( this.getStatement().executeQuery( "SELECT * FROM Forum WHERE id_Enseigne = " + idEnseigne
                    + " AND typeF='viescolaire' ORDER BY nom;" ) );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
                Forum f = new Forum( this.getResultat().getInt( "id_Forum" ), this.getResultat().getString( "nom" ) );
                listeForum.add( f );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeForum;
    }

    /**
     * Récupère la liste des topics d'un sujet donné
     * 
     * @param idSujet
     *         
     * @return la liste des topics d'un sujet donné
     */
    public List<Topic> getTopicsByIdSujet( int idSujet ){
    	List<Topic> listeTopics = new ArrayList<Topic>();
        try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat(
                    this.getStatement().executeQuery( "SELECT * FROM Commentaire WHERE id_Sujet = " + idSujet + ";" ) );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
            	Topic t = new Topic( this.getResultat().getInt( "id_Commentaire" ),this.getResultat().getString("id_Utilisateur"), this.getResultat().getString( "question" ),
                        this.getResultat().getString( "DateC" ),this.getResultat().getString("statut") );
            	listeTopics.add( t );
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return listeTopics;
    }
    
    public void getNbReponseTopicsBylisteTopic(List<Topic> listeTopic){
    	for(Topic t : listeTopic){
    		
    		int nbReponse = 0;
	    	try {
	            this.setStatement( this.getConnexion().createStatement() );
	        } catch ( SQLException e ) {
	            System.out.println( "erreur dans la création du statement" );
	            e.printStackTrace();
	        }
	        try {
	            this.setResultat(
	                    this.getStatement().executeQuery( "SELECT COUNT(*) FROM Reponse WHERE id_Commentaire = " + t.getId() + ";" ) );
	        } catch ( SQLException e ) {
	            System.out.println( "erreur dans l'execution de la requete SQL" );
	            e.printStackTrace();
	        }
	        try {
	        	this.getResultat().next();
	            t.setNbReponse(this.getResultat().getInt(1));
	            
	        } catch ( SQLException e ) {
	            System.out.println( "erreur dans la recupération des données" );
	            e.printStackTrace();
	        }
    	}
	    	
    	
    }
    
    public Commentaire getCommentairePrincipalByIdTopic(int idTopic){
    	Commentaire commentaire = null;
        try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }
        try {
            this.setResultat(
                    this.getStatement().executeQuery( "SELECT * FROM Commentaire WHERE id_Commentaire = " + idTopic + ";" ) );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans l'execution de la requete SQL" );
            e.printStackTrace();
        }
        try {
            while ( this.getResultat().next() ) {
            	String newDate = new SimpleDateFormat("MM/dd/yyyy").format( this.getResultat().getDate( "DateC" ));
            	commentaire = new Commentaire( this.getResultat().getInt( "id_Commentaire" ),this.getResultat().getString("id_Utilisateur"), this.getResultat().getString( "question" ),
            			newDate,this.getResultat().getString("statut"),this.getResultat().getString("texte"));
            }
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la recupération des données" );
            e.printStackTrace();
        }
        return this.getReponsesByCommentairePrincipal(commentaire);
    }
    
    public Commentaire getReponsesByCommentairePrincipal(Commentaire c){
    	 try {
             this.setStatement( this.getConnexion().createStatement() );
         } catch ( SQLException e ) {
             System.out.println( "erreur dans la création du statement" );
             e.printStackTrace();
         }
         try {
             this.setResultat(
                     this.getStatement().executeQuery( "SELECT * FROM Reponse WHERE id_Commentaire = " + c.getId() + ";" ) );
         } catch ( SQLException e ) {
             System.out.println( "erreur dans l'execution de la requete SQL" );
             e.printStackTrace();
         }
         try {
        	 while ( this.getResultat().next() ) {
        		 String newDate = new SimpleDateFormat("MM/dd/yyyy").format(this.getResultat().getDate("DateR"));
        		 Reponse r = new Reponse(this.getResultat().getInt("id_Reponse"),this.getResultat().getString("id_Utilisateur"),this.getResultat().getString("texte"),newDate);
             	 c.addReponse(r);
             }
         } catch ( SQLException e ) {
             System.out.println( "erreur dans la recupération des données" );
             e.printStackTrace();
         }
         return c;
    }
    
    public void ajouterReponse(int idCommentaire, String reponse,String idUtilisateur){
    	
    	try {
            this.setPreparedStatement( (PreparedStatement) this.getConnexion().prepareStatement("INSERT INTO Reponse (id_Commentaire, id_Utilisateur, Texte, DateR) VALUES (?,?,?,NOW());"));
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du preparedstatement" );
            e.printStackTrace();
        }
    	
    	try {
            this.getPreparedStatement().setInt(1, idCommentaire);
            this.getPreparedStatement().setString(2, idUtilisateur);
            this.getPreparedStatement().setString(3, reponse);

        } catch ( SQLException e ) {
            System.out.println( "erreur dans affectation du preparedstatement" );
            e.printStackTrace();
        }
    	
    	try {
			int statut =  this.getPreparedStatement().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void ajouterSujetCour(int idModule,int idForum, String nom, int numero){
    	try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }    	
   	
   	try {
			int statut =  this.getStatement().executeUpdate( "INSERT INTO Sujet (id_Module, id_Forum,Nom,Numero,DateS) VALUES ("+idModule+","+idForum+",'"+nom+"',"+numero+", NOW());" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void ajouterQuestion(String idUtilisateur,int idSujet, String question, String texte){
    	try {
            this.setStatement( this.getConnexion().createStatement() );
        } catch ( SQLException e ) {
            System.out.println( "erreur dans la création du statement" );
            e.printStackTrace();
        }    	
   	
   	try {
			int statut =  this.getStatement().executeUpdate( "INSERT INTO Commentaire (id_Utilisateur, id_Sujet, Question, Texte, Statut, DateC) VALUES ('"+idUtilisateur+"',"+idSujet+",'"+question+"','"+texte+"','en cours', NOW());" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
