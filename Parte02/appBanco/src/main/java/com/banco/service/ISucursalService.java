package com.banco.service;

import java.util.List;

import com.banco.jpa.Sucursal;

public interface ISucursalService extends ICRUD<Sucursal>{

	public List<Sucursal> getListByIdBanco(Integer idBanco);
	
}
