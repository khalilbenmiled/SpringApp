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
public class Livraison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8127406069139655286L;
	@Id
	@GeneratedValue
	private int id;
	private Date date_livraison;
	private String etatlivraison;
	private Livreur livreur;
	private String fournisseur;
	private String commande;
	private int nbcommandes;
	
	public int getId() {
		return id;
	}
	
	

	public String getFournisseur() {
		return fournisseur;
	}



	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}



	public String getCommande() {
		return commande;
	}



	public void setCommande(String commande) {
		this.commande = commande;
	}



	public int getNbcommandes() {
		return nbcommandes;
	}



	public void setNbcommandes(int nbcommandes) {
		this.nbcommandes = nbcommandes;
	}



	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(Date date_livraison) {
		this.date_livraison = date_livraison;
	}

	public Livreur getLivreur() {
		return livreur;
	}
	public String getEtatlivraison() {
		return etatlivraison;
	}



	public void setEtatlivraison(String etatlivraison) {
		this.etatlivraison = etatlivraison;
	}



	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
