package br.jus.tjmt.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.jus.tjmt.model.Processo;

public class ProcessoDAO implements Serializable {

	private static final long serialVersionUID = 1749721065643410072L;

	@Inject
	private EntityManager em;
	
	public void salvar(Processo processo){
		if( processo.getId() != null )
			em.merge(processo);
		else
			em.persist(processo);
	}
	
}
