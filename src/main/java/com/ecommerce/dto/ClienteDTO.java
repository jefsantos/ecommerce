package com.ecommerce.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private Integer id;
	
	@NotEmpty (message = "Não pode ser vazio")
	@Size(min=5, max=30, message = "Não pode ser vazio nem menor")
	private String nome;
	
	@NotEmpty
	@Email(message = "email invalid")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getEmail();
		email = obj.getEmail();
		
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
	

}
