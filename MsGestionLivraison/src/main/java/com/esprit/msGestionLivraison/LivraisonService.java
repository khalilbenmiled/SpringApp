package com.esprit.msGestionLivraison;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonService {
	
	@Autowired
	private LivraisonRepository livraisonRepository;

	
	@Autowired
	private LivreurRepository livreurRepository;
	
	

	public Livraison addLivraison(String fournisseur,String commande,int nbcommandes) {
		//Fournisseur fournisseur = fournisseurRepository.findById(f).get();
		//System.out.println(fournisseur);		
		//Livreur livreur = livreurRepository.findById(liv).get();
		//Livreur ll = new Livreur();
		//ll.setId(livreur.getId());
	//	System.out.println(livreur);
		//Commande commande = commandeRepository.findById(c).get();
		//System.out.println(commande);
		Livraison livraison = new Livraison();
		//livraison.getListCommandes().add(commande);
		//livraison.setFournisseur(fournisseur);
		//livraison.setLivreur(livreur);
		livraison.setFournisseur(fournisseur);
		livraison.setCommande(commande);
		livraison.setNbcommandes(nbcommandes);
		livraison.setEtatlivraison("Non reçue");
		//livreur.getListLivraisons().add(livraison);
		
		return livraisonRepository.save(livraison);
	}
	
	
	public Livraison validerLivraison(int l)
	{
		
		Livraison livraison = livraisonRepository.findById(l).get();
		livraison.setEtatlivraison("Reçue");
		
		return livraisonRepository.save(livraison);
		
	}
	
	
	public Livraison annulerLivraison(int l)
	{
		
		Livraison livraison = livraisonRepository.findById(l).get();
		livraison.setEtatlivraison("Annulée");
		
		return livraisonRepository.save(livraison);
		
	}
	
	
	
	public List<Livraison> getAllLivraison(){
		return livraisonRepository.findAll();
	}
	
	public Livraison getLivraisonById(int id) {
		return livraisonRepository.findById(id).get();
	}
	

	
	public String deleteLivraisonById(int id) {
		if(livraisonRepository.findById(id).isPresent()) {
			livraisonRepository.delete(livraisonRepository.findById(id).get());
			return "Livraison supprimée";
		}
		else {
			return "Livraison n'existe pas";
		}
	}
}
