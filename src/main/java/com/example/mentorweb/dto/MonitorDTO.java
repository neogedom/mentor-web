package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Monitor;

public class MonitorDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
 
	
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String NomeCompleto;
	
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=4,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Disciplina;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String RA;
	
	private String Email;
	
	
	
	public MonitorDTO() {
		
	}
	
	
public MonitorDTO(Monitor obj) {
	
	id = obj.getId();
	NomeCompleto = obj.getNomeCompleto();
	Disciplina = obj.getDisciplina();
	RA = obj.getRA();
	setEmail(obj.getEmail());
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




public String getDisciplina() {
	return Disciplina;
}


public void setDisciplina(String disciplina) {
	Disciplina = disciplina;
}


public String getRA() {
	return RA;
}

public void setRA(String rA) {
	RA = rA;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}



}
