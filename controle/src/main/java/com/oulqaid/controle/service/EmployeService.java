package com.oulqaid.controle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oulqaid.controle.dao.IDao;
import com.oulqaid.controle.entities.Employe;
import com.oulqaid.controle.repositories.EmployeRepository;

@Service
public class EmployeService implements IDao<Employe> {

	@Autowired
	private EmployeRepository repository;

	@Override
	public Employe create(Employe o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Employe update(Employe o) {
		return repository.save(o);
	}

	@Override
	public Employe findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Employe> findAll() {
		return repository.findAll();
	}
	
	

}
