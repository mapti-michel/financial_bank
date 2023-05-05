package com.acc.sistemabanco.controller.mapper;

import com.acc.sistemabanco.controller.dto.InserirTransacaoDto;
import com.acc.sistemabanco.model.Transacao;

public class TransacaoMapper {

	public static Transacao toTransacao(InserirTransacaoDto dto) {
		return Transacao.builder()
				.dataHoraMovimentacao(dto.getDataHoraMovimentacao())
				.tipoOperacao(dto.getTipoOperacao().getCodigo())
				.valor(dto.getValor())
				.build();
	}
}
