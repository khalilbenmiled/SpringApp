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
public class Facture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8127406069139655286L;
	@Id
	@GeneratedValue
	private int id;
	private Date date_facture;
	private String description;
	private String etat;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    private Commande commande;
	@OneToOne(mappedBy = "facture")
	private Paiement paiement;
	
	
	
	
	
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_facture() {
		return date_facture;
	}
	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
