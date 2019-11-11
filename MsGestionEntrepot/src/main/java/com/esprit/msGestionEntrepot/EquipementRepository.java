package com.esprit.msGestionEntrepot;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EquipementRepository extends JpaRepository<Equipement, Integer>{
	@Query(value = "SELECT * FROM Equipement p WHERE p.code = :code", nativeQuery = true)		
	public Equipement getEquipementByCode(@Param("code") String code);
}
