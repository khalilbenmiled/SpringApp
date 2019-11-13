package com.example.gestiondestock;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api/paiement")
public class PaiementRestAPI {

	private String title = "Hello, Im the gestion de paiements Microservice";

	@Autowired
	private PaiementService paiementService;

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

	@PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Paiement> createPaiement(@PathVariable(value = "id") int id, @RequestBody Paiement paiement) {

		return new ResponseEntity<>(paiementService.addPaiement(paiement, id), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Paiement> updatePaiement(@PathVariable(value = "id") int id,
			@RequestBody Paiement paiemente) {

		return new ResponseEntity<>(paiementService.updatePaiement(id, paiemente), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deletePaiement(@PathVariable(value = "id") int id) {

		return new ResponseEntity<>(paiementService.deletePaiement(id), HttpStatus.OK);
	}

}
