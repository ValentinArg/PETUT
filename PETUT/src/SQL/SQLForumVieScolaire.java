package SQL;

import java.util.*;

import Beans.*;

public class SQLForumVieScolaire extends SQL{
	
	/**
	 * Cr�er une instance de la class SQLForumVieScolaire et la connecte � la base de donn�es
	 */
	public SQLForumVieScolaire(){
		super();
	}
	
	/**
	 * Retourne la liste des semestres d'une enseigne donn�
	 * @param idEnseigne identifiant de l'enseigne
	 * @return la liste des semestres en fonction d'une enseigne donn�
	 */
	public List<Semestre> getSemestresByIdEnseigne(int idEnseigne){
		List<Semestre> l = new ArrayList<Semestre>();
		Semestre s1 = new Semestre(1,1);
		Semestre s2 = new Semestre(2,2);
		Semestre s3 = new Semestre(3,3);
		Semestre s4 = new Semestre(4,4);
		s1.setListeModuleEnseigne(this.getModulesByIdSemestre(s1.getId()));
		l.add(s1);
		l.add(s2);
		l.add(s3);
		l.add(s4);
		return l;
	}
	/**
	 * R�cup�re la liste des module d'un semestre donn�e
	 * @param idSemestre identifiant du semestre
	 * @return la liste des modules d'un semestres donn�e
	 */
	public List<Module> getModulesByIdSemestre(int idSemestre){
		List<Module> l = new ArrayList<Module>();
		Module m1 = new Module(1, "M1101", "Architecture", 1);
		l.add(m1);
		return l;
	}
	/**
	 * R�cup�re la liste des Sujets d'un module et d'un nom de forum donn�, nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirig�} pour forum.type = vieScolaire
	 * @param idModule identifiant du module
	 * @param idForum id du forum
	 * @return la liste des Sujets d'un module et d'un nom de forum donn�, nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirig�} pour forum.type = vieScolaire
	 */
	public List<Sujet> getSujetsByIdModuleAndIdForum(int idModule, int idForum){
		return null;
	}
	/**
	 * R�cup�re la liste des forums de la vie scolaire des �tudiants d'une enseigne donn�e (forum.type = "vieScolaire" in BDD)
	 * @return la liste des forums de la vie scolaire des �tudiants d'une enseigne donn�e
	 */
	public List<Forum> recupererForums(){
		return null;
	}
	/**
	 * R�cup�re la liste des topics d'un sujet donn�
	 * @param s sujet
	 * @return la liste des topics d'un sujet donn�
	 */
	public List<Commentaire> recupererTopics(Sujet s){
		return null;
	}
	
	
	
	
}
