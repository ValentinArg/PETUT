package Beans;

public class Groupe {

	private int idgroupe;
	private int idsemestre;
	private String Libelle;
	
	public Groupe(int idgroupe, int idsemestre, String libelle) {
		super();
		this.idgroupe = idgroupe;
		this.idsemestre = idsemestre;
		Libelle = libelle;
	}

	public int getIdgroupe() {
		return idgroupe;
	}

	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}

	public int getIdsemestre() {
		return idsemestre;
	}

	public void setIdsemestre(int idsemestre) {
		this.idsemestre = idsemestre;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	
	
	
}
