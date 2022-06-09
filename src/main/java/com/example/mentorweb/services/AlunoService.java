package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mentorweb.domain.Aluno;
import com.example.mentorweb.domain.Orientador;
import com.example.mentorweb.dto.AlunoDTO;
import com.example.mentorweb.repositories.AlunoRepository;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {
	
	
	@Autowired
	private AlunoRepository repo;
	
public Aluno find(Integer id){
	Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Orientador.class.getName()));
	
//mostra mensagem de erro se o id não existir
	
	
}



//criação de metodo para utilizar o post, implementa um novo id automaticamente
public Aluno insert(Aluno obj) {
		obj.setId(null);
			return repo.save(obj);
	
}
//IMPLEMENTAÇÃO PUT, ATUALIZA AS INFORMAÇÕES
	public Aluno update(Aluno obj){
		find(obj.getId());
			return repo.save(obj);
	}
	
		
	
	//IMPLEMENTAÇÃO METODO DELETE
		public void delete(Integer id) {
			find(id);
			 repo.deleteById(id);
			}
	
		public Aluno fromDTO(AlunoDTO objDto) {
			return new Aluno(objDto.getId(), objDto.getNome(),objDto.getEmail(),null);
		}
		
		public List<Aluno> findAll(){
			return repo.findAll();
		} 												

}

