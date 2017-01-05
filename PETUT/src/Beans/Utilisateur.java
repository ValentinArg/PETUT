package Beans;

import java.util.Date;

public class Utilisateur {
	
	private String id_Utilisateur;
	private String nom;
	private String prenom;
	private String mdp;
	private Date datenaissance;
	private String adresse;
	private int codepostal;
	private String ville;
	private String photo;
	private int telephone;
	private String adressemail;
	private String type;
	private int idgroupe;
	
	
	public Utilisateur(String id_Utilisateur, String nom, String prenom, String mdp, Date datenaissance, String adresse,
			int codepostal, String ville, String photo, int telephone, String adressemail,String type, int idgroupe) {
		super();
		this.id_Utilisateur = id_Utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.ville = ville;
		this.photo = photo;
		this.telephone = telephone;
		this.adressemail = adressemail;
		this.type = type;
		this.idgroupe = idgroupe;
	}


	public String getId_Utilisateur() {
		return id_Utilisateur;
	}


	public void setId_Utilisateur(String id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public Date getDatenaissance() {
		return datenaissance;
	}


	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getCodepostal() {
		return codepostal;
	}


	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public String getAdressemail() {
		return adressemail;
	}


	public void setAdressemail(String adressemail) {
		this.adressemail = adressemail;
	}


	public int getIdgroupe() {
		return idgroupe;
	}


	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}
	
	
	
}
