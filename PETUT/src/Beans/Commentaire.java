package Beans;

import java.util.*;

/**
 * Class héritant de l'objet Topic. A eux deux elles traduisent la table Commentaire du schéma de donnée
 * @author Groupe de Projet
 *
 */
public class Commentaire extends Topic{
	
	/**
	 * paramètre stockant le texte d'un commentaire
	 */
	private String texte;
	/**
	 * paramètre stockant la liste des réponses à ce commentaire
	 */
	private List<Reponse> reponses;
	
	/**
	 * Constructeur de la class commentaire. Utilise les paramètre de la class Topic
	 * @param id
	 * @param auteur
	 * @param question
	 * @param date
	 * @param statut
	 * @param texte
	 */
	public Commentaire(int id, String auteur,String question, String date, String statut, String texte) {
		super(id, auteur,question, date, statut);
		this.texte = texte;
		this.reponses = new ArrayList<Reponse>();
	}
	

	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}
	public void addReponse(Reponse r){
		this.reponses.add(r);
	}
}
