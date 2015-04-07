package rnc.sismedicao.controller.exception;

public class ItemNaoEncontradoException extends Exception {
	private int codItem;
	
	public ItemNaoEncontradoException (int codItem) {
		super("Item não encontrado!");
		this.codItem = codItem;
	}
	
	public int getCodItem() {
		return codItem;
	}
}
