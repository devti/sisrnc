package rnc.sismedicao.model.beans;

public class Item {
	
	private int codItem;
	private String codCliente;
	private String nome;
	private String descricao;
	private String marca;
	
	public Item() {

	}

	public Item(int codItem, String descricao, String marca) {
		this.codItem = codItem;
		this.descricao = descricao;
		this.marca = marca;
	}
	
	public int getCodItem() {
		return codItem;
	}
	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
