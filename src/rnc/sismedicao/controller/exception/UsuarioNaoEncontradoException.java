package rnc.sismedicao.controller.exception;

public class UsuarioNaoEncontradoException extends Exception {
	private int id;
	
	public UsuarioNaoEncontradoException(int id){
		super("Usuário não Encontrado!");
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}