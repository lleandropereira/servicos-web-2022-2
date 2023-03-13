package br.edu.ifsc.atividade;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Atividade4Controller {
	
	
	@RequestMapping(value = "/calcular_salario/{nome}/{salarioBase}/{dependentes}")
	public Double calcular(
			@PathVariable("nome")String nome,
			@PathVariable("salarioBase")Double salarioBase, 
			Double IR, 
			@PathVariable("dependentes")int dependentes) {
		if(salarioBase >= 8500)
			{
			IR = salarioBase * 0.275;
			};
		if(salarioBase >= 5000)
		{
			IR = salarioBase * 0.15;
		}
		else
		{
			IR = (double) 0;
		}
		Double salarioLiquido = salarioBase - IR + (dependentes*150);
		return salarioLiquido;
	}
	
}
