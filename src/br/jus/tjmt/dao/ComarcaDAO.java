package br.jus.tjmt.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.jus.tjmt.model.Comarca;

public class ComarcaDAO implements Serializable {

	private static final long serialVersionUID = 4383034807645098625L;

	@Inject
	private EntityManager em;
	
	public Comarca consultarComarcaPorID(Integer id){
		Query q = em.createQuery("FROM Comarca c WHERE c.id = :id");
		q.setParameter("id", id);
		try{
			return (Comarca) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
}
