package br.jus.tjmt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name="vara", schema="protocolo" )
public class Vara implements Serializable {
	
	private static final long serialVersionUID = -1910115430420204944L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idvara")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}) 
	@JoinColumn(name = "idcomarca")
	@JsonBackReference
	private Comarca comarca;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinTable( name="vara_competencia", joinColumns=@JoinColumn(name="idvara"), inverseJoinColumns=@JoinColumn(name="idcompetencia") )	
	private List<Competencia> competencias;
	
	@OneToMany(mappedBy="vara", fetch=FetchType.LAZY,cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Processo> processosRecebidos;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Comarca getComarca() {
		return comarca;
	}
	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}
	public List<Competencia> getCompetencias() {
		return competencias;
	}
	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}
	public List<Processo> getProcessosRecebidos() {
		return processosRecebidos;
	}
	public void setProcessosRecebidos(List<Processo> processosRecebidos) {
		this.processosRecebidos = processosRecebidos;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comarca == null) ? 0 : comarca.hashCode());
		result = prime * result + ((competencias == null) ? 0 : competencias.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vara other = (Vara) obj;
		if (comarca == null) {
			if (other.comarca != null)
				return false;
		} else if (!comarca.equals(other.comarca))
			return false;
		if (competencias == null) {
			if (other.competencias != null)
				return false;
		} else if (!competencias.equals(other.competencias))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
