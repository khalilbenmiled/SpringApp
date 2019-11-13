package com.esprit.msGestionLivraison;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivreurRepository extends JpaRepository<Livreur, Integer> {

	
	@Query(value = "SELECT * FROM Livreur l WHERE l.prenom = :prenom", nativeQuery = true)		
	public Livreur getLivreurByPrenom(@Param("prenom") String prenom);
}
