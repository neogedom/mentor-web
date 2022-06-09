package com.example.mentorweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorweb.domain.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
	
	@Transactional(readOnly=true)
	Administrador findByEmail(String email);
	
	}
