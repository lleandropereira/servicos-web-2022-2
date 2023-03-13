package br.edu.ifsc.atividade;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//anotações
@RestController
public class Atividade4Controller {
	
	@RequestMapping(value = "/somar/{valor1}/{valor2}", method =  RequestMethod.GET)
	public Double somar(
			@PathVariable("valor1")Double valor1, 
			@PathVariable("valor2")Double valor2) {
		//Double resultado = valor1 + valor2;
		//return resultado;
		return valor1 + valor2;
	}
	
	@RequestMapping(value = "/subtrair/{op1}/{op2}", method = RequestMethod.GET)
	public Double subtrair(
			@PathVariable("op1")Double op1, 
			@PathVariable("op2")Double op2) {
		return op1 - op2;
	}
	
	@RequestMapping(value = "/multiplicar/{op1}/{op2}", method = RequestMethod.GET)
	public Double Multiplicar(
			@PathVariable("op1")Double op1, 
			@PathVariable("op2")Double op2) {
		return op1 * op2;
	}
}
