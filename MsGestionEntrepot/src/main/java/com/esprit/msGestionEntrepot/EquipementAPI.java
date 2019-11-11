package com.esprit.msGestionEntrepot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/equipements")
public class EquipementAPI {
	
	@Autowired
	public EquipementService ps;

	
	
	@GetMapping
	public List<Equipement> getAllEquipement(){
		return ps.getAllEquipement();
	}
	
	@PostMapping
	public Equipement addEquipementt(@RequestBody Equipement e) {
		return ps.addEquipement(e);
	}
	
	@GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Equipement getEquipementById(@PathVariable(value="id") int id) {
		return ps.getEquipementById(id);
	}
	
	@GetMapping(value="ByCode/{code}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Equipement getProduitByLibelle(@PathVariable(value="code") String code) {
		return ps.getEquipementByCode(code);
	}
	
	
	
	
	
	@PostMapping(value="/addEToE" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Entrepot addEquipementToEntrepot(@Param(value="idP") int idP , @Param(value="idS") int idS) {
		return ps.addEquipementToEntrepot(idP, idS);
	}
	
	
	@PutMapping(value="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Equipement updateEquipement(@PathVariable(value="id") int id, @RequestBody Equipement e) {
		return ps.updateEquipement(id, e);}
	
	@PutMapping(value="/qt/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Equipement updateQtEquipement(@PathVariable(value="id") int id, @RequestBody int qt) {
		return ps.updateQTEquipement(id, qt);}
	
	
	}
	
	
	
	
	
	