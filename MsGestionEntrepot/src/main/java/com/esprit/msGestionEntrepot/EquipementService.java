package com.esprit.msGestionEntrepot;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipementService {

	@Autowired
	 EquipementRepository equipementRepository;
	
	@Autowired
	 EntrepotRepository entrepotRepository;
	
	public Equipement addEquipement(Equipement e) {
		return equipementRepository.save(e);
	}
	
	public List<Equipement> getAllEquipement(){
		return equipementRepository.findAll();
	}
	
	public Equipement getEquipementById(int id) {
		return equipementRepository.findById(id).get();
	}
	
	public Equipement getEquipementByCode(String code) {
		return equipementRepository.getEquipementByCode(code);
	}
	
	public  Entrepot addEquipementToEntrepot(int idE,int idEntrepot) {
		Equipement equipement = equipementRepository.findById(idE).get();
		Entrepot e = entrepotRepository.findById(idEntrepot).get();
		e.getEquipements().add(equipement);
		return entrepotRepository.save(e);
		
	}
	
	public Equipement updateEquipement(int id,Equipement newProduit) {
		if(equipementRepository.findById(id).isPresent()) {
			Equipement existingProduit = equipementRepository.findById(id).get();
			if(newProduit.getLibelle() != null) {
				existingProduit.setLibelle(newProduit.getLibelle());
			}
			if(newProduit.getQuantite() != 0) {
				existingProduit.setQuantite(newProduit.getQuantite());
			}
			
			
			return equipementRepository.save(existingProduit);
		}else {
			return null;
		}
	}
	public Equipement updateQTEquipement(int id,int qt) {
		if(equipementRepository.findById(id).isPresent()) {
			Equipement existingProduit = equipementRepository.findById(id).get();
			
			
				existingProduit.setQuantite(qt);
			
			
			
			return equipementRepository.save(existingProduit);
		}else {
			return null;
		}
	}
}