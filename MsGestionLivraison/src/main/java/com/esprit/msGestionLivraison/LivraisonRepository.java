package com.esprit.msGestionLivraison;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivraisonRepository extends JpaRepository<Livraison, Integer> {

	
	@Query(value = "SELECT * FROM Livraison l WHERE l.etatlivraison = 'Reçue' ", nativeQuery = true)		
	public Livraison getLivraisonsRecues();
	
	@Query(value = "SELECT * FROM Livraison l WHERE l.etatlivraison = 'Non Reçue'", nativeQuery = true)		
	public Livraison getLivraisonsNonRecues();
	
	@Query(value = "SELECT * FROM Livraison l WHERE l.etatlivraison = 'Annulée' ", nativeQuery = true)		
	public Livraison GetLivraisonsAnnulees();

	
	
}

