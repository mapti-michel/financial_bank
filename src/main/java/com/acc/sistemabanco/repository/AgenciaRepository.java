package com.acc.sistemabanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acc.sistemabanco.model.Agencia;

/**
 * Interface responsável pela operação de CRUD da classe Agencia
 * 
 * @author laissaalbuquerque@gmail.com
 *
 */
@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {

}
