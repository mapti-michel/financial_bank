package com.acc.sistemabanco.controller.mapper;

import com.acc.sistemabanco.controller.dto.AlterarNomeETelefonePessoaDto;
import com.acc.sistemabanco.controller.dto.InserirPessoaDto;
import com.acc.sistemabanco.model.Pessoa;

public class PessoaMapper {
	
	public static Pessoa toPessoa(InserirPessoaDto dto) {
		return Pessoa.builder()
				.cpf(dto.getCpf())
				.nome(dto.getNome())
				.telefone(dto.getTelefone())
				.build();
		}
	
	public static Pessoa toPessoa(AlterarNomeETelefonePessoaDto dto) {
		return Pessoa.builder()
				.nome(dto.getNome())
				.telefone(dto.getTelefone())
				.build();
	}
	
}
