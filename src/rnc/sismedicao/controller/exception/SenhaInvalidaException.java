package rnc.sismedicao.controller.exception;

public class SenhaInvalidaException extends Exception {
	
	public SenhaInvalidaException(){
		super("Usu�rio ou Senha Inv�lida!");
	}

}