package com.accenture.academico.sistemabanco.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_TRANSACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRANSACAO", unique = true)
	private Integer idTransacao;
	
	@Column(name = "DATA_HORA_MOVIMENTACAO", unique = true)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHoraMovimentacao;
	
	@Column(name = "TIPO_OPERACAO", unique = true)
	private Integer tipoOperacao;
	
	@Column(name = "VALOR", unique = true)
	@NotNull(message = "Valor não pode ser nulo!")
	private Double valor;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ID_CONTA", nullable = false, unique = true)
	private Conta conta;
	

}
