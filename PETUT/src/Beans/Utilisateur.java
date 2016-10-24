package Beans;

public class Utilisateur {
	
	private int identifiant;
	private String nom;
	private String adresse;
	private String telephone;
	private String mailPerso;
	private String mdp;
	private String mailSite;
	private Groupe groupe;
	public Utilisateur(int identifiant, String nom, String adresse, String telephone, String mailPerso, String mdp,
			String mailSite, Groupe groupe) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mailPerso = mailPerso;
		this.mdp = mdp;
		this.mailSite = mailSite;
		this.groupe = groupe;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMailPerso() {
		return mailPerso;
	}
	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getMailSite() {
		return mailSite;
	}
	public void setMailSite(String mailSite) {
		this.mailSite = mailSite;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
	
}
