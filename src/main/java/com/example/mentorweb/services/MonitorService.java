package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mentorweb.domain.Monitor;
import com.example.mentorweb.dto.MonitorDTO;
import com.example.mentorweb.repositories.MonitorRepository;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class MonitorService {
	
	
	@Autowired
	private MonitorRepository repo;
	
public Monitor find(Integer id){
	Optional<Monitor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Monitor.class.getName()));
	
//mostra mensagem de erro se o id não existir
	
	
}


//criação de metodo para utilizar o post, implementa um novo id automaticamente
public Monitor insert(Monitor obj) {
		obj.setId(null);
			return repo.save(obj);
	
}


//IMPLEMENTAÇÃO PUT, ATUALIZA AS INFORMAÇÕES
	public Monitor update(Monitor obj){
		find(obj.getId());
			return repo.save(obj);
	}
	
		
	
	//IMPLEMENTAÇÃO METODO DELETE
		public void delete(Integer id) {
			find(id);
			 repo.deleteById(id);
			}
		
	
		public Monitor fromDTO(MonitorDTO objDto) {
			return new Monitor(objDto.getId(), objDto.getNomeCompleto(),objDto.getDisciplina(),objDto.getEmail(),null);
		}
		
		
		public List<Monitor> findAll(){
			return repo.findAll();
		}

		
}

