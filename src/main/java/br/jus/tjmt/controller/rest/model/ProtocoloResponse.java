package br.jus.tjmt.controller.rest.model;

public class ProtocoloResponse {

	private boolean distribuicaoRealizada;
	private String MsgErro;
	
	private String numeroUnico;
	private String nomeVara;
	
	
	public boolean isDistribuicaoRealizada() {
		return distribuicaoRealizada;
	}
	public void setDistribuicaoRealizada(boolean distribuicaoRealizada) {
		this.distribuicaoRealizada = distribuicaoRealizada;
	}
	public String getMsgErro() {
		return MsgErro;
	}
	public void setMsgErro(String msgErro) {
		MsgErro = msgErro;
	}
	public String getNumeroUnico() {
		return numeroUnico;
	}
	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}
	public String getNomeVara() {
		return nomeVara;
	}
	public void setNomeVara(String nomeVara) {
		this.nomeVara = nomeVara;
	}
	
	
	
}
