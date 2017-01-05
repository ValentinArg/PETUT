package Beans;

import java.util.*;

/**
 * Class h�ritant de l'objet Topic. A eux deux elles traduisent la table Commentaire du sch�ma de donn�e
 * @author Groupe de Projet
 *
 */
public class Commentaire extends Topic{
	
	/**
	 * param�tre stockant le texte d'un commentaire
	 */
	private String texte;
	/**
	 * param�tre stockant la liste des r�ponses � ce commentaire
	 */
	private List<Reponse> reponses;
	
	/**
	 * Constructeur de la class commentaire. Utilise les param�tre de la class Topic
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
