package com.zeroum.zuz.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_USUARIO")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	private String nome;
	
	@NotNull
	private String usuario;
	
	@NotNull
	@Size(min = 11, max = 11)
	private String cpf;
	

	@NotNull
	@Size(min = 6)
	private String senha;
	
	private String foto;

	
	

	
	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	@OneToMany(mappedBy = "usuario" ,cascade = CascadeType.ALL)
	private List<Consulta> consulta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	


}
