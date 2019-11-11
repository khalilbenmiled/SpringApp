package com.esprit.msGestionEntrepot;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Entrepot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String lieu;
	private String rayon;
	private float taille;
	@OneToMany
	public List<Equipement> equipements;
	
	public List<Equipement> getEquipements() {
		return equipements;
	}
	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}
	public int getId() {
		return id;
	}
	public String getRayon() {
		return rayon;
	}
	public void setRayon(String rayon) {
		this.rayon = rayon;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public Entrepot(int id, String lieu, float taille) {
		super();
		this.id = id;
		this.lieu = lieu;
		this.taille = taille;
	}
	@Override
	public String toString() {
		return "Entrepot [id=" + id + ", lieu=" + lieu + ", taille=" + taille + "]";
	}
	public Entrepot() {
		super();
	}

	
	
	
}
