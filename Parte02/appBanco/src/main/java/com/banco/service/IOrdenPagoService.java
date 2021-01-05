package com.banco.service;

import java.util.List;

import com.banco.jpa.OrdenPago;

public interface IOrdenPagoService extends ICRUD<OrdenPago>{
	
	public List<OrdenPago> getListByIdSucursal(Integer idSucursal, String moneda);
}
