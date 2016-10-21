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
	
	
	public List<Integer> recupererSemestres(){
		return null;
	}
	/**
	 * R�cup�re la liste des module d'un semestre donn�e
	 * @param numeroSemestre num�ro du semestre
	 * @return la liste des modules d'un semestres donn�e
	 */
	public List<Module> recupererModules(int numeroSemestre){
		return null;
	}
	/**
	 * R�cup�re la liste des Sujets d'un module et d'un nom de forum donn�, nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirig�} pour forum.type = vieScolaire
	 * @param m module
	 * @param nomForum nom du forum
	 * @return la liste des Sujets d'un module et d'un nom de forum donn�, nomForum E {Cours,Partiels,Travaux Pratique,Travaux Dirig�} pour forum.type = vieScolaire
	 */
	public List<Sujet> recupererSujets(Module m, String nomForum){
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
