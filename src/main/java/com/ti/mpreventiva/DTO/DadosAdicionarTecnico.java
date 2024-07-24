package com.ti.mpreventiva.DTO;

import com.ti.mpreventiva.ENUMS.TecnicoRole;

import jakarta.validation.constraints.NotBlank;

public record DadosAdicionarTecnico(
		Long id_tecnico,
		@NotBlank
	    String login,
	    @NotBlank
	    String senha,
	    
	    String nome,
	    TecnicoRole tecnicoRole ) {
	
	
}