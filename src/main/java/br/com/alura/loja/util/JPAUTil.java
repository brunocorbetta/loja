package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//essa e a classe que cria meu entitymanager
public class JPAUTil {

	private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("loja");
	
	public static EntityManager getEntityManager() { 
	    return FACTORY.createEntityManager();

	} 
}