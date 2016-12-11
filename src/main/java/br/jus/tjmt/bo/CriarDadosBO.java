package br.jus.tjmt.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.jus.tjmt.dao.util.Transactional;
import br.jus.tjmt.model.ClasseProcessual;
import br.jus.tjmt.model.Comarca;
import br.jus.tjmt.model.Competencia;
import br.jus.tjmt.model.Processo;
import br.jus.tjmt.model.Vara;
import br.jus.tjmt.model.tipo.TipoCompetencia;

public class CriarDadosBO implements Serializable {

	private static final long serialVersionUID = -2688461150290627601L;
	@Inject
	private EntityManager em;
	
	@Transactional
	public void criarDados(){
		criarComarcas();
		em.persist(criarComarcas());
	}
	
	private Comarca criarComarcas(){
		Comarca comarca = new Comarca();
		comarca.setNome("Cuiabá");
		comarca.setVaras(criarVarasCuiaba(comarca));
		return comarca;
	}
	
	private List<Vara> criarVarasCuiaba(Comarca comarcaCuiaba){
		List<Vara> listaVaras = new ArrayList<Vara>();
		Vara vara = new Vara();
		vara.setNome("Quarta vara cível");
		vara.setComarca(comarcaCuiaba);
		vara.setCompetencias(criarCompetenciasQuartaVara());
		vara.setProcessosRecebidos(criarProcessoQuartaVara(vara));
		listaVaras.add(vara);
		
		vara = new Vara();
		vara.setNome("Sétima vara cível");
		vara.setComarca(comarcaCuiaba);
		vara.setCompetencias(criarCompetenciasSetimaVara());
		vara.setProcessosRecebidos(criarProcessoSetimaVara(vara));
		listaVaras.add(vara);		
		
		vara = new Vara();
		vara.setNome("Terceira vara cível");
		vara.setComarca(comarcaCuiaba);
		vara.setCompetencias(criarCompetenciasTerceiraVara());
		vara.setProcessosRecebidos(criarProcessoTerceiraVara(vara));
		listaVaras.add(vara);		
		
		return listaVaras;
	}
	
	private List<Competencia> criarCompetenciasQuartaVara(){
		List<Competencia> lista = new ArrayList<Competencia>();
		Competencia competencia = new Competencia();
		competencia.setTipoCompetencia(TipoCompetencia.FAMILIA);
		lista.add(competencia);
		competencia = new Competencia();
		competencia.setTipoCompetencia(TipoCompetencia.FAZENDA);
		lista.add(competencia);		
		competencia = new Competencia();
		competencia.setTipoCompetencia(TipoCompetencia.FALENCIA);
		lista.add(competencia);			
		return lista;
	}
	
	private List<Competencia> criarCompetenciasSetimaVara(){
		List<Competencia> lista = new ArrayList<Competencia>();
		Competencia competencia = new Competencia();
		competencia.setTipoCompetencia(TipoCompetencia.FAMILIA);
		lista.add(competencia);
		competencia = new Competencia();
		competencia.setTipoCompetencia(TipoCompetencia.FEITOS_GERAIS);
		lista.add(competencia);				
		return lista;
	}	
	
	private List<Competencia> criarCompetenciasTerceiraVara(){
		List<Competencia> lista = new ArrayList<Competencia>();
		Competencia competencia = new Competencia();
		competencia.setTipoCompetencia(TipoCompetencia.FAZENDA);
		lista.add(competencia);
			
		return lista;
	}		
	
	private List<Processo> criarProcessoQuartaVara(Vara vara){
		List<Processo> lista = new ArrayList<Processo>();
		lista.addAll(criarProcesso(10, TipoCompetencia.FAMILIA, vara));
		lista.addAll(criarProcesso(20, TipoCompetencia.FAZENDA, vara));
		lista.addAll(criarProcesso(2, TipoCompetencia.FALENCIA, vara));
		return lista;
	}
	
	private List<Processo> criarProcessoSetimaVara(Vara vara){
		List<Processo> lista = new ArrayList<Processo>();
		lista.addAll(criarProcesso(15, TipoCompetencia.FAMILIA, vara));
		lista.addAll(criarProcesso(16, TipoCompetencia.FEITOS_GERAIS, vara));
		return lista;
	}	

	private List<Processo> criarProcessoTerceiraVara(Vara vara){
		List<Processo> lista = new ArrayList<Processo>();
		lista.addAll(criarProcesso(23, TipoCompetencia.FAZENDA, vara));
		return lista;
	}
	
	private List<Processo> criarProcesso(int qtde, TipoCompetencia tipo, Vara vara){
		List<Processo> lista = new ArrayList<Processo>();
		for( int i = 0; i < qtde; i++ ){
			Processo processo = new Processo();
			int random = (int )(Math.random() * 100 + 1);
			processo.setNumeroUnico(String.valueOf(random));
			processo.setClasseProcessual(criarClasseProcessual(tipo));	
			processo.setVara(vara);
			lista.add(processo);
		}
		return lista;
	}
	
	private ClasseProcessual criarClasseProcessual(TipoCompetencia... tipos){
		ClasseProcessual classe = new ClasseProcessual();
		classe.setDescricao("Procedimento ABC");
		List<Competencia> lista = new ArrayList<Competencia>();
		for( TipoCompetencia tipoAtual : tipos ){
			Competencia com = new Competencia();
			com.setTipoCompetencia(tipoAtual);
			lista.add(com);
		}
		classe.setCompetencias(lista);
		return classe;
	}
	
}
