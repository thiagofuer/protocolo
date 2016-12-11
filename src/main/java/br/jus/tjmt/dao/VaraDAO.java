package br.jus.tjmt.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.jus.tjmt.model.Vara;

public class VaraDAO implements Serializable {

	private static final long serialVersionUID = -4070810597730963378L;

	@Inject
	private EntityManager em;
	
	public Vara consultarVaraPorID(Integer idVara){
		Query q = em.createQuery("FROM Vara v  WHERE v.id = :id");
		q.setParameter("id", idVara);
		try{
			return (Vara) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public void listarVarasPelaComarca(){
		
	}
	
	
}
