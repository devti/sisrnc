package rnc.sismedicao.controller.exception;

public class FalhaNaoEncontradaException extends Exception {

	private int id;
	
	public FalhaNaoEncontradaException(int id) {
		super("Falha não encontrada!");
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
