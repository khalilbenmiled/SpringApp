package com.esprit.msGestionLivraison;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livreur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5177336526706009121L;
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private double telephone;
	private String adresse;
	@OneToMany
	private List<Livraison> listLivraisons= new ArrayList<Livraison>();
	
	

	public List<Livraison> getListLivraisons() {
		return listLivraisons;
	}
	public void setListLivraisons(List<Livraison> listLivraisons) {
		this.listLivraisons = listLivraisons;
	}
	private String email;	

	private Date dateDeNaissance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getTelephone() {
		return telephone;
	}
	public void setTelephone(double telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
