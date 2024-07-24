package com.ti.mpreventiva.Controllers.APIRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.mpreventiva.DTO.DadosAutenticacao;
import com.ti.mpreventiva.Services.AutenticacaoService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {

	@Autowired
	private AutenticacaoService autenticacaoService;

	@PostMapping("/login")
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		return autenticacaoService.login(dados);
	}

}
