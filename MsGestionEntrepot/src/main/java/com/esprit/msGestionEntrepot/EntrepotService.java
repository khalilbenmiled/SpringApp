package com.esprit.msGestionEntrepot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrepotService {

	@Autowired
	public EntrepotRepository ER;
	
	public Entrepot addEntrepot(Entrepot E) {
		return ER.save(E);
	}
	
	public List<Entrepot> getAllEntrepot(){
		return ER.findAll();
	}
	
	public Entrepot getEntrepotById(int id) {
		return ER.findById(id).get();
	}
	
	public Entrepot getEntrepotByLieu(String lieu) {
		return ER.getEntrepotByLieu(lieu);
	}
	
	
}