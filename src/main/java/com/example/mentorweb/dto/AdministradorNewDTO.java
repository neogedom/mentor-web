package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class AdministradorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String NomeCompleto;

	@NotEmpty(message="Preenchimento obrigatório!")
	private String Email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=1,max=10, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Siape;
	
	private Integer OrienId;
	
	

	
	


	


	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;
	

	public AdministradorNewDTO() {
		
	}

	public Integer getOrienId() {
		return OrienId;
	}






	public void setOrienId(Integer orienId) {
		OrienId = orienId;
	}


	
	
	public String getNomeCompleto() {
		return NomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
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
