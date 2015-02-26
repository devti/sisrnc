package rnc.sismedicao.controller.exception;

public class UsuarioNaoEncontradoException extends Exception {
	private int codUsuario;
	
	public UsuarioNaoEncontradoException(int codUsuario){
		super("Usuário não Encontrado!");
		this.codUsuario = codUsuario;
	}
	
	public int getId(){
		return codUsuario;
	}
}