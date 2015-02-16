package rnc.sismedicao.model.beans;

public class Local extends Endereco{
	
	private int tipo;

	public Local() {

	}

	public Local(String rua, String bairro, String cidade, String cep) {
		
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}
