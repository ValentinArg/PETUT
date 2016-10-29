package Beans;

import java.util.*;

public class Forum {

	private int id;
	private String Type; // type = vie etudiante ou vie scolaire
	private String nom;
	private List<Sujet> listeSujets;
	
	public Forum(int id,String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Sujet> getListeSujets() {
		return listeSujets;
	}

	public void setListeSujets(List<Sujet> listeSujets) {
		this.listeSujets = listeSujets;
	}
	
	
	
	
}
