package br.jus.tjmt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.jus.tjmt.model.Comarca;

public class ComarcaDAO implements Serializable {

	private static final long serialVersionUID = 4383034807645098625L;

	@Inject
	private EntityManager em;
	
	public Comarca consultarComarcaPorID(Integer id){
		TypedQuery<Comarca> q = em.createQuery("FROM Comarca c WHERE c.id = :id", Comarca.class);
		q.setParameter("id", id);
		try{
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Comarca> listarTodas(){
		TypedQuery<Comarca> q = em.createQuery("FROM Comarca", Comarca.class);
		return q.getResultList();
	}
	
}
