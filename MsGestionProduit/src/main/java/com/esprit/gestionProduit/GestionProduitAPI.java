package com.esprit.gestionProduit;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




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
	
	
	@PutMapping(value="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Produit updateProduit(@PathVariable(value="id") int id, @RequestBody Produit produit) {
		return produitService.updateProduit(id, produit);
	}
	
	@GetMapping(value="categories" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllCategories() {
		final String uri = "http://192.168.99.100:3000/api";
	     
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    return result;
	}
	
	
	
	
	
	
	
	
	
}
