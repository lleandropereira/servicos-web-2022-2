package br.edu.ifsc.funcionario;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
	
	@RequestMapping(value = "/funcionario/{matricula}/{nome}/{salarioBase}/{numeroDependente}")
	public Funcionario cadastrarFuncionario(
			@PathVariable("matricula") int matricula,
			@PathVariable("nome") String nome,
			@PathVariable("salarioBase") double salarioBase,
			@PathVariable("numeroDependente") int numeroDependente) {
		
		Funcionario funcionario = new Funcionario(matricula, nome, salarioBase, numeroDependente);
		
		FuncionarioDataSource.novo(funcionario);
		
		return funcionario;
	}
	
	@RequestMapping(value = "/calcular_salario/{matricula}")
	public double calcularSalarioLiquido(
					@PathVariable("matricula") int matricula) {
		Funcionario funcionario = FuncionarioDataSource.getPorMatricula(matricula);
		return funcionario.calcularSalarioLiquido();
	}
	
	@RequestMapping(value = "funcionarios")
	public List<Funcionario> getFuncionarios() {
		return FuncionarioDataSource.getListaFuncionarios();
	}
	
	@RequestMapping(value = "/pesquisa/{matricula}")
	public Funcionario getPorMatricula(
			@PathVariable("matricula") int matricula) {
		return FuncionarioDataSource.getPorMatricula(matricula);
	}
}
