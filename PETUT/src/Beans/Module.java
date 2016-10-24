package Beans;

public class Module {
	
	private int id;
	private String numero;
	private String libelle;
	private int ue;
	public Module(int id, String numero, String libelle, int ue) {
		super();
		this.id = id;
		this.numero = numero;
		this.libelle = libelle;
		this.ue = ue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getUe() {
		return ue;
	}
	public void setUe(int ue) {
		this.ue = ue;
	}
	
	

}
