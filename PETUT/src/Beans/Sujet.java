package Beans;

import java.util.*;

public class Sujet {
	
	private int id;
	private String nom;
	private int numero;
	private List<Document> listeDocuments;
	private List<Commentaire> listeCommentaire;
	public Sujet(int id, String nom, int numero, List<Document> listeDocuments, List<Commentaire> listeCommentaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
		this.listeDocuments = listeDocuments;
		this.listeCommentaire = listeCommentaire;
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
	public List<Document> getListeDocuments() {
		return listeDocuments;
	}
	public void setListeDocuments(List<Document> listeDocuments) {
		this.listeDocuments = listeDocuments;
	}
	public List<Commentaire> getListeCommentaire() {
		return listeCommentaire;
	}
	public void setListeCommentaire(List<Commentaire> listeCommentaire) {
		this.listeCommentaire = listeCommentaire;
	}
	
	
	

}
