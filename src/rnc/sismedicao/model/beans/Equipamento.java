package rnc.sismedicao.model.beans;

public class Equipamento {

	private int codEquipamento;
	private String registro;
	private String descricao;
	private String obs;
	private Item item;

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
