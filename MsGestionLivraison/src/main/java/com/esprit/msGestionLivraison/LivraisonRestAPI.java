package com.esprit.msGestionLivraison;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(value = "/api/livraison")
public class LivraisonRestAPI {

	private String title = "Hello, Im the gestion de livraisons Microservice";

	@Autowired
	private LivraisonService livraisonService;

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

	@PostMapping(value="/ajouterLivraison" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Livraison addLivraison(@Param(value="fournisseur") 
	String fournisseur,@Param(value="commande") String commande, @Param(value="nbcommandes") int nbcommandes) 
	{
		return livraisonService.addLivraison(fournisseur,commande,nbcommandes);
	}
	
	
	@GetMapping(value="/listerLivraisons" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Livraison> listerLivraisons() {
		return livraisonService.getAllLivraison();
	}
	
	@PostMapping(value="/validerLivraison" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Livraison addLivraison(@Param(value="l") int l) {
		return livraisonService.validerLivraison(l);
	}
	
	@PostMapping(value="/annulerLivraison" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Livraison annulerLivraison(@Param(value="l") int l) {
		return livraisonService.annulerLivraison(l);
	}
	
	
	
	@GetMapping(value="/getLivraisonById" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Livraison getLivraisonById(@Param(value="l") int l) {
		return livraisonService.getLivraisonById(l);
	}

	@DeleteMapping(value="/deleteLivraisonById" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteLivraisonById(@Param(value="l") int l) {
		return livraisonService.deleteLivraisonById(l);
	}

	
	
	
	
	
}
