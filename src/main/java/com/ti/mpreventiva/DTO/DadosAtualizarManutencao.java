package com.ti.mpreventiva.DTO;

import java.time.LocalDate;

import com.ti.mpreventiva.ENUMS.StatusManutencao;

public record DadosAtualizarManutencao(Long id_manutencao, String chamado, LocalDate data_manutencao, StatusManutencao status_manutencao) {

}
