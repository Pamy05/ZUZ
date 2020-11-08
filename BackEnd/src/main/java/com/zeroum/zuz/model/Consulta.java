package com.zeroum.zuz.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_CONSULTA")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataconsulta;
	
	@NotNull
	@Size(max = 300)
	private String descricao;
	
	@ManyToOne
	@JsonIgnoreProperties("consulta")
	private User usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataconsulta() {
		return dataconsulta;
	}

	public void setDataconsulta(Date dataconsulta) {
		this.dataconsulta = dataconsulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
}
