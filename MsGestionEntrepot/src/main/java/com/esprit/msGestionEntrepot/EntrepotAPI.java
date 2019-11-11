package com.esprit.msGestionEntrepot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/entrepot")
public class EntrepotAPI {

	@Autowired
	public EntrepotService ES;
	
	@GetMapping
	public List<Entrepot> getAllEntrepot() {
		return ES.getAllEntrepot();
	}
	
	@PostMapping
	public Entrepot addEntrepot(@RequestBody Entrepot e) {
		return ES.addEntrepot(e);
	}
	
	@GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Entrepot getEntrepotById(@PathVariable(value="id") int id) {
		return ES.getEntrepotById(id);
	}
	
		@GetMapping(value="/{lieu}" , produces = MediaType.APPLICATION_JSON_VALUE)
		public Entrepot getEntrepotByLieu(@PathVariable(value="lieu") String lieu) {
			return ES.getEntrepotByLieu(lieu);
	}
	
	
	
	
	
}