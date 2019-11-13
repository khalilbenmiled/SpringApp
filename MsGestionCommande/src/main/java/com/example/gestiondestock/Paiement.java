package com.example.gestiondestock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Paiement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8713046434648764201L;
	@Id
	@GeneratedValue
	private int id;
	private String mode;
	private Date date_paiement;
	private double montant;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "facture_id", referencedColumnName = "id")
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
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Date getDate_paiement() {
		return date_paiement;
	}
	public void setDate_paiement(Date date_paiement) {
		this.date_paiement = date_paiement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	

}
