package com.example.gestiondestock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
