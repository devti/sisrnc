package rnc.sismedicao.model.beans;

import java.util.List;

public class Equipamento {

	private int codEquipamento;
	private String registro;
	private String descricao;
	private String obs;
	private List<Item> itens;

	public Equipamento(int codEquipamento, String registro, String descricao, String obs) {
		this.codEquipamento = codEquipamento;
		this.registro = registro;
		this.descricao = descricao;
		this.obs = obs;
	}

	public Equipamento(String registro, String descricao, String obs) {
		this.registro = registro;
		this.descricao = descricao;
		this.obs = obs;
	}
	
	public Equipamento (int codEquipamento, List<Item> itens) {
		this.codEquipamento = codEquipamento;
		this.itens = itens;
	}

	public Equipamento() {

	}

	public int getCodEquipamento() {
		return codEquipamento;
	}

	public void setCodEquipamento(int codEquipamento) {
		this.codEquipamento = codEquipamento;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
