package Beans;

import java.util.*;

public class Commentaire extends Topic{
	
	private String texte;
	private List<Reponse> reponses;
	
	public Commentaire(int id, String auteur,String question, String date, int nbReponse, String statut, String texte) {
		super(id, auteur,question, date, nbReponse, statut);
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
