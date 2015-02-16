package rnc.sismedicao.model.beans;

public class Item {
	
	private int id;
	private String descricao;
	private String marca;
	
	public Item() {

	}

	public Item(int id, String descricao, String marca) {
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
