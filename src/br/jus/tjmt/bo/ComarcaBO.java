package br.jus.tjmt.bo;

import java.io.Serializable;

import javax.inject.Inject;

import br.jus.tjmt.dao.ComarcaDAO;
import br.jus.tjmt.model.Comarca;

public class ComarcaBO implements Serializable{

	private static final long serialVersionUID = 5884100216719710797L;

	@Inject
	private ComarcaDAO dao;
	
	public Comarca consultarComarcaPorID(Integer id){
		return dao.consultarComarcaPorID(id);
	}
	
}
