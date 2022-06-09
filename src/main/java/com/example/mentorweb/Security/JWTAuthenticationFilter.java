package com.example.mentorweb.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import com.example.mentorweb.dto.CredenciaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper; 



public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	

	private  AuthenticationManager authenticationMenager;
	
	private JWTUtil jwtUtil;
	
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationMenager,JWTUtil jwtUtil) {
		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authenticationMenager = authenticationMenager;
		this.jwtUtil = jwtUtil;
	}

	// PEGA AS CREDENCIAIS E VERIFICA SE ESTÁ TUDO OK 
	
	@Override
	public  Authentication attemptAuthentication (HttpServletRequest req, //PASSA OS DADOS
															HttpServletResponse res) throws AuthenticationException {
	
		
		try {
			//PEGA OS DADOS PASSADOS PELA REQUISIÇAO
			CredenciaisDTO  creds = new ObjectMapper()
					.readValue(req.getInputStream(),CredenciaisDTO.class);
			
			//INSTANCIA O OBJETO DA CLASS CREDENCIAISDTO
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
																//FAZ A BUSCA PRA VER SE ESTÁ TUDO DENTRO DA VALIDAÇÃO
			Authentication auth = authenticationMenager.authenticate(authToken);
			// INFORMA SE A REQUISIÇAO OCORREU COM SUCESSO OU NÃO.
			return auth;
		}
	
		catch(IOException e ) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	protected void  successfulAuthentication(HttpServletRequest req,
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth) throws IOException, ServletException {
		
String username = ((UserSS) auth.getPrincipal()).getUsername();
String token  = jwtUtil.generateToken(username);
res.addHeader("Authorization","Bearer" + token);
			
	}
	
	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
		 
		
		
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            response.setStatus(401);
            response.setContentType("application/json"); 
            response.getWriter().append(json());
        }
        
        private String json() {
            long date = new Date().getTime();
            return "{\"timestamp\": " + date + ", "
                + "\"status\": 401, "
                + "\"error\": \"Não autorizado\", "
                + "\"message\": \"Email ou senha inválidos\", "
                + "\"path\": \"/login\"}";
        }
    }
}

