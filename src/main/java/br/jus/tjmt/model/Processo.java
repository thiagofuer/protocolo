package br.jus.tjmt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name="processo", schema="protocolo" )
public class Processo implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprocesso")
	private Integer id;
	
	@Column(name="numerounico")
	private String numeroUnico;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}) 
	@JoinColumn(name = "idclasse") 
	@JsonIgnore
	private ClasseProcessual classeProcessual;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}) 
	@JoinColumn(name = "idvara")
	@JsonBackReference
	private Vara vara;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroUnico() {
		return numeroUnico;
	}
	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}
	public ClasseProcessual getClasseProcessual() {
		return classeProcessual;
	}
	public void setClasseProcessual(ClasseProcessual classeProcessual) {
		this.classeProcessual = classeProcessual;
	}
	public Vara getVara() {
		return vara;
	}
	public void setVara(Vara vara) {
		this.vara = vara;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numeroUnico == null) ? 0 : numeroUnico.hashCode());
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
		Processo other = (Processo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroUnico == null) {
			if (other.numeroUnico != null)
				return false;
		} else if (!numeroUnico.equals(other.numeroUnico))
			return false;
		return true;
	}
	
	
	
	
}
