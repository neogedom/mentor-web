package com.example.mentorweb.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	
	private String Email;
	private String Senha;
	

	public CredenciaisDTO() {
		
	}
	
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	
	
	
	
	
	
}
