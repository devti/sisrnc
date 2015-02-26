package rnc.sismedicao.controller.exception;

@SuppressWarnings("serial")
public class UsuarioNaoEncontradoException extends Exception {
	private int codUsuario;
	
	public UsuarioNaoEncontradoException(int codUsuario){
		super("Usu�rio n�o Encontrado!");
		this.codUsuario = codUsuario;
	}
	
	public int getId(){
		return codUsuario;
	}
}