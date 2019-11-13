package com.esprit.msGestionLivraison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/livreur")
public class LivreurRestAPI {
	private String title = "Hello, I am the livreur Microservice";
	@Autowired
	private LivreurService livreurService;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

	
	@PostMapping(value="/affecterLivraison" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Livreur affecterLivraison(@Param(value="livraison") int livraison,@Param(value="livreur") int livreur) {
		return livreurService.affecterLivraison(livraison,livreur);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Livreur> createLivreur(@RequestBody Livreur livreur){
		return new ResponseEntity<>(livreurService.addLivreur(livreur) , HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Livreur> updateLivreur(@PathVariable(value = "id") int id , @RequestBody Livreur livreur){
		return new ResponseEntity<>(livreurService.updateLivreur(id, livreur), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteLivreur(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(livreurService.deleteLivreur(id), HttpStatus.OK);
	}
}
