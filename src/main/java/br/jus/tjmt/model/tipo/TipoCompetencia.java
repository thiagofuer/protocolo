package br.jus.tjmt.model.tipo;

public enum TipoCompetencia {

	FAMILIA(0,"Família"),
	FAZENDA(1,"Fazenda"),
	FALENCIA(2,"Falência"),
	INFANCIA(3,"Infância"),
	FEITOS_GERAIS(4,"Feitos Gerais Cíveis"),
	DIRETORIA(5,"Diretoria"),
	JUIZ_ESPE_CIVIL(6,"Juizado Especial Cível"),
	JUIZ_ESPE_CRIME(7,"Juizado Especial (Crime)");
	
	private Integer valor;
	private String descricao;
	
	TipoCompetencia(Integer valor, String descricao){
		this.valor = valor;
		this.descricao = descricao;
	}

	public Integer getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static synchronized TipoCompetencia getByStringValor(String valor){
		if( valor == null || valor.isEmpty() )
			return null;
		Integer novoValor = null;
		try{
			novoValor = Integer.valueOf(valor);
		}catch(NumberFormatException e){
			return null;
		}
		for(TipoCompetencia tipo : TipoCompetencia.values()  )
			if(tipo.getValor().equals(novoValor))
				return tipo;
		return null;
	}
	
}
