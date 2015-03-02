package rnc.sismedicao.controller.exception;

public class LocalNaoEncontradoException extends Exception {

	private int codLocal;
	
	public LocalNaoEncontradoException (int codLocal) {
		super("Local nao encontrado!");
		this.codLocal = codLocal;
	}
	
	public int getCodLocal(){
		return codLocal;
	}
}
