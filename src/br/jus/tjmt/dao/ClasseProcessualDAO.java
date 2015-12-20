package br.jus.tjmt.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.jus.tjmt.model.ClasseProcessual;

public class ClasseProcessualDAO implements Serializable {

	private static final long serialVersionUID = 2164083483018593557L;

	@Inject
	private EntityManager em;
	
	public ClasseProcessual consultarClassePorID(Integer idClasse){
		Query q = em.createQuery("FROM ClasseProcessual classe JOIN FETCH classe.competencias comp WHERE classe.id = :id");
		q.setParameter("id", idClasse);
		try{
			return (ClasseProcessual) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
}
