package com.acc.sistemabanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.sistemabanco.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
