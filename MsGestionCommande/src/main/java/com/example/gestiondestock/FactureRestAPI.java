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
@RequestMapping(value = "/api/facture")
public class FactureRestAPI {

	private String title = "Hello, Im the gestion de factures Microservice";

	@Autowired
	private FactureService factureService;

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

	@PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Facture> createFacture(@PathVariable(value = "id") int id, @RequestBody Facture facture) {

		return new ResponseEntity<>(factureService.addFacture(facture, id), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Facture> updateFacture(@PathVariable(value = "id") int id, @RequestBody Facture facturee) {

		return new ResponseEntity<>(factureService.updateFacture(id, facturee), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteFacture(@PathVariable(value = "id") int id) {

		return new ResponseEntity<>(factureService.deleteFacture(id), HttpStatus.OK);
	}

}
