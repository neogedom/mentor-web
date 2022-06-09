package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Orientador;

public class OrientadorDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Integer id;
	

	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=8,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String NomeCompleto;

	@NotEmpty(message="Preenchimento obrigatório!")
	private String Email;
	

	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=1,max=10, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Siape;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;
	
	
	
	public OrientadorDTO() {
		
	}
	
public OrientadorDTO(Orientador obj){
	
	id = obj.getId();
	NomeCompleto = obj.getNomeCompleto();
	Email = obj.getEmail();
	Senha = obj.getSenha();
	Siape = obj.getSiape();
	
	
	
	
		
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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

public String getSiape() {
	return Siape;
}

public void setSiape(String siape) {
	Siape = siape;
}

public String getSenha() {
	return Senha;
}

public void setSenha(String senha) {
	Senha = senha;
}
	
	
	
	
	
	

}
