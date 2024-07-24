
package com.ti.mpreventiva.Services;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ti.mpreventiva.DTO.DadosAutenticacao;
import com.ti.mpreventiva.DTO.DadosTokenJWT;
import com.ti.mpreventiva.Entities.Tecnico;
import com.ti.mpreventiva.Repository.TecnicoRepository;
import com.ti.mpreventiva.Security.SecurityConfiguration;

import jakarta.validation.Valid;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	@Lazy
	private SecurityConfiguration securityConfiguration;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private TokenService tokenService;

	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return tecnicoRepository.findByLogin(username);
	}

	public ResponseEntity<DadosTokenJWT>login (@RequestBody @Valid DadosAutenticacao dados){
		authenticationManager = context.getBean(AuthenticationManager.class);
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = authenticationManager.authenticate(token);
		var tokenJWT = tokenService.gerarToken((Tecnico)autenticacao.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
		
	}

}