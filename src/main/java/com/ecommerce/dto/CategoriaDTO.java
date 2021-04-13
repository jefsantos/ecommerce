package com.ecommerce.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.ecommerce.model.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private Integer id;
	
	@NotEmpty (message = "Não pode ser vazio")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		
		nome = obj.getNome();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
