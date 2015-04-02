package rnc.sismedicao.model.beans;

public class Endereco {
	
	private int codEndereco;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	
	
	public Endereco(String rua, String bairro, String cidade, String cep) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		
	}
	
	public Endereco(){
		
	}
	
	
	public int getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
}
