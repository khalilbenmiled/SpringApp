package com.esprit.msGestionClient;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientRepository extends JpaRepository<Client, Integer>{

	
	@Query(value = "SELECT c FROM Clients c WHERE c.name = :name", nativeQuery = true)		
	public Client getClientByName(@Param("name") String name);
	
	

}