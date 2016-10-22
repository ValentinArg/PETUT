package Beans;

import java.util.*;

public class Commentaire {
	
	private int id;
	private String libelleTopic;
	private String texte;
	private String date;
	private List<Commentaire> listeReponses;
	
	public Commentaire(int id, String libelleTopic, String texte, String date, List<Commentaire> enfants) {
		super();
		this.id = id;
		this.libelleTopic = libelleTopic;
		this.texte = texte;
		this.date = date;
		this.listeReponses = enfants;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelleTopic;
	}
	public void setLibelle(String libelleTopic) {
		this.libelleTopic = libelleTopic;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Commentaire> getEnfants() {
		return listeReponses;
	}
	public void setEnfants(List<Commentaire> enfants) {
		this.listeReponses = enfants;
	}

	
	
	
	

}
