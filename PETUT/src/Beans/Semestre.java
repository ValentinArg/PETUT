package Beans;

import java.util.*;

public class Semestre {

	private int id;
	private int numero;
	private List<Module> listeModuleEnseigne;
	public Semestre(int id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
		this.listeModuleEnseigne = new ArrayList<Module>();
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
	public List<Module> getListeModuleEnseigne() {
		return listeModuleEnseigne;
	}
	public void setListeModuleEnseigne(List<Module> listeModuleEnseigne) {
		this.listeModuleEnseigne = listeModuleEnseigne;
	}
	
	public void addListeModuleEnseigne(Module m) {
		this.listeModuleEnseigne.add(m);
	}
	
	
	
}
