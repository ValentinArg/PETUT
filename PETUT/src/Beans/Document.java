package Beans;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Document {
	
	private int idDocument;
	private Sujet sujet;
	private Utilisateur utilisateur;
	//private Reponse reponse;
	private String nom;
	private String lien;
	private String date;
	
	public Document(int idDocument, String nom, String lien, String date) {
		super();
		this.idDocument = idDocument;
		this.nom = nom;
		this.lien = lien;
		this.date = date;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	

	
	
	
	
	
	
}
