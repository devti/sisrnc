package rnc.sismedicao.controller.exception;

public class CPFInvalidoException extends Exception {

	private String cpf;

	public CPFInvalidoException(String cpf) {
		super("CPF " + cpf + "Inv�lido");
		this.cpf = cpf;
	}
}
