package br.jus.tjmt.controller.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.jus.tjmt.bo.CriarDadosBO;
import br.jus.tjmt.bo.ProcessoBO;
import br.jus.tjmt.model.Processo;

@Path("protocolar")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ProtocoloController {

	@Inject
	private CriarDadosBO criarBO;
	@Inject
	private ProcessoBO processoBO;
	
	@GET
	@Path("/novo/{idclasse}/{idComarca}")
	public String protocolocar(@PathParam("idclasse") String pidClasse, @PathParam("idComarca") String pidComarca) throws Exception{
		Integer idClasse = null;
		Integer idComarca = null;
		try{
			idClasse = Integer.valueOf(pidClasse);
			idComarca = Integer.valueOf(pidComarca);
		}catch(NumberFormatException e){
			return "Parametros informados invalidos";
		}
		Processo processo = processoBO.distribuirProcesso(idClasse, idComarca);
		return "Processo distribuido com sucesso para a vara: ".concat(processo.getVara().getNome().concat(", numero unico: ").concat(processo.getNumeroUnico()));
	}

	@GET
	@Path("/gerar")
	public String gerarDados(){
		criarBO.criarDados();
		return "dados gerados";
	}	
	
}
