package com.esprit.msGestionClient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ContactRepository extends JpaRepository<Contact, Integer>{

	@Query(value = "SELECT co FROM Contact co WHERE co.type = :type", nativeQuery = true)		
	public Contact getContactByType(@Param("type") String type);
}