package com.esprit.gestionProduit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/produits")
public class GestionProduitAPI {
	
	@Autowired
	public ProduitService produitService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@GetMapping
	public List<Produit> getAllProduit(){
		return produitService.getAllProduit();
	}
	
	@PostMapping
	public Produit addProduit(@RequestBody Produit produit) {
		return produitService.addProduit(produit);
	}
	
	@GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Produit getProduitById(@PathVariable(value="id") int id) {
		return produitService.getProduitById(id);
	}
	
	@GetMapping(value="ByLibelle/{libelle}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Produit getProduitByLibelle(@PathVariable(value="libelle") String libelle) {
		return produitService.getProduitByLibelle(libelle);
	}
	
	@GetMapping(value="ByLibelle" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Produit getProduitByLibelle2(@Param(value="libelle") String libelle) {
		return produitService.getProduitByLibelle(libelle);
	}
	
	@DeleteMapping(value="/{id}" ,produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteProduitById(@PathVariable(value="id") int id) {
		return produitService.deleteProduitById(id);
	}
	
	@PostMapping(value="/addProduitToStock" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock addProduitToStock(@Param(value="idP") int idP , @Param(value="idS") int idS) {
		return produitService.addProduitToStock(idP, idS);
	}
	
	
	
	
	
	
	
	
	
	
}
