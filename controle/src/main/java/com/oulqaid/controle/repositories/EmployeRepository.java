package com.oulqaid.controle.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oulqaid.controle.entities.Employe;

import jakarta.persistence.Entity;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{

	//Generation des queries (les methodes predefinies ne sont pas accessibles)
    /* @Query(name="select nom,prenom from Employe e where id=?1")
     public Employe findByNom(Long id);
     
     @Query(name="select servicee from Service where id=?1")
     public Employe findByService(Long id);*/
     
}
