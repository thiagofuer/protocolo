package br.jus.tjmt.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.jus.tjmt.model.ClasseProcessual;

public class ClasseProcessualDAO implements Serializable {

	private static final long serialVersionUID = 2164083483018593557L;

	@Inject
	private EntityManager em;
	
	public ClasseProcessual consultarClassePorID(Integer idClasse){
		TypedQuery<ClasseProcessual> q = em.createQuery("FROM ClasseProcessual classe JOIN FETCH classe.competencias comp WHERE classe.id = :id", ClasseProcessual.class);
		q.setParameter("id", idClasse);
		try{
			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<ClasseProcessual> listarTodas(){
		TypedQuery<ClasseProcessual> q = em.createQuery("FROM ClasseProcessual", ClasseProcessual.class);
		return q.getResultList();
	}
}
