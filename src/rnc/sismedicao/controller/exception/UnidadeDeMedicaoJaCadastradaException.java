package rnc.sismedicao.controller.exception;

public class UnidadeDeMedicaoJaCadastradaException extends Exception {
	
	private String codigo;

	public UnidadeDeMedicaoJaCadastradaException(String codigo) {
		super("Unidade " + codigo + " Já Cadastrado");
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
