package com.esprit.gestionProduit;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String codeStock;
	
	@OneToMany
	private List<Produit> listProduit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeStock() {
		return codeStock;
	}
	public void setCodeStock(String codeStock) {
		this.codeStock = codeStock;
	}
	public List<Produit> getListProduit() {
		return listProduit;
	}
	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", codeStock=" + codeStock + ", listProduit=" + listProduit + "]";
	}
	public Stock(int id, String codeStock, List<Produit> listProduit) {
		super();
		this.id = id;
		this.codeStock = codeStock;
		this.listProduit = listProduit;
	}
	public Stock(int id, String codeStock) {
		super();
		this.id = id;
		this.codeStock = codeStock;
	}
	public Stock() {
		super();
	}
	
	
}
