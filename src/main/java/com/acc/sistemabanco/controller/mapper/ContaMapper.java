package com.acc.sistemabanco.controller.mapper;

import com.acc.sistemabanco.controller.dto.InserirContaDto;
import com.acc.sistemabanco.model.Conta;

public class ContaMapper {
	
	public static Conta toConta (InserirContaDto dto) {
		return Conta.builder()
				.numeroConta(dto.getNumeroConta())
				.digitoVerificador(dto.getDigitoVerificador())
				.build();
	}
}
