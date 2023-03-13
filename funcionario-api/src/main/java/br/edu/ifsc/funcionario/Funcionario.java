package br.edu.ifsc.funcionario;

public class Funcionario {
	
	private int matricula;
	private String nome;
	private double salarioBase;
	private int numeroDependente;
	
	public Funcionario() {
		
	}
	
	public Funcionario(int matricula, String nome, double salarioBase, int numeroDependente) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.numeroDependente = numeroDependente;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getNumeroDependente() {
		return numeroDependente;
	}

	public void setNumeroDependente(int numeroDependente) {
		this.numeroDependente = numeroDependente;
	}
	
	//=======================================================
	
	public double calcularSalarioLiquido() {
		double irpf = calcularIrpf();
		double salarioFamilia = calcularSalarioFamilia();
		double salarioLiquido = salarioBase - irpf + salarioFamilia;
		return salarioLiquido;
	}
	
	private double calcularIrpf() {
		if (salarioBase >= 8500.0) {
			return salarioBase * 0.275;
		} else if (salarioBase >= 5000) {
			return salarioBase * 0.15;
		} else {
			return 0.0;
		}
	}
	
	private double calcularSalarioFamilia() {
		return numeroDependente * 150.0;
	}
}
