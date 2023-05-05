package com.acc.sistemabanco.controller.mapper;

import com.acc.sistemabanco.controller.dto.AlterarAgenciaDto;
import com.acc.sistemabanco.controller.dto.InserirAgenciaDto;
import com.acc.sistemabanco.model.Agencia;

public class AgenciaMapper {
	
	public static Agencia toAgencia(InserirAgenciaDto dto) {
		return Agencia.builder()
				.nomeAgencia(dto.getNomeAgencia())
				.endereco(dto.getEndereco())
				.numeroAgencia(dto.getNumeroAgencia())
				.telefone(dto.getTelefone())
				.build();
	}
	
	public static Agencia toAgencia(AlterarAgenciaDto dto) {
		return Agencia.builder()
				.idAgencia(dto.getIdAgencia())
				.nomeAgencia(dto.getNomeAgencia())
				.endereco(dto.getEndereco())
				.numeroAgencia(dto.getNumeroAgencia())
				.telefone(dto.getTelefone())
				.build();
	}

}
