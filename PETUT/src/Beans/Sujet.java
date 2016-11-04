package Beans;

import java.util.*;

public class Sujet {
	
	private int id;
	private String nom;
	private int numero;
	private Document sujet;
	private Document correction;
	private List<Document> listeDocumentsAImporter;
	private List<Commentaire> listeCommentaire;
	
	public Sujet(int id, String nom, int numero) {
		super();
		this.listeDocumentsAImporter = new ArrayList<Document>();
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
	public List<Document> getListeDocumentsAImporter() {
		return listeDocumentsAImporter;
	}
	public void addListeDocumentsAImporter(Document documentAImporter) {
		this.listeDocumentsAImporter.add(documentAImporter);
	}
	public List<Commentaire> getListeCommentaire() {
		return listeCommentaire;
	}
	public void setListeCommentaire(List<Commentaire> listeCommentaire) {
		this.listeCommentaire = listeCommentaire;
	}
	public Document getSujet() {
		return sujet;
	}
	public void setSujet(Document sujet) {
		this.sujet = sujet;
	}
	public Document getCorrection() {
		return correction;
	}
	public void setCorrection(Document correction) {
		this.correction = correction;
	}
	public void setListeDocumentsAImporter(List<Document> listeDocumentsAImporter) {
		this.listeDocumentsAImporter = listeDocumentsAImporter;
	}
	
	
	

}
