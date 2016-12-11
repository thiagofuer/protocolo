package br.jus.tjmt.dao.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {

    private EntityManagerFactory factory;
    
    public JPAUtil(){
    	factory = Persistence.createEntityManagerFactory("protocolo");
    }
    
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		EntityManager em = factory.createEntityManager();
		System.out.println("EMCriada: "+em);
		return em;
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		 System.out.println("closeEntityManager: " + manager);
		manager.close();
	}  	
	
}
