package com.esprit.gestionProduit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	StockRepository stockRepository;
	
	public Produit addProduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public List<Produit> getAllProduit(){
		return produitRepository.findAll();
	}
	
	public Produit getProduitById(int id) {
		return produitRepository.findById(id).get();
	}
	
	public Produit getProduitByLibelle(String libelle) {
		return produitRepository.getProduitByLibelle(libelle);
	}
	
	public String deleteProduitById(int id) {
		if(produitRepository.findById(id).isPresent()) {
			produitRepository.delete(produitRepository.findById(id).get());
			return "Produit supprimé";
		}
		else {
			return "Produit n'existe pas";
		}
	}
	
	public Stock addProduitToStock(int idP,int idS) {
		Produit produit = produitRepository.findById(idP).get();
		Stock stock = stockRepository.findById(idS).get();
		stock.getListProduit().add(produit);
		return stockRepository.save(stock);
		
	}

}
