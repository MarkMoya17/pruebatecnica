package com.banco.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.banco.jpa.Banco;
import com.banco.service.IBancoService;
import com.banco.util.BDUtil;

public class BancoServiceImpl implements IBancoService{

	private EntityManager em;
	
	@Override
	public Banco registrar(Banco t) {
		Banco banco = new Banco(t.getNombre(), t.getDireccion(), t.getFechaRegistro());
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		
		try {
			this.em.getTransaction().begin();
			this.em.persist(banco);
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return banco;
	}

	@Override
	public Banco modificar(Banco t) {
		Banco banco = new Banco(t.getIdBanco(), t.getNombre(), t.getDireccion(), t.getFechaRegistro());
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		
		try {
			this.em.getTransaction().begin();
	        this.em.merge(banco);
	        this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return banco;
	}

	@Override
	public Banco getById(Integer id) {
		
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		Banco banco=null;
		try {
			banco = this.em.find(Banco.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return banco;
	}
		

	@SuppressWarnings("unchecked")
	@Override
	public List<Banco> listar() {
		List<Banco> bancos = new ArrayList<>();
		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();		
		
		try {
			bancos = this.em.createQuery("select b FROM Banco b").getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		return bancos;
	}

	@Override
	public void eliminar(Integer id) {

		this.em = BDUtil.obtenerEntityManagerFactory().createEntityManager();
		Banco banco = em.find(Banco.class, id);
        
		try {
			this.em.getTransaction().begin();
	        this.em.remove(banco);
	        this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			this.em.close();
		}
		
	}

	
	
}
