package com.acc.sistemabanco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.acc.sistemabanco.model.Agencia;
import com.acc.sistemabanco.repository.AgenciaRepository;
import com.acc.sistemabanco.service.exception.EntityNotFoundException;
import com.acc.sistemabanco.service.exception.NegocioException;

import lombok.SneakyThrows;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository repository;

	@SneakyThrows
	public Agencia cadastrarAgencia(Agencia agencia) {
		Agencia agenciaPersistida = repository.save(agencia);
		
		try {
			
			if (agenciaPersistida == null) {
				throw new NegocioException("Erro ao salvar agência");
			}
			
		}catch(Exception e) {
			System.out.print("Erro no exception. Mensagem: " + e.getMessage());
		}
			return agenciaPersistida;		
	}
	
	public List<Agencia> buscarTodasAsAgencias() {		
		return repository.findAll();
	}
	
	@SneakyThrows
	public Agencia buscarAgenciaPorId(Integer id) {
		try {
			return repository.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Agência não encontrada"));
			
		}catch(Exception e) {
			System.out.print("Erro no exception. Mensagem: " + e.getMessage());
		}
		return repository.findById(id).orElseThrow();		
	}
	
	@SneakyThrows
	public Agencia atualizarAgencia(Agencia agencia) {
		//buscarAgenciaPorId(agencia.getIdAgencia());
		Agencia agenciaAtualizada = repository.save(agencia);
		
		try {
			if (agenciaAtualizada == null) {
				throw new NegocioException("Erro ao atualizar agência");
			}
		}catch(Exception e){
			System.out.print("Erro no exception. Mensagem: " + e.getMessage());
		}
		return agenciaAtualizada;		
	}
	
	@SneakyThrows
	public void removerAgenciaPorId(Integer id) {
		try {
			repository.deleteById(id);
			if(id.equals(null)) {
				throw new EntityNotFoundException("É necessário informar um ID válido para exclusão da agência");
			}
		} catch (Exception e) {
			System.out.println("É necessário informar um ID válido para exclusão da agência");
		}		
	}
}
