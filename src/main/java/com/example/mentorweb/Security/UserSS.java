package com.example.mentorweb.Security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.mentorweb.enums.Perfil;

public class UserSS implements UserDetails  {
	private static final long serialVersionUID = 1L;
	 

	private Integer id;
	private String Email;
	private String Senha;	
	
	
	
	public  UserSS () {
		
	}
	
	
	
	
	
	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		Email = email;
		Senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}





	private Collection<? extends GrantedAuthority> authorities;
	
	public Integer getId() {
		return id;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return Senha;
	}

	@Override
	public String getUsername() {
		return Email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

