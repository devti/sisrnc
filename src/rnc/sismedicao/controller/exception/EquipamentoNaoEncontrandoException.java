package rnc.sismedicao.controller.exception;

public class EquipamentoNaoEncontrandoException extends Exception {
	private int codEquipamento;
	
	public EquipamentoNaoEncontrandoException(int codEquipamento){
		super("Endereco não Encontrado!");
		this.codEquipamento = codEquipamento;
	}
	
	public int getCodEquipamento (){
		return codEquipamento;
	}
}
