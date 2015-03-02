package rnc.sismedicao.controller.exception;

public class SenhaInvalidaException extends Exception {
	
	public SenhaInvalidaException(){
		super("Usuário ou Senha Inválida!");
	}

}