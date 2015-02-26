package rnc.sismedicao.controller.exception;

public class PessoaNaoEncontradaException extends Exception {
	private int codPessoa;
	
	public PessoaNaoEncontradaException(int codPessoa){
		super("Pessoa não Encontrado!");
		this.codPessoa = codPessoa;
	}
	
	public int getCodPessoa(){
		return codPessoa;
	}
}