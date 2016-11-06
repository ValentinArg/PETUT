package Beans;

import java.util.*;

import org.codehaus.jackson.annotate.JsonManagedReference;

public class Sujet{

	private int id;
	private String nom;
	private int numero;
	private List<Commentaire> listeCommentaire;
	
	public Sujet(int id, String nom, int numero) {
		super();
		this.listeCommentaire = new ArrayList<Commentaire>();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Commentaire> getListeCommentaire() {
		return listeCommentaire;
	}
	public void setListeCommentaire(List<Commentaire> listeCommentaire) {
		this.listeCommentaire = listeCommentaire;
	}

	
	
	

}
