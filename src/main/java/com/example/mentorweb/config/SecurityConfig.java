package com.example.mentorweb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.mentorweb.Security.JWTAuthenticationFilter;
import com.example.mentorweb.Security.JWTUtil;



@Configuration
@EnableWebSecurity				//EXTENDO UMA CLASSE 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	//DECLARANDO UM VETOR 
	private static  final String[] PUBLIC_MATCHERS = {
			
		
			//TUDO O QUE VIER DEPOIS DESSAS ANOTAÇÕES ESTÁ LIBERADO
			"/h2-console/**"  
						
	};
	//DECLARANDO UM VETOR 
	private static  final String[] PUBLIC_MATCHERS_GET = {
				
				//TUDO O QUE VIER DEPOIS DESSAS ANOTAÇÕES ESTÁ LIBERADO
				"/monitoria/**"  ,
				"/disciplina/**",
				"/administrador/**"
		};
	
	//METODO DA CLASE WebSecurityConfigurerAdapter ELE PODE LANÇAR UMA EXCEÇÃO
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//METODO PARA ACESSAR O BANCO DE DADOS H2
		if(Arrays.asList(env.getActiveProfiles()).contains("text")){
			http.headers().frameOptions().disable();
		}
		
		//DESABILITA CSRF.
		http.csrf().disable();
        http.headers().frameOptions().disable();
		
		
	http.cors();		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()//TUDO O QUE ESTIVER NESSE VETOR CAMINHO LIBERADO
				.anyRequest().authenticated();// O RESTO AUTENTICAÇÃO
						http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));	
						// http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
						http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	
	//PERMITO ACESSO AOS ENDPOINTS COM CONFIGURAÇÕES BASICAS
	@Bean
	 CorsConfigurationSource corsConfigurationSource() {
		
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
				return source;
	}
	
	
	
	//CRIANDO UMA SENHA ENCODADA
	@Bean
	public BCryptPasswordEncoder  bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}


