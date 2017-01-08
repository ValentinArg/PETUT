package Beans;


public class Sujet{

	private int id;
	private String module;
	private String nom;
	private int numero;
	private String date;
	private String type; //CM, TD, TP...
	

	public Sujet(int id, String module, String nom, int numero, String date, String type) {
		super();
		this.id = id;
		this.module = module;
		this.nom = nom;
		this.numero = numero;
		this.date = date;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
