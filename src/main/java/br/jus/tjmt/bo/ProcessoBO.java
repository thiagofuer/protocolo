package br.jus.tjmt.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import br.jus.tjmt.dao.ProcessoDAO;
import br.jus.tjmt.dao.util.Transactional;
import br.jus.tjmt.model.ClasseProcessual;
import br.jus.tjmt.model.Comarca;
import br.jus.tjmt.model.Competencia;
import br.jus.tjmt.model.Processo;
import br.jus.tjmt.model.Vara;

public class ProcessoBO implements Serializable {

	private static final long serialVersionUID = 2600307629791663867L;
	@Inject
	private ClasseProcessualBO classeBO;
	@Inject
	private ComarcaBO comarcaBO;
	@Inject
	private ProcessoDAO dao;

	@Transactional
	public Processo distribuirProcesso(Integer idClasse, Integer idComarca) throws Exception{
		ClasseProcessual classe = classeBO.consultarClassePorID(idClasse);
		if( classe == null )
			throw new Exception("O proesso não foi distribuido, a classe informada não existe.");
		Comarca comarca = comarcaBO.consultarComarcaPorID(idComarca);
		if( comarca == null )
			throw new Exception("O proesso não foi distribuido, a comarca informada não existe.");
		Processo processo = new Processo();
		processo.setClasseProcessual(classe);
		processo.setVara(selecionarVaraDestino(classe, comarca));
		int random = (int )(Math.random() * 100 + 1);
		processo.setNumeroUnico(String.valueOf(random));
		dao.salvar(processo);
		return processo;
	}
	
	private Vara selecionarVaraDestino(ClasseProcessual classe, Comarca comarca ) throws Exception{
		boolean comarcaUnica = comarca.getVaras().size() == 1;
		if(comarcaUnica)
			return comarca.getVaras().get(0);
		List<Vara> listaVarasDaCompetencia = selecionarVarasDaCompetencia(classe, comarca.getVaras());
		if( listaVarasDaCompetencia.size() < 1 )
			throw new Exception("Não foi encontrada nenhuma vara para competencia do processo");
		return obterVaraComMenorCarga(listaVarasDaCompetencia);
	}
	
	private List<Vara> selecionarVarasDaCompetencia(ClasseProcessual classe, List<Vara> varas){
		Set<Vara> varasDaCompetencia = new HashSet<Vara>();
		for(Vara varaAtual : varas){
			for( Competencia competenciaVara : varaAtual.getCompetencias() ){
				for(Competencia competenciaClasse : classe.getCompetencias())
					if( competenciaVara.getTipoCompetencia().getValor().equals(competenciaClasse.getTipoCompetencia().getValor()) )
						varasDaCompetencia.add(varaAtual);
			}
		}
		List<Vara> listaRetorno = new ArrayList<Vara>();
		listaRetorno.addAll(varasDaCompetencia);
		return listaRetorno;
	}
	
	private Vara obterVaraComMenorCarga(List<Vara> varas){
		int menorQtde = 0;
		Vara varaMenorQuantidade = null;
		for(Vara varaAtual : varas){
			if(menorQtde == 0){
				menorQtde = varaAtual.getProcessosRecebidos().size();
				varaMenorQuantidade = varaAtual;
			}
			if(varaAtual.getProcessosRecebidos().size() < menorQtde){
				menorQtde = varaAtual.getProcessosRecebidos().size();
				varaMenorQuantidade = varaAtual;
			}
		}
		return varaMenorQuantidade;
	}
	
}
