package Beans;

public class Reponse {
	int id;
	String idUtilisateur;
	String texte;
	String date;
	public Reponse(int id, String idUtilisateur, String texte, String date) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		this.texte = texte;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
	
	
}
