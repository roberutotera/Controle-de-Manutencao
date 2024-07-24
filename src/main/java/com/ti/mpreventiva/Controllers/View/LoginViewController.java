package com.ti.mpreventiva.Controllers.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class LoginViewController {
	
	@GetMapping("/login")
	public String EfetuarLogin() {
		return "login"; // Retorna o caminho correto do arquivo HTML
	}

}
