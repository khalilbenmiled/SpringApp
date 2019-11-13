package com.example.gestiondestock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementService {

	@Autowired
	private PaiementRepository paiementRepository;

	@Autowired
	private FactureRepository factureRepository;

	public Paiement addPaiement(Paiement paiement, int idF) {

		Facture facture = factureRepository.findById(idF).get();
		paiementRepository.save(paiement);
		paiement.setFacture(facture);
		facture.setEtat("Payée");
		return paiement;

	}

	public Paiement updatePaiement(int id, Paiement newpaiement) {

		if (paiementRepository.findById(id).isPresent()) {

			Paiement existingPaiement = paiementRepository.findById(id).get();
			existingPaiement.setDate_paiement(newpaiement.getDate_paiement());
			existingPaiement.setMode(newpaiement.getMode());
			existingPaiement.setMontant(newpaiement.getMontant());

			return paiementRepository.save(existingPaiement);
		} else
			return null;
	}

	public String deletePaiement(int id) {

		if (paiementRepository.findById(id).isPresent()) {

			paiementRepository.deleteById(id);
			return "paiement supprimé";
		} else
			return "paiement non supprimé";

	}

}
