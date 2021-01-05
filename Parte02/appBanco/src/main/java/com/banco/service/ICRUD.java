package com.banco.service;

import java.util.List;

public interface ICRUD<T> {

	T registrar(T t);
	T modificar(T t);
	T getById(Integer id);
	List<T> listar();
	void eliminar(Integer id);
	
}