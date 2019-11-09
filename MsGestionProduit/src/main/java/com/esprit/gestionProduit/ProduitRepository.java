package com.esprit.gestionProduit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	@Query(value = "SELECT * FROM Produit p WHERE p.libelle = :libelle", nativeQuery = true)		
	public Produit getProduitByLibelle(@Param("libelle") String libelle);
}
