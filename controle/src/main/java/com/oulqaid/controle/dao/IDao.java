package com.oulqaid.controle.dao;

import java.util.List;

public interface IDao <T> {
	
	T create (T o);
	boolean delete (T o);
	T update (T o);
	T findById(Long id);
	List<T> findAll();
	

}

