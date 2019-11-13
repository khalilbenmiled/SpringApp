package com.example.gestiondestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureService {

	@Autowired
	private FactureRepository factureRepository;
	@Autowired
	private CommandeRepository commandeRepository;

	public Facture addFacture(Facture facture, int idC) {
		Commande commande = commandeRepository.findById(idC).get();
		factureRepository.save(facture);
		facture.setCommande(commande);
		facture.setEtat("Non payée");
		return facture;
	}

	public Facture updateFacture(int id, Facture newfacture) {

		if (factureRepository.findById(id).isPresent()) {

			Facture existingFacture = factureRepository.findById(id).get();
			existingFacture.setDate_facture(newfacture.getDate_facture());
			existingFacture.setDescription(newfacture.getDescription());

			return factureRepository.save(existingFacture);
		} else
			return null;
	}

	public String deleteFacture(int id) {

		if (factureRepository.findById(id).isPresent()) {

			factureRepository.deleteById(id);
			return "facture supprimé";
		} else
			return "facture non supprimé";

	}

}
