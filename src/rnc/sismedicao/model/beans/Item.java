package rnc.sismedicao.model.beans;

import java.util.List;

public class Item {
	
	private int codItem;
	private String nome;
	private String descricao;
	private String marca;
	private List<ItemMedicao> itemMedicao;
	private String serial;

	
	public Item(Item item) {

	}
	
	public Item (){
		
	}

	public Item(int codItem, String nome, String marca, String serial, String descricao) {
		this.codItem = codItem;
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.serial = serial;
	}
	
	public Item(String nome, String marca, String serial, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.marca = marca;
		this.serial = serial;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public List<ItemMedicao> getItemMedicao() {
		return itemMedicao;
	}

	public void setItemMedicao(List<ItemMedicao> itemMedicao) {
		this.itemMedicao = itemMedicao;
	}

	public void setSerial(String serial){
		this.serial = serial;
	}
	
	public String getSerial(){
		return serial;
	}
	
}
