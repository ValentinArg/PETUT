package Beans;

public class Topic {
	
	private int id;
	private String auteur;
	private String question;
	private String date;
	private int nbReponse;
	private String statut;

	
	public Topic(int id, String auteur,String question, String date, String statut) {
		super();
		this.id = id;
		this.auteur = auteur;
		this.question = question;
		this.date = date;
		this.statut = statut;
	}
	
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNbReponse() {
		return nbReponse;
	}
	public void setNbReponse(int nbReponse) {
		this.nbReponse = nbReponse;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	

}
