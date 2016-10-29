package Beans;

import java.util.*;

public class Semestre {

	private int id;
	private int numero;
	private List<Ue> listeUe;
	public Semestre(int id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Ue> getListeUe() {
		return listeUe;
	}
	public void setListeUe(List<Ue> listeUe) {
		this.listeUe = listeUe;
	}
	
	
	
	
}
