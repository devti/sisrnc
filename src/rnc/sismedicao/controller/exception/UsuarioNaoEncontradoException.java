package rnc.sismedicao.controller.exception;

public class UsuarioNaoEncontradoException extends Exception {
	private int id;
	
	public UsuarioNaoEncontradoException(int id){
		super("Usu�rio n�o Encontrado!");
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}