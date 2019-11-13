package com.esprit.msGestionLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreurService {

	@Autowired
	private LivreurRepository livreurRepository;
	
	@Autowired
	private LivraisonRepository livraisonRepository;
	
	public Livreur addLivreur(Livreur livreur) {
		return livreurRepository.save(livreur);
	}
	
	
	
	public Livreur affecterLivraison(int livraison,int livreur)
	{
		Livreur livreu = livreurRepository.findById(livreur).get();
		Livraison livrai = livraisonRepository.findById(livraison).get();
		//livrai.setId(8);
		livreu.getListLivraisons().add(livrai);
		
		return livreurRepository.save(livreu);
		
	}
	
	
	
	public Livreur updateLivreur(int id, Livreur newlivreur) {
		if(livreurRepository.findById(id).isPresent()) {
			Livreur existingCandidat = livreurRepository.findById(id).get();
			existingCandidat.setNom(newlivreur.getNom());
			existingCandidat.setDateDeNaissance(newlivreur.getDateDeNaissance());
			existingCandidat.setAdresse(newlivreur.getAdresse());
			existingCandidat.setPrenom(newlivreur.getPrenom());
			existingCandidat.setEmail(newlivreur.getEmail());
			
			return livreurRepository.save(existingCandidat);
		}else {
			return null;
		}
	}
	
	public String deleteLivreur(int id) {
		if(livreurRepository.findById(id).isPresent()) {
			livreurRepository.deleteById(id);
			return "Livreur supprimé";
		}else {
			return "Livreur non supprimé";
		}
	}
}
