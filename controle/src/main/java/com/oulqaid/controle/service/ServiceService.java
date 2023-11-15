package com.oulqaid.controle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oulqaid.controle.dao.IDao;
import com.oulqaid.controle.entities.Servicee;
import com.oulqaid.controle.repositories.ServiceRepository;

@Service
public class ServiceService implements IDao<Servicee>{
	
	@Autowired
	private ServiceRepository repository;

	@Override
	public Servicee create(Servicee o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Servicee o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Servicee update(Servicee o) {
		return repository.save(o);
	}

	@Override
	public Servicee findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Servicee> findAll() {
		return repository.findAll();
	}
	

}
