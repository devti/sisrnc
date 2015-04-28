package rnc.sismedicao.controller.exception;

public class GrupoTecnicoNaoEncontradoException extends Exception {
	private int codigo;
	
	public GrupoTecnicoNaoEncontradoException (int codigo) {
		super("Item não encontrado!");
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
