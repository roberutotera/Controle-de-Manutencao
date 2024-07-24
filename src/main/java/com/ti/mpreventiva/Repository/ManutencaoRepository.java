package com.ti.mpreventiva.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ti.mpreventiva.Entities.Manutencao;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
	
	/*@Query(value = "SELECT tecnico.nome, manutencao.chamado, manutencao.data_manutencao, computador.nome_computador, computador.fabricante, computador.modelo, computador.service_tag, computador.unidade, computador.setor, manutencao.data_manutencao_anterior, manutencao.data_manutencao_proxima, manutencao.status_manutencao, manutencao.estado ", nativeQuery = true)
	*/
	@Query(value = "SELECT manutencao \r\n"
			+ "FROM Manutencao manutencao \r\n"
			+ "    LEFT JOIN manutencao.tecnico \r\n"
			+ "    LEFT JOIN manutencao.computador\r\n"
			+ "ORDER BY manutencao.status_manutencao DESC" )
	List<Manutencao> findManutencoesComDetalhes();
	
}