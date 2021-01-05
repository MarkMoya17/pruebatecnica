package com.banco.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.banco.jpa.OrdenPago;
import com.banco.jpa.Sucursal;
import com.banco.service.ISucursalService;
import com.banco.util.BDUtil;

public class SucursalServiceImpl implements ISucursalService{

	private EntityManager em;
	
	@Override
	public Sucursal registrar(Sucursal t) {
		Sucursal sucursal = new Sucursal(t.getNombre(), t.getDireccion(), t.getFechaRegistro(), t.getIdBanco());
		
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
	public Sucursal modificar(Sucursal t) {
		Sucursal sucursal = new Sucursal(t.getIdSucursal(), t.getNombre(), t.getDireccion(), t.getFechaRegistro(), t.getIdBanco());
		
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
	public Sucursal getById(Integer id) {
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		Sucursal sucursal=null;
		try {
			sucursal = this.em.find(Sucursal.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return sucursal;
	}
		

	@SuppressWarnings("unchecked")
	@Override
	public List<Sucursal> listar() {
		List<Sucursal> listaSucursales = new ArrayList<>();
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();		
		
		try {
			listaSucursales = this.em.createQuery("select b FROM Sucursal b").getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return listaSucursales;
	}

	@Override
	public void eliminar(Integer id) {

		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		Sucursal sucursal = em.find(Sucursal.class, id);
        
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
	public List<Sucursal> getListByIdBanco(Integer idBanco) {
		List<Sucursal> listaSucursales = new ArrayList<>();
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();		
		
		try {
			TypedQuery<Sucursal> query = this.em.createQuery("select op from Banco op "
	    			  					+ "WHERE op.idBanco= :idBanco", Sucursal.class);
			query.setParameter("idBanco", idBanco);
			listaSucursales=query.getResultList();
	         
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return listaSucursales;
	}


}
