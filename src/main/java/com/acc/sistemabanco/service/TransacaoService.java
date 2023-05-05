package com.acc.sistemabanco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.sistemabanco.model.Conta;
import com.acc.sistemabanco.model.Transacao;
import com.acc.sistemabanco.model.enums.TipoOperacaoEnum;
import com.acc.sistemabanco.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ContaService contaService;
	
	public Transacao cadastrarTransacao(Transacao transacao, Integer idConta) {
		
		Conta conta = contaService.buscarContaPorId(idConta);
		
		transacao.setConta(conta);
		
		if (TipoOperacaoEnum.toEnum(transacao.getTipoOperacao()) == TipoOperacaoEnum.DEPOSITO) {
			contaService.realizarDeposito(conta.getIdConta(), transacao.getValor());
			
		} else if (TipoOperacaoEnum.toEnum(transacao.getTipoOperacao()) == TipoOperacaoEnum.SAQUE) {
			contaService.realizarSaque(conta.getIdConta(), transacao.getValor());
			
		}		
		return transacaoRepository.save(transacao);
	}
	
	public void cadastrarTransferencia(Integer numContaOrigem, Integer numContaDestino, Transacao transacaoOrigem, Transacao transacaoDestino) {
		Conta contaOrigem = contaService.buscarContaPorNumero(numContaOrigem);
		Conta contaDestino =  contaService.buscarContaPorNumero(numContaDestino);
		
		transacaoOrigem.setConta(contaOrigem);
		transacaoDestino.setConta(contaDestino);
		
		contaService.realizarTransferencia(contaOrigem, contaDestino, transacaoOrigem.getValor());
		
		transacaoRepository.save(transacaoOrigem);
		transacaoRepository.save(transacaoDestino);		
	}
	
	//public List<Transacao>  

}
