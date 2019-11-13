package com.example.gestiondestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	
	public Commande addCommande(Commande commande) {
		return commandeRepository.save(commande);

	}

	public Commande updateCommande(int id, Commande newcommande) {

		if (commandeRepository.findById(id).isPresent()) {

			Commande existingCommande = commandeRepository.findById(id).get();
			existingCommande.setDate_commande(newcommande.getDate_commande());
			existingCommande.setDescription(newcommande.getDescription());

			return commandeRepository.save(existingCommande);
		} else
			return null;
	}

	public String deleteCommande(int id) {

		if (commandeRepository.findById(id).isPresent()) {

			commandeRepository.deleteById(id);
			return "commande supprimé";
		} else
			return "commande non supprimé";

	}
	
	


}
