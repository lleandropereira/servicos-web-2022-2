package br.edu.ifsc.funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDataSource {

	private static List<Funcionario> listaFuncionarios = new ArrayList<>();
	
	public static void criarLista() {
		listaFuncionarios.add(new Funcionario(100, "Maria", 2100.0, 1));
		listaFuncionarios.add(new Funcionario(101, "Joao", 2200.0, 2));
		listaFuncionarios.add(new Funcionario(102, "Leandro", 2300.0, 3));
		listaFuncionarios.add(new Funcionario(103, "Luana", 2400.0, 4));
		listaFuncionarios.add(new Funcionario(104, "Cristina", 2500.0, 5));
	}
	
	public static List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	
	public static void novo(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
	}
	
	public static Funcionario getPorMatricula(int matricula) {
		for (Funcionario funcionario: listaFuncionarios) {
			if(funcionario.getMatricula() == matricula) {
				return funcionario;
			}
		}
		return null;
	}
}
