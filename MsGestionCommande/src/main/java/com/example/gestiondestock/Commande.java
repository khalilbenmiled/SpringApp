package com.example.gestiondestock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5177336526706009121L;
	@Id
	@GeneratedValue
	private int id;
	private Date date_commande;
	private String description;
	@OneToOne(mappedBy = "commande")
	private Facture facture;
	
	
	
	
	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Commande(String description) {
		super();
		this.description = description;
	}

	public Commande() {
	}

}
