package com.ti.mpreventiva.Controllers.View;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ti.mpreventiva.Services.ManutencaoService;

@Controller
@RequestMapping("/project")
public class ManutencaoViewController {
	
	@Autowired
	private ManutencaoService manutencaoService;
	
	/*
	@GetMapping("/listar-todas-manutencoes")
	public String ListagemViewManutencoes() {
		return "listagemmanutencao"; // Retorna o caminho correto do arquivo HTML
	}
	*/
	
	
	@GetMapping("/listar-todas-manutencoes")
	public String getAllPreventivas(Model model) {
		model.addAttribute("manutencaos", manutencaoService.listarManutencoesFront());
		return "listagemmanutencao"; // Retorna o caminho correto do arquivo HTML
	}
	
	
}
