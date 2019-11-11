package com.esprit.msGestionEntrepot;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipement implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String libelle;
	private String code;
	private int Quantite;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantite() {
		return Quantite;
	}
	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Equipement [id=" + id + ", libelle=" + libelle + ", code=" + code + ", Quantite=" + Quantite + "]";
	}
	
	public Equipement(int id, String libelle, String code, int quantite) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		Quantite = quantite;
	}
	public Equipement() {
		super();
	}

}
