package com.acc.sistemabanco.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AlterarSaldo {

	@NotBlank(message = "Nome não pode ser nulo e nem vazio!")
	@Size(min = 3, max = 99999999, message = "Nome deve conter, no mínimo, 0.0")
	private double saldo;	
	
}
