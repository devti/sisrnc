package rnc.sismedicao.controller.exception;

public class EnderecoNaoEncontradoException extends Exception {
	private int codEndereco;
	
	public EnderecoNaoEncontradoException(int codEndereco){
		super("Endereco não Encontrado!");
		this.codEndereco = codEndereco;
	}
	
	public int getCodEndereco (){
		return codEndereco;
	}
}

