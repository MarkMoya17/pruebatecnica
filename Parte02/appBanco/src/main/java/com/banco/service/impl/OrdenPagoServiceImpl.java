package com.banco.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.banco.jpa.OrdenPago;
import com.banco.service.IOrdenPagoService;
import com.banco.util.BDUtil;

public class OrdenPagoServiceImpl implements IOrdenPagoService{

	private EntityManager em;
		
	@Override
	public OrdenPago registrar(OrdenPago t) {
		OrdenPago sucursal = new OrdenPago(t.getMonto(), t.getMoneda(), t.getEstado(), t.getFechaPago(), t.getIdSucursal());
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		
		try {
			this.em.getTransaction().begin();
			this.em.persist(sucursal);
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return sucursal;
	}
	
	@Override
	public OrdenPago modificar(OrdenPago t) {
		OrdenPago sucursal = new OrdenPago(t.getIdSucursal(), t.getMonto(), t.getMoneda(), t.getEstado(), t.getFechaPago(), t.getIdSucursal());
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		
		try {
			this.em.getTransaction().begin();
	        this.em.merge(sucursal);
	        this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return sucursal;
	}
	
	@Override
	public OrdenPago getById(Integer id) {
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		OrdenPago sucursal=null;
		try {
			sucursal = this.em.find(OrdenPago.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return sucursal;
	}
		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenPago> listar() {
		List<OrdenPago> listaOrdenPagoes = new ArrayList<>();
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();		
		
		try {
			listaOrdenPagoes = this.em.createQuery("select b FROM OrdenPago b").getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return listaOrdenPagoes;
	}
	
	@Override
	public void eliminar(Integer id) {
	
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		OrdenPago sucursal = em.find(OrdenPago.class, id);
	    
		try {
			this.em.getTransaction().begin();
	        this.em.remove(sucursal);
	        this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		
	}
	
	@Override
	public List<OrdenPago> getListByIdSucursal(Integer idSucursal, String moneda) {
		
		List<OrdenPago> listaOrdenPago = new ArrayList<>();
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();		
		
		try {
			TypedQuery<OrdenPago> query = this.em.createQuery("select op from  OrdenesPago op "
	    			  					+ "WHERE op.idSucursal= :idSucursal AND op.moneda=:moneda", OrdenPago.class);
			query.setParameter("idSucursal", idSucursal);
			query.setParameter("moneda", moneda);
			listaOrdenPago=query.getResultList();
	         
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return listaOrdenPago;
		
	}

}
