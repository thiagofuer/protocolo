package br.jus.tjmt.bo;

import java.io.Serializable;

import javax.inject.Inject;

import br.jus.tjmt.dao.ClasseProcessualDAO;
import br.jus.tjmt.model.ClasseProcessual;

public class ClasseProcessualBO implements Serializable {

	private static final long serialVersionUID = -2149743676935143610L;

	@Inject
	private ClasseProcessualDAO dao;
	
	public ClasseProcessual consultarClassePorID(Integer idClasse){
		return dao.consultarClassePorID(idClasse);
	}
	
}
