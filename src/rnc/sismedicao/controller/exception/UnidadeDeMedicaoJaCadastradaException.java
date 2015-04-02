package rnc.sismedicao.controller.exception;

public class UnidadeDeMedicaoJaCadastradaException extends Exception {
	
	private String codigo;

	public UnidadeDeMedicaoJaCadastradaException(String codigo) {
		super("Unidade " + codigo + " J� Cadastrado");
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
