package br.jus.tjmt.bo;

import java.io.Serializable;

import javax.inject.Inject;

import br.jus.tjmt.dao.VaraDAO;
import br.jus.tjmt.model.Vara;

public class VaraBO implements Serializable {

	private static final long serialVersionUID = 3474830260902681994L;

	@Inject
	private VaraDAO dao;
	
	public Vara consultarVaraPorID(Integer idVara){
		return dao.consultarVaraPorID(idVara);
	}
	
}
