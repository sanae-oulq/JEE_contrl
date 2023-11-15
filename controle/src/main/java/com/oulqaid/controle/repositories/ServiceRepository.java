package com.oulqaid.controle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oulqaid.controle.entities.Employe;
import com.oulqaid.controle.entities.Servicee;

import jakarta.persistence.Entity;

@Repository
public interface ServiceRepository extends JpaRepository<Servicee, Long>{

}
