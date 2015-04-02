package rnc.sismedicao.controller.exception;

public class UsuarioJaCadastradoException extends Exception {

	private String CPF;

	public UsuarioJaCadastradoException(String CPF) {
		super("CPF " + CPF + " J� Cadastrado");
		this.CPF = CPF;
	}

	public String getCPF() {
		return CPF;
	}

}
