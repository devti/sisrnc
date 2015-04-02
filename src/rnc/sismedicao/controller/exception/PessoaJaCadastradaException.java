package rnc.sismedicao.controller.exception;

public class PessoaJaCadastradaException extends Exception {

	private String CPF;

	public PessoaJaCadastradaException(String CPF) {
		super("CPF " + CPF + " J� Cadastrado");
		this.CPF = CPF;
	}

	public String getCPF() {
		return CPF;
	}
}
