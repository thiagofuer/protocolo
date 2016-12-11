package br.jus.tjmt.controller.rest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.jus.tjmt.bo.ClasseProcessualBO;
import br.jus.tjmt.bo.ComarcaBO;
import br.jus.tjmt.bo.ProcessoBO;
import br.jus.tjmt.controller.rest.model.ProtocoloResponse;
import br.jus.tjmt.model.ClasseProcessual;
import br.jus.tjmt.model.Comarca;
import br.jus.tjmt.model.Processo;

@Path("protocolo")
public class ProtocoloController {

	@Inject private ProcessoBO processoBO;
	@Inject private ComarcaBO comarcaBO;
	@Inject private ClasseProcessualBO classeBO;
	
	@POST
	@Path("/protocolar/{idclasse}/{idComarca}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProtocoloResponse protocolocar(@PathParam("idclasse") int pidClasse, @PathParam("idComarca") int pidComarca) throws Exception{
		ProtocoloResponse response = new ProtocoloResponse();
		try{
			Processo processo = processoBO.distribuirProcesso(Integer.valueOf(pidClasse), Integer.valueOf(pidComarca));
			response.setDistribuicaoRealizada(true);
			response.setNomeVara(processo.getVara().getNome());
			response.setNumeroUnico(processo.getNumeroUnico());
		}catch(Exception e){
			response.setDistribuicaoRealizada(false);
			response.setMsgErro(e.getMessage());
		}
		return response;
	}

	@GET
	@Path("/listarTodasComarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comarca> listarTodasComarcas(){
		List<Comarca> lista = comarcaBO.listarTodas(); 
		return lista;
	}

	@GET
	@Path("/listarTodasClassesProcessuais")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClasseProcessual> listarTodasClassesProcessuais(){
		List<ClasseProcessual> lista = classeBO.listarTodas(); 
		return lista;
	}
	
}
