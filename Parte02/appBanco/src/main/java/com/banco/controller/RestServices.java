package com.banco.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.banco.jpa.Banco;
import com.banco.jpa.OrdenPago;
import com.banco.jpa.Sucursal;
import com.banco.service.IBancoService;
import com.banco.service.IOrdenPagoService;
import com.banco.service.ISucursalService;
import com.banco.service.impl.BancoServiceImpl;
import com.banco.service.impl.OrdenPagoServiceImpl;
import com.banco.service.impl.SucursalServiceImpl;

public class RestServices {

	private IBancoService serviceBanco = new BancoServiceImpl();
	private IOrdenPagoService serviceOrdenPago = new OrdenPagoServiceImpl();
	private ISucursalService serviceSucursal = new SucursalServiceImpl();
	
	/*
	 * Mantenimientos
	 * */
	
	@POST
	@Path("/banco/registrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Banco registrarBanco(Banco t) {
		return serviceBanco.registrar(t);
	}
	
	@GET
	@Path("/banco/listar")
	@Produces("application/json")
	public List<Banco> listarBanco() {
		return serviceBanco.listar();
	}
	
	@PUT
	@Path("/banco/actualizar")
	@Consumes("application/json")
	@Produces("application/json")
	public Banco modificarBanco(Banco t) {
		return serviceBanco.modificar(t);
	}
	
	@GET
	@Path("/banco/getById")
	public Banco getByIdBanco(@QueryParam("id") Integer id) {
		return serviceBanco.getById(id);
	}
	
	@DELETE
	@Path("/banco/eliminar")
	public void eliminarBanco(@QueryParam("id") Integer id) {
		serviceBanco.eliminar(id);
	}
	
	@POST
	@Path("/sucursal/registrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Sucursal registrarSucursal(Sucursal t) {
		return serviceSucursal.registrar(t);
	}
	
	@GET
	@Path("/sucursal/listar")
	@Produces("application/json")
	public List<Sucursal> listarSucursal() {
		return serviceSucursal.listar();
	}
	
	@PUT
	@Path("/sucursal/actualizar")
	@Consumes("application/json")
	@Produces("application/json")
	public Sucursal modificarSucursal(Sucursal t) {
		return serviceSucursal.modificar(t);
	}
	
	@GET
	@Path("/sucursal/getById")
	public Sucursal getByIdSucursal(@QueryParam("id") Integer id) {
		return serviceSucursal.getById(id);
	}
	
	@DELETE
	@Path("/sucursal/eliminar")
	public void eliminarSucursal(@QueryParam("id") Integer id) {
		serviceSucursal.eliminar(id);
	}
	
	
	@POST
	@Path("/ordenpago/registrar")
	@Consumes("application/json")
	@Produces("application/json")
	public OrdenPago registrarOrdenPago(OrdenPago t) {
		return serviceOrdenPago.registrar(t);
	}
	
	@GET
	@Path("/ordenpago/listar")
	@Produces("application/json")
	public List<OrdenPago> listarOrdenPago() {
		return serviceOrdenPago.listar();
	}
	
	@PUT
	@Path("/ordenpago/actualizar")
	@Consumes("application/json")
	@Produces("application/json")
	public OrdenPago modificarOrdenPago(OrdenPago t) {
		return serviceOrdenPago.modificar(t);
	}
	
	@GET
	@Path("/ordenpago/getById")
	public OrdenPago getByIdOrdenPago(@QueryParam("id") Integer id) {
		return serviceOrdenPago.getById(id);
	}
	
	@DELETE
	@Path("/ordenpago/eliminar")
	public void eliminarOrdenPago(@QueryParam("id") Integer id) {
		serviceOrdenPago.eliminar(id);
	}
	
	
	/*
	 * 
	 * listado de todas las ordenes de pago de una sucursal 
	 * contemplando el filtrado por tipo de moneda
	 * */
	@GET
	@Path("/ordenpago/getListByIdSucursal")
	@Produces("application/json")
	public List<OrdenPago> getOrdenesByIdSucursal(
											@QueryParam("idSucursal") Integer idSucursal,
											@QueryParam("moneda") String moneda) {
		return serviceOrdenPago.getListByIdSucursal(idSucursal, moneda);
	}
	
	
	/*
	 * 
	 * servicio web en formato XML que permita buscar 
	 * todas las sucursales de acuerdo con un banco
	 * */
	
	@GET
	@Path("/sucursal/getListByIdBanco")
	@Consumes("application/xml")
	@Produces("application/xml")
	public List<Sucursal> getSucursalByIdBanco(@QueryParam("idBanco") Integer idBanco){
		return serviceSucursal.getListByIdBanco(idBanco);
	}
	
	
}
