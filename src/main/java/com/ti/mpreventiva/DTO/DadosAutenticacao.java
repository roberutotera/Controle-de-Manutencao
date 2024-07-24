package com.ti.mpreventiva.DTO;

import com.ti.mpreventiva.Entities.Tecnico;

public record DadosAutenticacao(String login, String senha) {
	
	public DadosAutenticacao (Tecnico tecnico) {
		this(tecnico.getLogin(), tecnico.getSenha());
	}

	public String getLogin() {
		return login;
	}

	public Object getSenha() {
		return senha;
	}

}
