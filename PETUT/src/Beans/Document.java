package Beans;

public class Document {
	
	private int idDocument;
	private int idSujet;
	private int idUtilisateur;
	private String nom;
	private String lien;
	private String date;
	
	public Document(int idDocument,String nom){
		this.idDocument = idDocument;
		this.nom = nom;
	}
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
	public int getIdSujet() {
		return idSujet;
	}
	public void setIdSujet(int idSujet) {
		this.idSujet = idSujet;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
