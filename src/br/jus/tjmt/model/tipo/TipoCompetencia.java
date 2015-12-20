package br.jus.tjmt.model.tipo;

public enum TipoCompetencia {

	FAMILIA(0,"Família"),
	FAZENDA(1,"Fazenda"),
	FALENCIA(2,"Falência"),
	FEITOS_GERAIS(4,"Feitos Gerais");
	
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
