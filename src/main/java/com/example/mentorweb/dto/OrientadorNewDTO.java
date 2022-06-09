package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Administrador;



public class OrientadorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String NomeCompleto;
	

	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;
	
	private Administrador AdmiId;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=1,max=10, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Siape;
	
	
	public OrientadorNewDTO() {
		
	}
	public Administrador getAdmiId() {
		return AdmiId;
	}


	public void setAdmiId(Administrador admiId) {
		AdmiId = admiId;
	}



	public String getNomeCompleto() {
		return NomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return Senha;
	}


	public void setSenha(String senha) {
		Senha = senha;
	}


	public String getSiape() {
		return Siape;
	}


	public void setSiape(String siape) {
		Siape = siape;
	}


	
	
}
