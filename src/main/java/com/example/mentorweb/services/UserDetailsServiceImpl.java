package com.example.mentorweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.mentorweb.Security.UserSS;
import com.example.mentorweb.domain.Administrador;
import com.example.mentorweb.repositories.AdministradorRepository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdministradorRepository repo;

	@Override
	public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
		Administrador adm1 = repo.findByEmail(Email);
		
		if (adm1 == null) {
			throw new UsernameNotFoundException(Email);
		}

		return new UserSS(adm1.getId(), adm1.getEmail(), adm1.getSenha(), adm1.getPerfis());
	}

}
