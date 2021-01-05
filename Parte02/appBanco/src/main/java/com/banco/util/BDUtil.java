package com.banco.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BDUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "persistence-bancodb";
    
    private static EntityManagerFactory factory;

    public static EntityManagerFactory obtenerEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

}
